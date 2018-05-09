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
public class TestBuiltin_pmin extends TestBase {

    @Test
    public void testpmin1() {
        assertEval("argv <- list(FALSE, c(0, 0.25, 0.5, 0.75, 1), 1); .Internal(pmin(argv[[1]], argv[[2]], argv[[3]]))");
    }

    @Test
    public void testpmin2() {
        assertEval("argv <- list(FALSE, c(1.01547865839261, 1.01252937204691, 1.00644625408792, 0.998699246049516, 0.989861830865133, 0.980229984263028, 0.969980509594864, 0.959229159804225, 0.948056660278026, 0.948056660278026, 0.936413637553504, 0.924430242566905, 0.924430242566905, 0.912012661079992, 0.912012661079992, 0.912012661079992, 0.912012661079992, 0.912012661079992, 0.912012661079992, 0.89856564301575, 0.89856564301575, 0.89856564301575, 0.89856564301575, 0.884221004526004, 0.884221004526004, 0.884221004526004, 0.884221004526004, 0.868846889674391, 0.852918138766346, 0.852918138766346, 0.852918138766346, 0.836013989965276, 0.836013989965276, 0.818281118997659, 0.818281118997659, 0.799674858806929, 0.78048190648179, 0.760752205123712, 0.740524405390135, 0.698688252548957, 0.677121358432204, 0.677121358432204, 0.677121358432204, 0.653968759838845, 0.630226345284056, 0.60591293760604, 0.5810405538867, 0.5810405538867, 0.554772713636871, 0.554772713636871, 0.526885054753327, 0.526885054753327, 0.497124929362659, 0.497124929362659, 0.465290373327728, 0.431410832191818, 0.395597572090297, 0.358012869967492, 0.358012869967492, 0.358012869967492, 0.390645999939295, 0.390645999939295, 1.00856963764107, 1.00691545377429, 1.00354783420184, 0.994430782349702, 0.989161076962549, 0.983568844113983, 0.971651869906627, 0.965403818059832, 0.958998025317496, 0.952453588123512, 0.945785731840592, 0.939006829762577, 0.932127100227826, 0.925155098145928, 0.918098070593368, 0.910962219832367, 0.903752901643838, 0.896474777439562, 0.889131932689408, 0.874266085562073, 0.866749125736792, 0.85917963981466, 0.85917963981466, 0.85917963981466, 0.851432533571458, 0.851432533571458, 0.835646571743332, 0.819657377450186, 0.811591248493136, 0.811591248493136, 0.803403072648503, 0.803403072648503, 0.803403072648503, 0.79500789222886, 0.79500789222886, 0.78647848620035, 0.777810139927498, 0.777810139927498, 0.768997769554365, 0.760132009504045, 0.751214427604144, 0.751214427604144, 0.751214427604144, 0.742042333451995, 0.742042333451995, 0.732706928458195, 0.723314130803801, 0.713865427684027, 0.713865427684027, 0.704242881823747, 0.704242881823747, 0.694438026993695, 0.684573363315093, 0.674650164742493, 0.664669564073024, 0.664669564073024, 0.664669564073024, 0.654342845821626, 0.643951412016272, 0.633496370097346, 0.633496370097346, 0.622814395282618, 0.622814395282618, 0.611712238653597, 0.600530813249145, 0.589271296091113, 0.577934661160654, 0.577934661160654, 0.554603983179207, 0.542813560886543, 0.530698712197854, 0.530698712197854, 0.518231810914377, 0.518231810914377, 0.518231810914377, 0.505091485230836, 0.491816896403255, 0.478408881208852, 0.464867758182769, 0.464867758182769, 0.450831087639633, 0.43663736059032, 0.422285766886131, 0.422285766886131, 0.407334269006221, 0.392187384239101, 0.376842383287708, 0.376842383287708, 0.36074886771613, 0.344393472477708, 0.327769800745284, 0.310869313273075, 0.293681131444043, 0.27619182464681, 0.258385252532011, 0.240242648154923, 0.221743435532848, 0.202868148187672, 0.183607543425597, 0.183607543425597, 0.16434288099768, 0.16434288099768, 0.16434288099768, 0.16434288099768, 1.01958384078021, 1.0158820929578, 1.00818641731953, 0.998355892450852, 0.98711678103063, 0.974844224342501, 0.961762390694789, 0.94801800556359, 0.933713296997721, 0.918922795982771, 0.918922795982771, 0.903505632185222, 0.887664218536847, 0.8714385967694, 0.854601072478364, 0.837400228461143, 0.81986117753083, 0.80200434269104, 0.783846415628184, 0.765401054645917, 0.746679400612251, 0.727690462294359, 0.70844140545579, 0.688937769124757, 0.669183625153216, 0.649181692191925, 0.628933411668998, 0.608438990755048, 0.608438990755048, 0.587078835123946, 0.565417411428399, 0.543452081149807, 0.521178337588507, 0.498589701519445, 0.475677565090786, 0.475677565090786, 0.451501204504207, 0.426861888982249, 0.401742325799741, 0.376120821121693, 0.349971441565183, 0.323265236972233, 0.323265236972233, 0.294966951140867, 0.265661696527275, 0.265661696527275, 0.24198035833067, 0.229359831745471, NA, NA), 1); .Internal(pmin(argv[[1]], argv[[2]], argv[[3]]))");
    }

    @Test
    public void testpmin3() {
        assertEval("argv <- list(FALSE, c(19.7787405591752, 12504507.4953993, 12504507.4953993, 5.96190157728191e+41), 1); .Internal(pmin(argv[[1]], argv[[2]], argv[[3]]))");
    }

