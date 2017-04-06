/*
 * This material is distributed under the GNU General Public License
 * Version 2. You may review the terms of this license at
 * http://www.gnu.org/licenses/gpl-2.0.html
 *
 * Copyright (c) 2012-2014, Purdue University
 * Copyright (c) 2013, 2017, Oracle and/or its affiliates
 *
 * All rights reserved.
 */
package com.oracle.truffle.r.test.builtins;

import org.junit.Test;

import com.oracle.truffle.r.test.TestBase;

// Checkstyle: stop line length check
public class TestBuiltin_tan extends TestBase {

    @Test
    public void testtan1() {
        assertEval("argv <- list(c(2.19881034888372+1i, 1.31241297643351+1i, -0.26514505669635+1i, 0.54319405923209+1i, -0.41433994791886+1i, -0.47624689461558+1i, -0.78860283785024+1i, -0.59461726745951+1i, 1.65090746733669+1i, -0.05402812508544+1i, 0.11924523642758+1i, 0.24368742959909+1i, 1.23247587848534+1i, -0.51606383094478+1i, -0.99250715039204+1i, 1.67569693240319+1i, -0.44116321690529+1i, -0.72306596993987+1i, -1.23627311888329+1i, -1.2847157223178+1i, -0.57397347929799+1i, 0.61798581716653+1i, 1.10984813892972+1i, 0.70758835383559+1i, -0.36365729709525+1i, 0.0597499373846+1i, -0.70459646368007+1i, -0.71721816157401+1i, 0.88465049897692+1i, -1.01559257860354+1i, 1.95529396549246+1i, -0.09031959396585+1i, 0.21453882662922+1i, -0.73852770473957+1i, -0.57438868976327+1i, -1.31701613230524+1i, -0.18292538837273+1i, 0.41898240492446+1i, 0.32430434416138+1i, -0.78153648705475+1i, -0.788621970854+1i, -0.50219871834286+1i, 1.49606066984635+1i, -1.13730362066574+1i, -0.1790515943802+1i, 1.90236182167893+1i, -0.10097488532881+1i, -1.35984070382139+1i, -0.66476943527406+1i, 0.48545997890488+1i, -0.37560287166977+1i, -0.56187636354978+1i, -0.34391723412846+1i, 0.09049664713922+1i, 1.59850877114583+1i, -0.08856511213888+1i, 1.08079949615152+1i, 0.63075411565057+1i, -0.11363989550614+1i, -1.5329020028906+1i, -0.52111731755252+1i, -0.48987045313847+1i, 0.04715443276153+1i, 1.30019867766682+1i, 2.29307897383109+1i, 1.54758105898377+1i, -0.13315096432894+1i, -1.75652739555764+1i, -0.38877986407174+1i, 0.08920722307329+1i, 0.84501300406744+1i, 0.96252796848427+1i, 0.68430942941646+1i, -1.39527434979947+1i, 0.84964304563336+1i, -0.44655721642722+1i, 0.17480270016126+1i, 0.07455117717373+1i, 0.42816676497051+1i, 0.02467498282614+1i, -1.66747509758566+1i, 0.73649596477344+1i, 0.38602656834968+1i, -0.26565162527822+1i, 0.11814451104668+1i, 0.13403864536846+1i, 0.221019468561+1i, 1.64084616597749+1i, -0.21905037893348+1i, 0.16806538388466+1i, 1.16838387306909+1i, 1.05418102337692+1i, 1.14526311038036+1i, -0.57746800105956+1i, 2.00248273029283+1i, 0.06670087093018+1i, 1.86685184470686+1i, -1.35090268603071+1i, 0.02098358635424+1i, 1.24991457096922+1i));tan(argv[[1]]);");
    }

