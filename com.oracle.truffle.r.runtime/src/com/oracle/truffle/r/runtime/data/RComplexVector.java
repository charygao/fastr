/*
 * Copyright (c) 2013, 2020, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 3 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 3 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 3 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */
package com.oracle.truffle.r.runtime.data;

import java.util.Arrays;

import com.oracle.truffle.api.profiles.ConditionProfile;
import com.oracle.truffle.r.runtime.RRuntime;
import com.oracle.truffle.r.runtime.RType;
import com.oracle.truffle.r.runtime.data.NativeDataAccess.NativeMirror;
import com.oracle.truffle.r.runtime.data.closures.RClosures;
import com.oracle.truffle.r.runtime.data.model.RAbstractComplexVector;
import com.oracle.truffle.r.runtime.data.model.RAbstractContainer;
import com.oracle.truffle.r.runtime.data.model.RAbstractVector;
import com.oracle.truffle.r.runtime.data.nodes.FastPathVectorAccess.FastPathFromComplexAccess;
import com.oracle.truffle.r.runtime.data.nodes.SlowPathVectorAccess.SlowPathFromComplexAccess;
import com.oracle.truffle.r.runtime.data.nodes.VectorAccess;
import com.oracle.truffle.r.runtime.ops.na.NACheck;
import com.oracle.truffle.r.runtime.data.RSharingAttributeStorage.Shareable;
import com.oracle.truffle.r.runtime.data.model.RAbstractVector.RMaterializedVector;

public final class RComplexVector extends RAbstractComplexVector implements RMaterializedVector, Shareable {

    private double[] data;

    RComplexVector(double[] data, boolean complete) {
        super(complete);
        assert data.length % 2 == 0;
        this.data = data;
        assert RAbstractVector.verifyVector(this);
    }

    RComplexVector(double[] data, boolean complete, int[] dims, RStringVector names, RList dimNames) {
        this(data, complete);
        initDimsNamesDimNames(dims, names, dimNames);
    }

    private RComplexVector() {
        super(false);
    }

    static RComplexVector fromNative(long address, int length) {
        RComplexVector result = new RComplexVector();
        NativeDataAccess.toNative(result);
        NativeDataAccess.setNativeContents(result, address, length);
        return result;
    }

    @Override
    public double[] getInternalManagedData() {
        return data;
    }

    @Override
    public double[] getInternalStore() {
        return data;
    }

    @Override
    public int getLength() {
        return NativeDataAccess.getDataLength(this, data);
    }

    @Override
    public void setLength(int l) {
        try {
            NativeDataAccess.setDataLength(this, data, l);
        } finally {
            data = null;
            setComplete(false);
        }
    }

    @Override
    public int getTrueLength() {
        return NativeDataAccess.getTrueDataLength(this);
    }

    @Override
    public void setTrueLength(int l) {
        NativeDataAccess.setTrueDataLength(this, l);
    }

    @Override
    public RAbstractVector castSafe(RType type, ConditionProfile isNAProfile, boolean keepAttributes) {
        switch (type) {
            case Complex:
                return this;
            case Character:
                return RClosures.createToStringVector(this, keepAttributes);
            case List:
                return RClosures.createToListVector(this, keepAttributes);
            default:
                return null;
        }
    }

    @Override
    public void setDataAt(Object store, int index, RComplex value) {
        assert data == store;
        NativeDataAccess.setData(this, (double[]) store, index, value.getRealPart(), value.getImaginaryPart());
    }

    @Override
    public void setDataAt(Object store, int index, double value) {
        assert data == store;
        NativeDataAccess.setData(this, (double[]) store, index, value);
    }

    @Override
    public RComplex getDataAt(int index) {
        return NativeDataAccess.getData(this, data, index);
    }

    @Override
    public RComplex getDataAt(Object store, int index) {
        return NativeDataAccess.getData(this, (double[]) store, index);
    }

    /**
     * Returns the double value under specified index assuming a representation where the complex
     * numbers are flattened to an array: real part followed by the imaginary part.
     */
    public double getRawDataAt(int index) {
        return NativeDataAccess.getRawComplexData(this, data, index);
    }

    @Override
    public double getComplexPartAt(int index) {
        return NativeDataAccess.getComplexPart(this, data, index);
    }