    @Test
    public void testpmin4() {
        assertEval("argv <- list(FALSE, structure(c(2, 3, 4, 2, 2, 2), .Dim = c(3L, 2L), .Dimnames = list(NULL, c('a', ''))), 1:7); .Internal(pmin(argv[[1]], argv[[2]], argv[[3]]))");
    }

    @Test
    public void testpmin5() {
        assertEval("argv <- list(FALSE, structure(c(-2.30560410637911, -1.56788329848973, -0.885216282233891, -0.246592299284877, 0.350190802022645, 0.913941628350052, 1.44466017969734, 1.94895291106052), .Names = c('1', '2', '3', '4', '5', '6', '7', '8')), 700); .Internal(pmin(argv[[1]], argv[[2]], argv[[3]]))");
    }

    @Test
    public void testpmin6() {
        assertEval("argv <- list(FALSE, 1, structure(numeric(0), .Dim = c(4L, 0L))); .Internal(pmin(argv[[1]], argv[[2]], argv[[3]]))");
    }

    @Test
    public void testpmin7() {
        assertEval("argv <- list(FALSE, FALSE, FALSE); .Internal(pmin(argv[[1]], argv[[2]], argv[[3]]))");
    }

    @Test
    public void testpmin8() {
        assertEval("argv <- list(FALSE, FALSE); .Internal(pmin(argv[[1]], argv[[2]]))");
    }

    @Test
    public void testpmin9() {
        assertEval("argv <- list(FALSE, 48L, 19L); .Internal(pmin(argv[[1]], argv[[2]], argv[[3]]))");
    }

    @Test
    public void testpmin10() {
        assertEval("argv <- list(FALSE, 1, 0.341867139159); .Internal(pmin(argv[[1]], argv[[2]], argv[[3]]))");
    }

    @Test
    public void testpmin11() {
        assertEval("argv <- list(FALSE, c(2.35405350797934e-06, 0.000210159024072429, 0.000257684187404011, 0.000981478332360736, 0.00105260958830543, 0.00124148072892802, 0.00132598801923585, 0.00156850331255678, 0.00225455732762676, 0.003795380309271, 0.00611494315340942, 0.0161395372907077, 0.0330242962313738, 0.0353834177611007, 0.0523699658057458, 0.068319089314331, 0.0705922565893261, 0.0880512860101142, 0.0940103983967277, 0.112979808322889, 0.211501681388388, 0.492273640304204, 0.605329775053071, 0.626223946736039, 0.739515289321684, 0.828110328240387, 0.86333312789587, 1.19065433061771, 1.89079625396729, 2.05849377808347, 2.20921371984431, 2.85600042559897, 3.04889487308354, 4.66068200259841, 4.83080935233713, 4.92175460488491, 5.31945286062773, 5.75155046407955, 5.78319462345744), 0.943789021783783); .Internal(pmin(argv[[1]], argv[[2]], argv[[3]]))");
    }

    @Test
    public void testPMin() {
        assertEval("{ pmin(c(1L, 7L), c(42L, 1L)) }");
        assertEval("{ pmin(c(1L, 7L), integer()) }");
        assertEval("{ pmin(c(1L, 7L, 8L), c(1L), c(42L, 1L)) }");
        assertEval("{ pmin(c(1L, 7L), c(42L, as.integer(NA))) }");
        assertEval("{ pmin(c(1L, 7L), c(42L, as.integer(NA)), na.rm=TRUE) }");

        assertEval("{ pmin(c(1, 7), c(42, 1)) }");
        assertEval("{ pmin(c(1, 7), double()) }");
        assertEval("{ pmin(c(1, 7, 8), c(1), c(42, 1)) }");
        assertEval("{ pmin(c(1, 7), c(42, as.double(NA))) }");
        assertEval("{ pmin(c(1, 7), c(42, as.double(NA)), na.rm=TRUE) }");

        assertEval("{ pmin(c(\"1\", \"7\"), c(\"42\", \"1\")) }");
        assertEval("{ pmin(c(\"1\", \"7\"), character()) }");
        assertEval("{ pmin(c(\"1\", \"7\", \"8\"), c(\"1\"), c(\"42\", \"1\")) }");
        assertEval("{ pmin(c(\"1\", \"7\"), c(\"42\", as.character(NA))) }");
        assertEval("{ pmin(c(\"1\", \"7\"), c(\"42\", as.character(NA)), na.rm=TRUE) }");
        assertEval("{ pmin(c(\"1\", as.character(NA)), c(\"42\", \"1\"), na.rm=TRUE) }");
        assertEval("{ pmin(c(\"1\", as.character(NA)), c(as.character(NA), as.character(NA)), c(\"42\", \"1\"), na.rm=TRUE) }");

        assertEval("{ pmin(c(FALSE, TRUE), c(TRUE, FALSE)) }");
        assertEval("{ pmin(c(FALSE, TRUE), logical()) }");
        assertEval("{ pmin(c(FALSE, TRUE), c(FALSE, NA)) }");

        assertEval("{ pmin(as.raw(42)) }");
        assertEval("{ pmin(7+42i) }");
    }

    @Test
    public void testArgsCasting() {
        assertEval("pmin(c(1,2), c(3,0), na.rm='asd')");
        assertEval("pmin(c(1,2), c(3,0), na.rm=NA)");
        assertEval("pmin(c(1,2), c(3,NA), na.rm=c(42, 0))");
        assertEval(".Internal(pmin(3, quote(a)))");
    }
}
