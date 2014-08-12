/*
 * This material is distributed under the GNU General Public License
 * Version 2. You may review the terms of this license at
 * http://www.gnu.org/licenses/gpl-2.0.html
 * 
 * Copyright (c) 2014, Purdue University
 * Copyright (c) 2014, Oracle and/or its affiliates
 * All rights reserved.
 */
package com.oracle.truffle.r.test.testrgen;

import org.junit.*;

import com.oracle.truffle.r.test.*;

public class TestrGenBuiltinsinh extends TestBase {

    @Test
    @Ignore
    public void testsinh1() {
        assertEval("argv <- list(FALSE);sinh(argv[[1]]);");
    }

    @Test
    @Ignore
    public void testsinh2() {
        assertEval("argv <- list(c(-3, -2.96984924623116, -2.93969849246231, -2.90954773869347, -2.87939698492462, -2.84924623115578, -2.81909547738693, -2.78894472361809, -2.75879396984925, -2.7286432160804, -2.69849246231156, -2.66834170854271, -2.63819095477387, -2.60804020100502, -2.57788944723618, -2.54773869346734, -2.51758793969849, -2.48743718592965, -2.4572864321608, -2.42713567839196, -2.39698492462312, -2.36683417085427, -2.33668341708543, -2.30653266331658, -2.27638190954774, -2.24623115577889, -2.21608040201005, -2.18592964824121, -2.15577889447236, -2.12562814070352, -2.09547738693467, -2.06532663316583, -2.03517587939699, -2.00502512562814, -1.9748743718593, -1.94472361809045, -1.91457286432161, -1.88442211055276, -1.85427135678392, -1.82412060301508, -1.79396984924623, -1.76381909547739, -1.73366834170854, -1.7035175879397, -1.67336683417085, -1.64321608040201, -1.61306532663317, -1.58291457286432, -1.55276381909548, -1.52261306532663, -1.49246231155779, -1.46231155778894, -1.4321608040201, -1.40201005025126, -1.37185929648241, -1.34170854271357, -1.31155778894472, -1.28140703517588, -1.25125628140704, -1.22110552763819, -1.19095477386935, -1.1608040201005, -1.13065326633166, -1.10050251256281, -1.07035175879397, -1.04020100502513, -1.01005025125628, -0.979899497487437, -0.949748743718593, -0.919597989949749, -0.889447236180905, -0.859296482412061, -0.829145728643216, -0.798994974874372, -0.768844221105528, -0.738693467336684, -0.708542713567839, -0.678391959798995, -0.648241206030151, -0.618090452261307, -0.587939698492463, -0.557788944723618, -0.527638190954774, -0.49748743718593, -0.467336683417086, -0.437185929648241, -0.407035175879397, -0.376884422110553, -0.346733668341709, -0.316582914572864, -0.28643216080402, -0.256281407035176, -0.226130653266332, -0.195979899497488, -0.165829145728643, -0.135678391959799, -0.105527638190955, -0.0753768844221105, -0.0452261306532664, -0.0150753768844223, 0.0150753768844218, 0.0452261306532664, 0.0753768844221105, 0.105527638190955, 0.135678391959799, 0.165829145728643, 0.195979899497488, 0.226130653266332, 0.256281407035176, 0.28643216080402, 0.316582914572864, 0.346733668341709, 0.376884422110553, 0.407035175879397, 0.437185929648241, 0.467336683417085, 0.49748743718593, 0.527638190954774, 0.557788944723618, 0.587939698492462, 0.618090452261306, 0.648241206030151, 0.678391959798995, 0.708542713567839, 0.738693467336683, 0.768844221105527, 0.798994974874372, 0.829145728643216, 0.85929648241206, 0.889447236180904, 0.919597989949748, 0.949748743718593, 0.979899497487437, 1.01005025125628, 1.04020100502513, 1.07035175879397, 1.10050251256281, 1.13065326633166, 1.1608040201005, 1.19095477386935, 1.22110552763819, 1.25125628140704, 1.28140703517588, 1.31155778894472, 1.34170854271357, 1.37185929648241, 1.40201005025126, 1.4321608040201, 1.46231155778894, 1.49246231155779, 1.52261306532663, 1.55276381909548, 1.58291457286432, 1.61306532663317, 1.64321608040201, 1.67336683417085, 1.7035175879397, 1.73366834170854, 1.76381909547739, 1.79396984924623, 1.82412060301507, 1.85427135678392, 1.88442211055276, 1.91457286432161, 1.94472361809045, 1.9748743718593, 2.00502512562814, 2.03517587939698, 2.06532663316583, 2.09547738693467, 2.12562814070352, 2.15577889447236, 2.18592964824121, 2.21608040201005, 2.24623115577889, 2.27638190954774, 2.30653266331658, 2.33668341708543, 2.36683417085427, 2.39698492462312, 2.42713567839196, 2.4572864321608, 2.48743718592965, 2.51758793969849, 2.54773869346734, 2.57788944723618, 2.60804020100502, 2.63819095477387, 2.66834170854271, 2.69849246231156, 2.7286432160804, 2.75879396984925, 2.78894472361809, 2.81909547738693, 2.84924623115578, 2.87939698492462, 2.90954773869347, 2.93969849246231, 2.96984924623116, 3));sinh(argv[[1]]);");
    }
}