    @Test
    public void testtan2() {
        assertEval("argv <- list(c(0.01, 0.02, 0.03, 0.04, 0.05, 0.06, 0.07, 0.08, 0.09, 0.1, 0.11, 0.12, 0.13, 0.14, 0.15, 0.16, 0.17, 0.18, 0.19, 0.2, 0.21, 0.22, 0.23, 0.24, 0.25, 0.26, 0.27, 0.28, 0.29, 0.3, 0.31, 0.32, 0.33, 0.34, 0.35, 0.36, 0.37, 0.38, 0.39, 0.4, 0.41, 0.42, 0.43, 0.44, 0.45, 0.46, 0.47, 0.48, 0.49, 0.5, 0.51, 0.52, 0.53, 0.54, 0.55, 0.56, 0.57, 0.58, 0.59, 0.6, 0.61, 0.62, 0.63, 0.64, 0.65, 0.66, 0.67, 0.68, 0.69, 0.7, 0.71, 0.72, 0.73, 0.74, 0.75, 0.76, 0.77, 0.78, 0.79, 0.8, 0.81, 0.82, 0.83, 0.84, 0.85, 0.86, 0.87, 0.88, 0.89, 0.9, 0.91, 0.92, 0.93, 0.94, 0.95, 0.96, 0.97, 0.98, 0.99));tan(argv[[1]]);");
    }

    @Test
    public void testtan3() {
        // Extra warning in GnuR: "In tan(argv[[1]]) : NaNs produced"
        assertEval(Output.IgnoreWarningMessage, "argv <- list(Inf);tan(argv[[1]]);");
    }

    @Test
    public void testtan4() {
        assertEval("argv <- list(c(-6.28318530717959, -6.15752160103599, -6.0318578948924, -5.90619418874881, -5.78053048260522, -5.65486677646163, -5.52920307031804, -5.40353936417444, -5.27787565803085, -5.15221195188726, -5.02654824574367, -4.90088453960008, -4.77522083345649, -4.64955712731289, -4.5238934211693, -4.39822971502571, -4.27256600888212, -4.14690230273853, -4.02123859659494, -3.89557489045134, -3.76991118430775, -3.64424747816416, -3.51858377202057, -3.39292006587698, -3.26725635973338, -3.14159265358979, -3.0159289474462, -2.89026524130261, -2.76460153515902, -2.63893782901543, -2.51327412287183, -2.38761041672824, -2.26194671058465, -2.13628300444106, -2.01061929829747, -1.88495559215388, -1.75929188601028, -1.63362817986669, -1.5079644737231, -1.38230076757951, -1.25663706143592, -1.13097335529233, -1.00530964914873, -0.879645943005142, -0.75398223686155, -0.628318530717958, -0.502654824574367, -0.376991118430775, -0.251327412287183, -0.125663706143591, 8.88178419700125e-16, 0.125663706143592, 0.251327412287184, 0.376991118430776, 0.502654824574368, 0.62831853071796, 0.753982236861551, 0.879645943005142, 1.00530964914873, 1.13097335529233, 1.25663706143592, 1.38230076757951, 1.5079644737231, 1.63362817986669, 1.75929188601028, 1.88495559215388, 2.01061929829747, 2.13628300444106, 2.26194671058465, 2.38761041672824, 2.51327412287183, 2.63893782901543, 2.76460153515902, 2.89026524130261, 3.0159289474462, 3.14159265358979, 3.26725635973339, 3.39292006587698, 3.51858377202057, 3.64424747816416, 3.76991118430775, 3.89557489045134, 4.02123859659494, 4.14690230273853, 4.27256600888212, 4.39822971502571, 4.5238934211693, 4.64955712731289, 4.77522083345649, 4.90088453960008, 5.02654824574367, 5.15221195188726, 5.27787565803085, 5.40353936417445, 5.52920307031804, 5.65486677646163, 5.78053048260522, 5.90619418874881, 6.0318578948924, 6.157521601036, 6.28318530717959));tan(argv[[1]]);");
    }

    @Test
    public void testtan5() {
        // FIXME FastR seems unable to compute the complex tan() output: NaN+NaNi
        assertEval(Ignored.ImplementationError, "argv <- list(1+1000i);tan(argv[[1]]);");
    }

    @Test
    public void testTrigExp() {
        assertEval("{ tan(1.2) }");
        assertEval("{ tan(c(0.3,0.6,0.9)) }");
        assertEval("{ tan() }");
    }
}
