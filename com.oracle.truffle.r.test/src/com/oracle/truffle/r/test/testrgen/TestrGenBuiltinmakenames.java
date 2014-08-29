/*
 * This material is distributed under the GNU General Public License
 * Version 2. You may review the terms of this license at
 * http://www.gnu.org/licenses/gpl-2.0.html
 *
 * Copyright (c) 2014, Purdue University
 * Copyright (c) 2014, Oracle and/or its affiliates
 *
 * All rights reserved.
 */
package com.oracle.truffle.r.test.testrgen;

import org.junit.*;

import com.oracle.truffle.r.test.*;

public class TestrGenBuiltinmakenames extends TestBase {

    @Test
    public void testmakenames1() {
        assertEval("argv <- list(\'head\', TRUE); .Internal(make.names(argv[[1]], argv[[2]]))");
    }

    @Test
    public void testmakenames2() {
        assertEval("argv <- list(\'FALSE\', TRUE); .Internal(make.names(argv[[1]], argv[[2]]))");
    }

    @Test
    public void testmakenames3() {
        assertEval("argv <- list(c(\'.Call\', \'.Call numParameters\', \'.Fortran\', \'.Fortran numParameters\'), TRUE); .Internal(make.names(argv[[1]], argv[[2]]))");
    }

    @Test
    public void testmakenames4() {
        assertEval("argv <- list(\'..adfl.row.names\', TRUE); .Internal(make.names(argv[[1]], argv[[2]]))");
    }

    @Test
    public void testmakenames5() {
        assertEval("argv <- list(c(\'name\', \'title\', \'other.author\'), TRUE); .Internal(make.names(argv[[1]], argv[[2]]))");
    }

    @Test
    public void testmakenames6() {
        assertEval("argv <- list(\'.2a\', TRUE); .Internal(make.names(argv[[1]], argv[[2]]))");
    }

    @Test
    public void testmakenames7() {
        assertEval("argv <- list(\'\', TRUE); .Internal(make.names(argv[[1]], argv[[2]]))");
    }

    @Test
    public void testmakenames8() {
        assertEval("argv <- list(NA_character_, TRUE); .Internal(make.names(argv[[1]], argv[[2]]))");
    }

    @Test
    public void testmakenames9() {
        assertEval("argv <- list(c(\'Subject\', \'predict.fixed\', \'predict.Subject\'), TRUE); .Internal(make.names(argv[[1]], argv[[2]]))");
    }

    @Test
    public void testmakenames10() {
        assertEval("argv <- list(c(\'\', \'\', \'bady\'), TRUE); .Internal(make.names(argv[[1]], argv[[2]]))");
    }

    @Test
    public void testmakenames11() {
        assertEval("argv <- list(character(0), TRUE); .Internal(make.names(argv[[1]], argv[[2]]))");
    }
}