    @Override
    public double[] getDataCopy() {
        if (data != null) {
            return Arrays.copyOf(data, data.length);
        } else {
            return NativeDataAccess.copyComplexNativeData(getNativeMirror());
        }
    }

    @Override
    public double[] getReadonlyData() {
        if (data != null) {
            return data;
        } else {
            return NativeDataAccess.copyComplexNativeData(getNativeMirror());
        }
    }

    private RComplexVector updateDataAt(int index, RComplex value, NACheck rightNACheck) {
        assert !this.isShared();
        NativeDataAccess.setData(this, data, index, value.getRealPart(), value.getImaginaryPart());
        if (rightNACheck.check(value)) {
            setComplete(false);
        }
        assert !isComplete() || !RRuntime.isNA(value);
        return this;
    }

    @Override
    public RComplexVector updateDataAtAsObject(int i, Object o, NACheck naCheck) {
        return updateDataAt(i, (RComplex) o, naCheck);
    }

    @Override
    public RComplexVector materialize() {
        return this;
    }

    @Override
    public void transferElementSameType(int toIndex, RAbstractVector fromVector, int fromIndex) {
        RAbstractComplexVector other = (RAbstractComplexVector) fromVector;
        RComplex value = other.getDataAt(fromIndex);
        NativeDataAccess.setData(this, data, toIndex, value.getRealPart(), value.getImaginaryPart());
    }

    public long allocateNativeContents() {
        try {
            return NativeDataAccess.allocateNativeContents(this, data, getLength());
        } finally {
            data = null;
            setComplete(false);
        }
    }

    private static final class FastPathAccess extends FastPathFromComplexAccess {

        FastPathAccess(RAbstractContainer value) {
            super(value);
        }

        @Override
        protected RComplex getComplexImpl(AccessIterator accessIter, int index) {
            return RComplex.valueOf(getComplexRImpl(accessIter, index), getComplexIImpl(accessIter, index));
        }

        @Override
        protected double getComplexRImpl(AccessIterator accessIter, int index) {
            return hasStore ? ((double[]) accessIter.getStore())[index * 2] : NativeDataAccess.getComplexNativeMirrorDataR((NativeMirror) accessIter.getStore(), index);
        }

        @Override
        protected double getComplexIImpl(AccessIterator accessIter, int index) {
            return hasStore ? ((double[]) accessIter.getStore())[index * 2 + 1] : NativeDataAccess.getComplexNativeMirrorDataI((NativeMirror) accessIter.getStore(), index);
        }

        @Override
        protected void setComplexImpl(AccessIterator accessIter, int index, double real, double imaginary) {
            Object store = accessIter.getStore();
            if (hasStore) {
                ((double[]) store)[index * 2] = real;
                ((double[]) store)[index * 2 + 1] = imaginary;
            } else {
                NativeDataAccess.setNativeMirrorComplexRealPartData((NativeMirror) store, index, real);
                NativeDataAccess.setNativeMirrorComplexImaginaryPartData((NativeMirror) store, index, imaginary);
            }
        }
    }

    @Override
    public VectorAccess access() {
        return new FastPathAccess(this);
    }

    private static final SlowPathFromComplexAccess SLOW_PATH_ACCESS = new SlowPathFromComplexAccess() {
        @Override
        protected RComplex getComplexImpl(AccessIterator accessIter, int index) {
            RComplexVector vector = (RComplexVector) accessIter.getStore();
            return NativeDataAccess.getData(vector, vector.data, index);
        }

        @Override
        protected double getComplexRImpl(AccessIterator accessIter, int index) {
            RComplexVector vector = (RComplexVector) accessIter.getStore();
            return NativeDataAccess.getDataR(vector, vector.data, index);
        }

        @Override
        protected double getComplexIImpl(AccessIterator accessIter, int index) {
            RComplexVector vector = (RComplexVector) accessIter.getStore();
            return NativeDataAccess.getDataI(vector, vector.data, index);
        }

        @Override
        protected void setComplexImpl(AccessIterator accessIter, int index, double real, double imaginary) {
            RComplexVector vector = (RComplexVector) accessIter.getStore();
            NativeDataAccess.setData(vector, vector.data, index, real, imaginary);
        }
    };

    @Override
    public VectorAccess slowPathAccess() {
        return SLOW_PATH_ACCESS;
    }
}
