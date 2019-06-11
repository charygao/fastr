/*
 * Copyright (c) 2013, 2019, Oracle and/or its affiliates. All rights reserved.
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

import com.oracle.truffle.api.CompilerDirectives.ValueType;
import com.oracle.truffle.api.dsl.Cached;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.interop.UnsupportedMessageException;
import com.oracle.truffle.api.library.CachedLibrary;
import com.oracle.truffle.api.library.ExportLibrary;
import com.oracle.truffle.api.library.ExportMessage;
import com.oracle.truffle.api.profiles.ConditionProfile;
import com.oracle.truffle.r.runtime.RRuntime;
import com.oracle.truffle.r.runtime.RType;
import com.oracle.truffle.r.runtime.data.model.RAbstractContainer;
import com.oracle.truffle.r.runtime.data.model.RAbstractIntVector;
import com.oracle.truffle.r.runtime.data.model.RAbstractVector;
import com.oracle.truffle.r.runtime.data.nodes.FastPathVectorAccess.FastPathFromIntAccess;
import com.oracle.truffle.r.runtime.data.nodes.SlowPathVectorAccess.SlowPathFromIntAccess;
import com.oracle.truffle.r.runtime.data.nodes.VectorAccess;

@ValueType
@ExportLibrary(InteropLibrary.class)
public final class RInteger extends RAbstractIntVector implements RScalarVector {

    protected final int value;

    private RInteger(int value) {
        super(!RRuntime.isNA(value));
        this.value = value;
    }

    @ExportMessage
    boolean isNumber() {
        return !RRuntime.isNA(value);
    }

    @ExportMessage
    boolean fitsInByte(@CachedLibrary("this.value") InteropLibrary interop) {
        return isNumber() && interop.fitsInByte(value);
    }

    @ExportMessage
    byte asByte(@CachedLibrary("this.value") InteropLibrary interop,
                    @Cached.Shared("isNumber") @Cached("createBinaryProfile()") ConditionProfile isNumber) throws UnsupportedMessageException {
        if (!isNumber.profile(isNumber())) {
            throw UnsupportedMessageException.create();
        }
        return interop.asByte(value);
    }

    @ExportMessage
    boolean fitsInShort(@CachedLibrary("this.value") InteropLibrary interop) {
        return isNumber() && interop.fitsInShort(value);
    }

    @ExportMessage
    short asShort(@CachedLibrary("this.value") InteropLibrary interop,
                    @Cached.Shared("isNumber") @Cached("createBinaryProfile()") ConditionProfile isNumber) throws UnsupportedMessageException {
        if (!isNumber.profile(isNumber())) {
            throw UnsupportedMessageException.create();
        }
        return interop.asShort(value);
    }

    @ExportMessage
    boolean fitsInInt(@CachedLibrary("this.value") InteropLibrary interop) {
        return isNumber() && interop.fitsInShort(value);
    }

    @ExportMessage
    int asInt(@CachedLibrary("this.value") InteropLibrary interop,
                    @Cached.Shared("isNumber") @Cached("createBinaryProfile()") ConditionProfile isNumber) throws UnsupportedMessageException {
        if (!isNumber.profile(isNumber())) {
            throw UnsupportedMessageException.create();
        }
        return interop.asInt(value);
    }

    @ExportMessage
    boolean fitsInLong(@CachedLibrary("this.value") InteropLibrary interop) {
        return isNumber() && interop.fitsInLong(value);
    }

    @ExportMessage
    long asLong(@CachedLibrary("this.value") InteropLibrary interop,
                    @Cached.Shared("isNumber") @Cached("createBinaryProfile()") ConditionProfile isNumber) throws UnsupportedMessageException {
        if (!isNumber.profile(isNumber())) {
            throw UnsupportedMessageException.create();
        }
        return interop.asLong(value);
    }

    @ExportMessage
    boolean fitsInFloat(@CachedLibrary("this.value") InteropLibrary interop) {
        return isNumber() && interop.fitsInFloat(value);
    }

    @ExportMessage
    float asFloat(@CachedLibrary("this.value") InteropLibrary interop,
                    @Cached.Shared("isNumber") @Cached("createBinaryProfile()") ConditionProfile isNumber) throws UnsupportedMessageException {
        if (!isNumber.profile(isNumber())) {
            throw UnsupportedMessageException.create();
        }
        return interop.asFloat(value);
    }

    @ExportMessage
    boolean fitsInDouble(@CachedLibrary("this.value") InteropLibrary interop) {
        return isNumber() && interop.fitsInDouble(value);
    }

    @ExportMessage
    double asDouble(@CachedLibrary("this.value") InteropLibrary interop,
                    @Cached.Shared("isNumber") @Cached("createBinaryProfile()") ConditionProfile isNumber) throws UnsupportedMessageException {
        if (!isNumber.profile(isNumber())) {
            throw UnsupportedMessageException.create();
        }
        return interop.asDouble(value);
    }

    @Override
    public boolean isMaterialized() {
        return false;
    }

    @Override
    public int getLength() {
        return 1;
    }

    @Override
    public RAbstractVector copy() {
        return this;
    }

    public static RInteger createNA() {
        return new RInteger(RRuntime.INT_NA);
    }

    public static RInteger valueOf(int value) {
        return new RInteger(value);
    }

    @Override
    public int getDataAt(int index) {
        assert index == 0;
        return value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public RType getRType() {
        return RType.Integer;
    }

    @Override
    public RAbstractVector castSafe(RType type, ConditionProfile isNAProfile, boolean keepAttributes) {
        switch (type) {
            case Integer:
                return this;
            case Double:
                return isNAProfile.profile(isNA()) ? RDouble.createNA() : RDouble.valueOf(value);
            case Complex:
                return isNAProfile.profile(isNA()) ? RComplex.createNA() : RComplex.valueOf(value, 0.0);
            case Character:
                return RString.valueOf(RRuntime.intToString(value));
            case List:
                return RScalarList.valueOf(this);
            default:
                return null;
        }
    }

    @Override
    public String toString() {
        return RRuntime.intToString(value);
    }

    @Override
    public RIntVector materialize() {
        RIntVector result = RDataFactory.createIntVectorFromScalar(value);
        MemoryCopyTracer.reportCopying(this, result);
        return result;
    }

    @Override
    public boolean isNA() {
        return RRuntime.isNA(value);
    }

    private static final class FastPathAccess extends FastPathFromIntAccess {

        FastPathAccess(RAbstractContainer value) {
            super(value);
        }

        @Override
        public int getIntImpl(AccessIterator accessIter, int index) {
            assert index == 0;
            return ((RInteger) accessIter.getStore()).value;
        }
    }

    @Override
    public VectorAccess access() {
        return new FastPathAccess(this);
    }

    private static final SlowPathFromIntAccess SLOW_PATH_ACCESS = new SlowPathFromIntAccess() {
        @Override
        public int getIntImpl(AccessIterator accessIter, int index) {
            assert index == 0;
            return ((RInteger) accessIter.getStore()).value;
        }
    };

    @Override
    public VectorAccess slowPathAccess() {
        return SLOW_PATH_ACCESS;
    }
}
