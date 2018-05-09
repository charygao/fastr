/*
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option)
 * any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for
 * more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 51
 * Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 *
 * Copyright (c) 2012-2014, Purdue University
 * Copyright (c) 2013, 2018, Oracle and/or its affiliates
 *
 * All rights reserved.
 */
package com.oracle.truffle.r.test.builtins;

import org.junit.Test;

import com.oracle.truffle.r.test.TestBase;

// Checkstyle: stop line length check

public class TestBuiltin_diagassign_ extends TestBase {

    @Test
    public void testdiagassign_1() {
        assertEval("argv <- structure(list(x = structure(numeric(0), .Dim = c(0L,     4L)), value = numeric(0)), .Names = c('x', 'value'));do.call('diag<-', argv)");
    }

    @Test
    public void testdiagassign_3() {
        assertEval("argv <- structure(list(x = structure(c(0, 0, 0, 0, 0, 0, 0.215098376664487,     0, 0, 0, -1.65637081299852, 0, 0, 0, 0, 0, -0.414332953459613,     0, 0, -1.40806198482254, 0, 0, 0, 0, 0, 0, 0, 0, -0.856525152312943,     0, 0, 0, 0, 0, 0, 0, 0, -0.0763379828255197, 0, 0, 0, 0,     0, 0, 0, 0, 0, 0, 0.566886579526715, 0, 0, 0, 0, 0, 0.6662762965807,     -1.0108032000459, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1.27827012429586,     0, 0, 0, 0, 0, 2.58429591514953, 0, 0, 2.11417636787577,     -0.433540727336897, 0, -1.2168073873217, 0, 0, 0, 0, 0, 0,     0, 0, 0, 0, -0.739899226286947, 0, 1.63831140634344, 0.940796284653334,     0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1.27827012429586, 0, 0,     0, -1.53221105110478, 0, 0.0842634801991399, 0, 0, 0, 0,     0, 0, 0, 0.46436714586526, 0, 0, 0.215098376664487, 0, 0,     0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1.20702771149749, 0, 0,     0, 0, 0, 0, 0, 0, 0, 0, -1.53221105110478, 0, 0, 0, 0, 0,     0, 0, 0, 0, 0, 0, 0, 0.797128455296496, 0, 0, -0.856525152312943,     0.566886579526715, 0, -0.739899226286947, 0, 0, 0, 0, 0,     0, 0, 0, 0, 0, 0, -0.53717285365944, 0, 0, -1.78309634885893,     0, 0, 0, 0, 0, 0.0842634801991399, 0, 0, 0, 0, 0, 0, 0, 0,     0, 0, 0.0654058852501743, 0, 0, 0, -1.65637081299852, 0,     0, 0, 1.63831140634344, 0, 0, 0, 0, 0, 0, -0.211859819992765,     1.70777682244235, 0, 0, 0.899304333370124, 0, 0, 0.696790958441438,     0, 0, 0, 0, 2.58429591514953, 0.940796284653334, 0, 0, 0,     0, 0, -0.211859819992765, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,     0, 0, 0, 0, 0, 0, 0, 0, 1.70777682244235, 0, 0, 0, 0, 0,     0, 2.70925832108517, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,     0, 0, 0, 0, 0, 0, 0, 0, 0, -0.218019634714546, 0, 0, 0.6662762965807,     2.11417636787577, 0, 0, 1.20702771149749, 0, 0, 0, 0, 0,     0, 0, 0, 0, 0, 0, -0.431663950618028, 0, 0, 0, -1.0108032000459,     -0.433540727336897, 0, 0, 0, 0, 0, 0, 0.899304333370124,     0, 0, 0, 0, 0, 1.84823959064644, 0, 0, 0, -0.414332953459613,     0, 0, 0, 0, 0, 0, 0, -0.53717285365944, 0.0654058852501743,     0, 0, 0, 0, 0, 1.84823959064644, 0.487718131057368, 0, 0,     0, 0, -0.0763379828255197, 0, -1.2168073873217, 0, 0.46436714586526,     0, 0, 0, 0, 0, 0, 2.70925832108517, 0, 0, 0, 0, 0, 0, 0.89955019874646,     0, 0, 0, 0, 0, 0, 0, 0.797128455296496, 0, 0, 0.696790958441438,     0, 0, 0, -0.431663950618028, 0, 0, 0, 0, 0, -1.40806198482254,     0, 0, 0, 0, 0, 0, 0, -1.78309634885893, 0, 0, 0, 0, -0.218019634714546,     0, 0, 0, 0.89955019874646, 0, 0), .Dim = c(20L, 20L)), value = 1),     .Names = c('x', 'value'));do.call('diag<-', argv)");
    }

    @Test
    public void testUpdateDiagonal() {
        assertEval("{ m <- matrix(1:6, nrow=3) ; diag(m) <- c(1,2) ; m }");
        assertEval("{ m <- matrix(1:6, nrow=3); y<-m+42; diag(y) <- c(1,2); y }");
        assertEval("{ m <- matrix(1:6, nrow=3) ;  attr(m, \"foo\")<-\"foo\"; diag(m) <- c(1,2); attributes(m) }");
        assertEval("{ m <- matrix(1:6, nrow=3) ; diag(m) <- c(1.1,2.2); m }");
        assertEval("{ m <- matrix(1:6, nrow=3) ; diag(m) <- c(1.1,2); m }");
        assertEval("{ m <- matrix(1:6, nrow=3) ; diag(m) <- c(1,2.2); m }");
        assertEval("{ m <- matrix(1:6, nrow=3) ;  attr(m, \"foo\")<-\"foo\"; diag(m) <- c(1.1,2.2); attributes(m) }");
        assertEval("{ x <- (m <- matrix(1:6, nrow=3)) ; diag(m) <- c(1,2) ; x }");
        assertEval("{ m <- matrix(1:6, nrow=3) ; f <- function() { diag(m) <- c(100,200) } ; f() ; m }");
    }
}
