/*
 * Copyright (c) 2017, Oracle and/or its affiliates. All rights reserved.
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
package com.oracle.truffle.r.runtime.ffi.managed;

import static com.oracle.truffle.r.runtime.ffi.managed.Managed_RFFIFactory.unsupported;

import com.oracle.truffle.r.runtime.ffi.REmbedRFFI;

public class Managed_REmbedRFFI implements REmbedRFFI {
    @Override
    public void suicide(String x) {
        throw unsupported("REmbed");
    }

    @Override
    public void cleanUp(int type, int x, int y) {
        throw unsupported("REmbed");
    }

    @Override
    public String readConsole(String prompt) {
        throw unsupported("REmbed");
    }

    @Override
    public void writeConsole(String x) {
        throw unsupported("REmbed");
    }

    @Override
    public void writeErrConsole(String x) {
        throw unsupported("REmbed");
    }
}
