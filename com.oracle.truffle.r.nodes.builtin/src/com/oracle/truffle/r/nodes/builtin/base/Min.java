/*
 * Copyright (c) 2013, 2015, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */
package com.oracle.truffle.r.nodes.builtin.base;

import static com.oracle.truffle.r.runtime.RBuiltinKind.*;

import com.oracle.truffle.api.dsl.*;
import com.oracle.truffle.api.frame.*;
import com.oracle.truffle.r.nodes.builtin.*;
import com.oracle.truffle.r.nodes.unary.*;
import com.oracle.truffle.r.nodes.unary.UnaryArithmeticReduceNode.ReduceSemantics;
import com.oracle.truffle.r.runtime.*;
import com.oracle.truffle.r.runtime.data.*;
import com.oracle.truffle.r.runtime.ops.*;

@RBuiltin(name = "min", kind = PRIMITIVE, parameterNames = {"...", "na.rm"})
public abstract class Min extends RBuiltinNode {

    private static final ReduceSemantics semantics = new ReduceSemantics(RRuntime.INT_MAX_VALUE, Double.POSITIVE_INFINITY, false, RError.Message.NO_NONMISSING_MIN,
                    RError.Message.NO_NONMISSING_MIN_NA, false, true);

    @Child private Combine combine = CombineNodeGen.create(null, null, null);
    @Child private UnaryArithmeticReduceNode reduce = UnaryArithmeticReduceNodeGen.create(semantics, BinaryArithmetic.MIN);

    @Override
    public Object[] getDefaultParameterValues() {
        return new Object[]{RArgsValuesAndNames.EMPTY, RRuntime.LOGICAL_FALSE};
    }

    @Specialization
    protected Object min(VirtualFrame frame, RArgsValuesAndNames args, byte naRm) {
        return reduce.executeReduce(combine.executeCombine(frame, args), naRm);
    }
}
