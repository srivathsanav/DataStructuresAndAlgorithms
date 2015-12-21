package com.interviewbit.assignment;

import java.util.Arrays;
import java.util.List;

/**
 * Created by srivathsan on 29/10/15.
 */
public class ThreePointer {

    public static int minimize(final List<Integer> a, final List<Integer> b, final List<Integer> c) {

        int bestFirst = 0;
        int bestSecond = 0;
        int bestThird = 0;
        int minDiffernce = Integer.MAX_VALUE;
        for (int i = 0; i < a.size(); i++) {
            int first = binarySearch(b, 0, b.size() -1, a.get(i).intValue());
            int second = binarySearch(c, 0, c.size() -1, a.get(i).intValue());
            int third = binarySearch(c, 0, c.size() -1, second);
            int difference = Math.max(Math.abs( a.get(i).intValue() - first), Math.abs(a.get(i).intValue() - second));
            difference = Math.max(difference, Math.abs(third - second));
            if (difference < minDiffernce) {
                minDiffernce = difference;
                bestFirst = first;
                bestSecond = second;
                bestThird = third;
            }
        }
        int finalMinumim = Math.max(Math.abs(bestFirst - bestSecond), Math.abs(bestSecond - bestThird));
        finalMinumim =  Math.min(finalMinumim, Math.abs(bestThird - bestFirst));
        return  finalMinumim;
    }

    private static int binarySearch(List<Integer> a, int low, int high, int element) {

        while ( low <= high) {
            int mid = low + (high - low) /2 ;
            if (element == a.get(mid).intValue()) {
                return a.get(mid);
            } else if (a.get(mid) < element){
                low = mid + 1;
            } else {
                high = mid -1;
            }
        }

        if (low > 0) {
            low = low -1;
        }
        if (low != a.size()-1 && Math.abs(a.get(low) - element) > Math.abs(a.get(low+1) - element)) {
            return a.get(low+1);
        } else {
            return a.get(low);

        }
    }
    public static void main(String[] args) {
        List<Integer>  a= Arrays.asList( 24, 25, 44, 51, 57, 65, 69, 109, 124, 139, 140, 174, 183, 221, 224, 225, 228, 240, 248, 253, 261, 262, 265, 270, 281, 292, 297, 300, 320, 333, 355, 363, 381, 388, 390, 391, 396, 404, 405, 426, 449, 455, 458, 459, 460, 461, 468, 469, 474, 484, 484, 501, 502, 506, 506, 507, 540, 544, 574, 587, 587, 607, 614, 622, 642, 645, 649, 654, 656, 706, 731, 732, 742, 744, 751, 755, 764, 767, 770, 776, 798, 798, 800, 804, 807, 831, 831, 835, 883, 918, 932, 934, 943, 944, 966, 969, 977, 981, 991, 993, 1007, 1027, 1033, 1036, 1044, 1062, 1063, 1077, 1081, 1082, 1082, 1085, 1113, 1154, 1157, 1160, 1184, 1198, 1205, 1219, 1222, 1253, 1257, 1269, 1270, 1279, 1285, 1306, 1315, 1315, 1328, 1361, 1377, 1389, 1409, 1414, 1427, 1439, 1505, 1522, 1525, 1546, 1546, 1549, 1556, 1561, 1586, 1602, 1621, 1633, 1653, 1660, 1667, 1705, 1707, 1719, 1720, 1745, 1756, 1757, 1757, 1764, 1786, 1791, 1823, 1841, 1842, 1842, 1848, 1856, 1860, 1865, 1867, 1868, 1885, 1894, 1906, 1912, 1918, 1919, 1929, 1933, 1943, 1961, 1973, 2012, 2016, 2019, 2030, 2033, 2047, 2057, 2070, 2085, 2105, 2116, 2137, 2142, 2148, 2197, 2200, 2201, 2209, 2217, 2217, 2256, 2269, 2273, 2281, 2283, 2284, 2285, 2293, 2294, 2297, 2329, 2355, 2361, 2377, 2418, 2428, 2435, 2445, 2464, 2464, 2464, 2469, 2474, 2483, 2489, 2513, 2518, 2526, 2526, 2576, 2579, 2584, 2585, 2633, 2637, 2679, 2681, 2684, 2716, 2719, 2720, 2724, 2725, 2748, 2753, 2759, 2764, 2779, 2800, 2814, 2817, 2832, 2836, 2843, 2852, 2859, 2866, 2875, 2908, 2909, 2909, 2912, 2917, 2927, 2933, 2940, 2948, 2952, 2958, 2983, 2991, 3000, 3016, 3017, 3019, 3025, 3040, 3044, 3049, 3077, 3084, 3109, 3110, 3121, 3126, 3130, 3133, 3136, 3138, 3144, 3147, 3153, 3177, 3178, 3196, 3204, 3207, 3229, 3244, 3257, 3258, 3259, 3262, 3263, 3290, 3293, 3303, 3303, 3306, 3307, 3310, 3313, 3342, 3354, 3354, 3364, 3372, 3374, 3375, 3397, 3437, 3443, 3444, 3459, 3460, 3460, 3475, 3487, 3489, 3496, 3505, 3512, 3535, 3554, 3573, 3575, 3587, 3587, 3600, 3605, 3621, 3629, 3633, 3653, 3663, 3684, 3708, 3711, 3718, 3728, 3731, 3747, 3756, 3769, 3773, 3775, 3775, 3794, 3800, 3807, 3811, 3815, 3824, 3840, 3843, 3862, 3864, 3874, 3879, 3886, 3894, 3895, 3907, 3907, 3910, 3912, 3940, 3994, 3998, 4001, 4011, 4017, 4020, 4021, 4026, 4029, 4056, 4059, 4069, 4070, 4080, 4097, 4107, 4109, 4109, 4114, 4120, 4146, 4148, 4156, 4169, 4177, 4182, 4182, 4184, 4186, 4187, 4195, 4210, 4214, 4237, 4242, 4265, 4294, 4308, 4309, 4317, 4318, 4321, 4334, 4356, 4359, 4361, 4369, 4415, 4417, 4432, 4456, 4485, 4493, 4504, 4518, 4531, 4532, 4540, 4550, 4557, 4567, 4572, 4582, 4582, 4592, 4598, 4607, 4611, 4611, 4614, 4627, 4656, 4662, 4662, 4665, 4671, 4711, 4724, 4761, 4770, 4774, 4814, 4825, 4836, 4858, 4858, 4864, 4865, 4880, 4893, 4893, 4897, 4898, 4906, 4911, 4913, 4913, 4941, 4949, 4970, 4981, 4994, 4994, 5000, 5003, 5029, 5044, 5047, 5061, 5074, 5085, 5095, 5096, 5112, 5113, 5134, 5150, 5181, 5185, 5205, 5208, 5209, 5220, 5244, 5254, 5256, 5277, 5280, 5284, 5296, 5303, 5336, 5338, 5356, 5373, 5376, 5381, 5390, 5430, 5436, 5455, 5468, 5476, 5499, 5503, 5639, 5654, 5661, 5673, 5687, 5697, 5733, 5734, 5743, 5746, 5747, 5761, 5763, 5810, 5821, 5825, 5834, 5840, 5865, 5875, 5876, 5935, 5952, 5954, 5954, 5961, 5991, 6014, 6019, 6021, 6041, 6047, 6048, 6060, 6061, 6074, 6074, 6076, 6077, 6081, 6092, 6102, 6106, 6108, 6108, 6132, 6135, 6153, 6154, 6159, 6167, 6184, 6196, 6230, 6247, 6273, 6275, 6277, 6281, 6282, 6294, 6294, 6295, 6298, 6301, 6347, 6351, 6352, 6361, 6364, 6387, 6393, 6415, 6416, 6432, 6441, 6448, 6454, 6459, 6463, 6475, 6481, 6544, 6549, 6555, 6558, 6565, 6566, 6584, 6592, 6595, 6613, 6634, 6674, 6687, 6692, 6712, 6727, 6731, 6757, 6779, 6783, 6786, 6794, 6807, 6813, 6820, 6820, 6826, 6837, 6850, 6854, 6856, 6866, 6867, 6895, 6898, 6907, 6922, 6929, 6937, 6943, 6944, 6953, 6958, 6961, 6989, 6999, 7021, 7039, 7051, 7053, 7062, 7070, 7081, 7103, 7113, 7122, 7125, 7130, 7132, 7156, 7157, 7158, 7160, 7172, 7172, 7179, 7198, 7201, 7205, 7229, 7263, 7273, 7273, 7285, 7287, 7303, 7304, 7309, 7312, 7322, 7329, 7349, 7372, 7376, 7382, 7388, 7404, 7419, 7423, 7425, 7441, 7461, 7468, 7468, 7502, 7514, 7518, 7532, 7548, 7551, 7565, 7580, 7587, 7594, 7602, 7614, 7629, 7643, 7661, 7667, 7679, 7693, 7699, 7711, 7715, 7746, 7768, 7773, 7805, 7818, 7822, 7861, 7871, 7873, 7878, 7885, 7898, 7898, 7904, 7919, 7920, 7925, 7928, 7929, 7939, 7945, 7952, 7953, 7960, 7972, 7988, 7992, 8017, 8037, 8042, 8045, 8047, 8071, 8099, 8105, 8111, 8117, 8134, 8135, 8136, 8155, 8165, 8173, 8186, 8188, 8201, 8202, 8217, 8230, 8234, 8254, 8278, 8285, 8306, 8324, 8368, 8414, 8420, 8448, 8466, 8478, 8493, 8504, 8505, 8571, 8589, 8612, 8620, 8636, 8645, 8651, 8652, 8682, 8687, 8689, 8690, 8693, 8707, 8728, 8732, 8733, 8759, 8772, 8773, 8786, 8788, 8791, 8803, 8829, 8839, 8876, 8901, 8909, 8924, 8963, 8976, 8981, 8992, 8993, 8998, 9005, 9008, 9038, 9051, 9051, 9054, 9073, 9081, 9102, 9113, 9115, 9135, 9148, 9167, 9171, 9178, 9179, 9183, 9186, 9190, 9193, 9223, 9229, 9291, 9299, 9309, 9320, 9326, 9334, 9350, 9351, 9361, 9366, 9396, 9400, 9401, 9406, 9415, 9422, 9427, 9443, 9466, 9484, 9484, 9497, 9503, 9520, 9523, 9566, 9596, 9599, 9600, 9601, 9607, 9613, 9618, 9620, 9631, 9661, 9662, 9667, 9669, 9670, 9685, 9705, 9708, 9717, 9730, 9741, 9751, 9766, 9767, 9767, 9817, 9826, 9827, 9829, 9832, 9848, 9868, 9875, 9880, 9886, 9891, 9902, 9907, 9908, 9918, 9930, 9935, 9939, 9940, 9972, 9974, 9986
        );

        List<Integer> b = Arrays.asList( 44, 44, 48, 65, 68, 111, 123, 129, 138, 142, 151, 191, 198, 211, 220, 223, 223, 259, 305, 324, 324, 326, 354, 354, 359, 359, 359, 363, 389, 396, 404, 405, 417, 438, 441, 445, 445, 457, 460, 481, 493, 493, 497, 502, 512, 515, 516, 530, 533, 544, 545, 554, 568, 577, 579, 579, 593, 594, 622, 643, 650, 655, 664, 671, 681, 691, 703, 703, 714, 725, 726, 758, 787, 801, 805, 811, 815, 868, 890, 918, 922, 952, 967, 969, 987, 989, 998, 1002, 1007, 1028, 1048, 1048, 1050, 1053, 1088, 1101, 1112, 1120, 1128, 1163, 1164, 1214, 1218, 1221, 1222, 1243, 1263, 1264, 1271, 1308, 1311, 1364, 1385, 1387, 1392, 1394, 1397, 1421, 1428, 1433, 1447, 1500, 1571, 1587, 1611, 1618, 1619, 1621, 1628, 1632, 1668, 1693, 1708, 1722, 1737, 1743, 1744, 1750, 1769, 1784, 1791, 1792, 1793, 1809, 1833, 1842, 1845, 1849, 1866, 1872, 1879, 1881, 1893, 1907, 1916, 1937, 1946, 1954, 1961, 1962, 1968, 1990, 2003, 2056, 2067, 2081, 2090, 2095, 2120, 2125, 2132, 2138, 2144, 2151, 2171, 2172, 2183, 2187, 2191, 2206, 2208, 2229, 2240, 2242, 2245, 2261, 2276, 2286, 2292, 2316, 2333, 2335, 2366, 2383, 2392, 2392, 2416, 2424, 2428, 2433, 2435, 2455, 2464, 2470, 2474, 2493, 2520, 2528, 2532, 2551, 2556, 2562, 2566, 2593, 2595, 2651, 2652, 2670, 2685, 2689, 2739, 2743, 2760, 2773, 2791, 2802, 2817, 2875, 2935, 2939, 2941, 2951, 2962, 2991, 3002, 3004, 3020, 3066, 3086, 3089, 3099, 3124, 3132, 3137, 3142, 3153, 3168, 3175, 3202, 3226, 3242, 3258, 3259, 3272, 3288, 3295, 3308, 3310, 3313, 3334, 3350, 3351, 3365, 3372, 3376, 3392, 3409, 3424, 3425, 3426, 3442, 3449, 3474, 3496, 3500, 3556, 3571, 3578, 3587, 3599, 3606, 3624, 3626, 3670, 3690, 3702, 3734, 3741, 3768, 3772, 3773, 3794, 3802, 3806, 3812, 3813, 3814, 3833, 3884, 3888, 3889, 3890, 3894, 3922, 3931, 3932, 3945, 3959, 3999, 4024, 4037, 4058, 4065, 4065, 4068, 4072, 4075, 4077, 4091, 4129, 4143, 4184, 4196, 4196, 4211, 4223, 4225, 4252, 4264, 4282, 4292, 4305, 4322, 4324, 4331, 4335, 4358, 4367, 4371, 4380, 4382, 4400, 4403, 4407, 4415, 4417, 4425, 4432, 4432, 4472, 4486, 4503, 4505, 4511, 4515, 4528, 4528, 4529, 4567, 4591, 4610, 4612, 4612, 4629, 4634, 4637, 4657, 4664, 4678, 4694, 4701, 4755, 4798, 4808, 4824, 4833, 4833, 4837, 4851, 4862, 4875, 4882, 4885, 4922, 4925, 4934, 4938, 4971, 5001, 5003, 5004, 5005, 5007, 5024, 5028, 5040, 5045, 5053, 5056, 5056, 5057, 5062, 5072, 5092, 5100, 5106, 5112, 5114, 5124, 5125, 5138, 5140, 5142, 5151, 5159, 5179, 5180, 5200, 5207, 5221, 5237, 5261, 5269, 5273, 5276, 5282, 5284, 5292, 5301, 5306, 5342, 5351, 5358, 5365, 5369, 5370, 5376, 5395, 5405, 5423, 5425, 5470, 5480, 5492, 5501, 5507, 5511, 5512, 5517, 5518, 5526, 5531, 5533, 5539, 5543, 5570, 5588, 5591, 5599, 5600, 5602, 5646, 5648, 5656, 5659, 5663, 5680, 5715, 5736, 5754, 5757, 5784, 5806, 5808, 5827, 5834, 5837, 5847, 5867, 5876, 5877, 5879, 5884, 5894, 5900, 5901, 5948, 5957, 5969, 5970, 5979, 5996, 6014, 6028, 6033, 6054, 6116, 6120, 6126, 6135, 6140, 6169, 6198, 6201, 6218, 6218, 6229, 6236, 6247, 6251, 6259, 6266, 6278, 6279, 6303, 6345, 6361, 6366, 6378, 6386, 6391, 6432, 6449, 6462, 6475, 6479, 6535, 6535, 6536, 6539, 6550, 6552, 6554, 6572, 6582, 6606, 6608, 6610, 6652, 6656, 6669, 6678, 6704, 6722, 6743, 6747, 6757, 6767, 6787, 6795, 6807, 6813, 6830, 6837, 6843, 6843, 6847, 6849, 6856, 6882, 6895, 6898, 6906, 6912, 6916, 6918, 6939, 6955, 6961, 6962, 6980, 6994, 7022, 7022, 7036, 7039, 7041, 7045, 7075, 7081, 7082, 7087, 7103, 7107, 7116, 7129, 7131, 7165, 7171, 7173, 7174, 7179, 7180, 7183, 7186, 7204, 7217, 7224, 7227, 7250, 7255, 7270, 7273, 7300, 7301, 7315, 7322, 7338, 7343, 7350, 7358, 7376, 7379, 7383, 7505, 7517, 7526, 7530, 7536, 7543, 7546, 7552, 7558, 7562, 7565, 7585, 7597, 7598, 7609, 7634, 7666, 7688, 7713, 7726, 7736, 7739, 7750, 7755, 7763, 7776, 7784, 7788, 7798, 7799, 7807, 7812, 7817, 7822, 7832, 7897, 7921, 7936, 7942, 7945, 7949, 7956, 7958, 7970, 8001, 8003, 8016, 8035, 8043, 8055, 8060, 8061, 8066, 8071, 8074, 8138, 8140, 8140, 8152, 8188, 8193, 8203, 8209, 8233, 8249, 8252, 8255, 8256, 8269, 8273, 8298, 8302, 8340, 8370, 8372, 8391, 8433, 8453, 8476, 8493, 8496, 8501, 8505, 8539, 8552, 8563, 8573, 8579, 8594, 8604, 8621, 8631, 8640, 8651, 8664, 8675, 8685, 8692, 8692, 8697, 8707, 8727, 8733, 8738, 8755, 8770, 8770, 8779, 8782, 8792, 8802, 8807, 8824, 8827, 8837, 8855, 8901, 8910, 8925, 8932, 8965, 8991, 8998, 9011, 9032, 9066, 9082, 9124, 9133, 9139, 9155, 9164, 9166, 9168, 9190, 9199, 9201, 9208, 9226, 9227, 9227, 9231, 9258, 9276, 9281, 9287, 9289, 9296, 9306, 9329, 9340, 9352, 9355, 9358, 9380, 9384, 9422, 9428, 9437, 9449, 9474, 9505, 9564, 9570, 9577, 9583, 9669, 9681, 9692, 9710, 9724, 9725, 9739, 9741, 9743, 9770, 9774, 9778, 9780, 9817, 9823, 9831, 9845, 9847, 9855, 9879, 9887, 9905, 9930, 9937, 9939, 9944, 9950, 9955, 9970, 9971, 9990
        );

        List<Integer> c = Arrays.asList( 43, 64, 67, 71, 74, 104, 112, 144, 153, 161, 182, 184, 196, 253, 264, 344, 345, 354, 377, 378, 427, 441, 481, 502, 506, 521, 543, 552, 574, 655, 697, 707, 725, 742, 744, 767, 775, 800, 805, 841, 847, 862, 863, 864, 1034, 1106, 1150, 1160, 1179, 1203, 1246, 1271, 1287, 1307, 1313, 1316, 1432, 1446, 1458, 1459, 1473, 1482, 1483, 1496, 1534, 1585, 1639, 1670, 1689, 1744, 1747, 1780, 1788, 1824, 1861, 1872, 1891, 1921, 1950, 1973, 2031, 2038, 2115, 2137, 2153, 2183, 2230, 2262, 2266, 2300, 2316, 2349, 2378, 2396, 2407, 2414, 2514, 2555, 2586, 2604, 2633, 2647, 2654, 2669, 2672, 2676, 2722, 2728, 2732, 2783, 2789, 2793, 2825, 2882, 2889, 2931, 2948, 3048, 3065, 3078, 3080, 3093, 3098, 3120, 3171, 3172, 3320, 3332, 3366, 3370, 3431, 3433, 3440, 3460, 3498, 3507, 3508, 3512, 3542, 3564, 3569, 3580, 3596, 3630, 3631, 3637, 3764, 3771, 3791, 3836, 3838, 3892, 3910, 3931, 3944, 3973, 4033, 4059, 4079, 4115, 4127, 4130, 4132, 4136, 4173, 4216, 4250, 4283, 4346, 4390, 4411, 4445, 4446, 4533, 4579, 4617, 4619, 4644, 4661, 4662, 4687, 4714, 4761, 4801, 4814, 4818, 4899, 4911, 4922, 4992, 4994, 5007, 5008, 5031, 5079, 5107, 5119, 5148, 5161, 5161, 5174, 5220, 5262, 5305, 5307, 5348, 5361, 5406, 5426, 5499, 5516, 5537, 5549, 5551, 5555, 5563, 5571, 5581, 5616, 5636, 5650, 5656, 5659, 5673, 5684, 5689, 5708, 5713, 5725, 5737, 5768, 5807, 5837, 5872, 5876, 5904, 5920, 5934, 5943, 5975, 5980, 5997, 6005, 6020, 6055, 6061, 6063, 6078, 6085, 6102, 6144, 6175, 6198, 6241, 6245, 6265, 6289, 6307, 6321, 6341, 6382, 6424, 6445, 6499, 6540, 6565, 6581, 6650, 6696, 6699, 6794, 6854, 6860, 6888, 6898, 6921, 6956, 6994, 7007, 7060, 7098, 7140, 7146, 7149, 7179, 7224, 7238, 7245, 7285, 7293, 7325, 7346, 7394, 7404, 7412, 7429, 7450, 7458, 7497, 7551, 7559, 7573, 7587, 7659, 7660, 7663, 7686, 7686, 7694, 7702, 7729, 7769, 7776, 7815, 7843, 7849, 787
        );

        List<Integer>  a1= Arrays.asList( 8, 49, 57, 120, 140, 160, 248, 353, 452, 462, 680, 695, 708, 739, 811, 837, 918, 938, 971, 990, 1027, 1050, 1075, 1096, 1104, 1114, 1184, 1252, 1292, 1302, 1320, 1337, 1389, 1392, 1513, 1560, 1619, 1731, 1813, 1880, 1881, 1885, 1896, 1990, 2059, 2075, 2121, 2228, 2271, 2271, 2396, 2410, 2411, 2492, 2493, 2553, 2563, 2663, 2727, 2793, 2983, 2984, 3097, 3136, 3232, 3270, 3824, 3883, 3891, 3926, 3930, 3943, 4061, 4076, 4203, 4234, 4242, 4273, 4290, 4302, 4316, 4443, 4510, 4728, 4844, 4848, 4902, 4953, 4987, 4998, 5020, 5061, 5109, 5134, 5216, 5310, 5319, 5342, 5424, 5523, 5568, 5574, 5596, 5597, 5682, 5687, 5832, 5881, 5908, 5928, 5984, 6178, 6302, 6352, 6375, 6435, 6556, 6592, 6613, 6644, 6674, 6685, 6742, 6867, 6891, 6923, 6974, 6975, 7023, 7075, 7101, 7131, 7181, 7197, 7321, 7390, 7400, 7449, 7454, 7558, 7658, 7729, 7750, 7760, 7852, 7856, 7873, 7950, 8012, 8125, 8158, 8160, 8202, 8521, 8534, 8590, 8630, 8658, 8689, 8714, 8755, 8765, 8779, 8795, 8837, 8874, 8946, 9082, 9085, 9121, 9148, 9161, 9177, 9301, 9310, 9348, 9366, 9428, 9458, 9474, 9501, 9504, 9586, 9603, 9605, 9663, 9802
        );

        List<Integer>  b1 = Arrays.asList(4, 23, 60, 83, 91, 125, 127, 129, 147, 191, 220, 234, 259, 279, 340, 347, 388, 392, 407, 421, 425, 441, 473, 495, 511, 511, 515, 518, 522, 562, 591, 603, 665, 671, 694, 738, 753, 760, 778, 792, 800, 824, 870, 905, 906, 924, 985, 988, 1007, 1034, 1035, 1058, 1073, 1088, 1093, 1096, 1111, 1112, 1144, 1162, 1167, 1171, 1190, 1199, 1210, 1211, 1237, 1237, 1247, 1283, 1340, 1396, 1405, 1422, 1439, 1442, 1443, 1450, 1465, 1472, 1517, 1549, 1555, 1593, 1620, 1623, 1652, 1664, 1668, 1671, 1684, 1730, 1757, 1770, 1780, 1800, 1831, 1837, 1866, 1890, 1891, 1964, 2027, 2040, 2056, 2112, 2144, 2198, 2224, 2246, 2297, 2309, 2337, 2337, 2364, 2417, 2427, 2446, 2461, 2462, 2475, 2501, 2521, 2546, 2625, 2630, 2632, 2638, 2646, 2683, 2716, 2732, 2766, 2781, 2784, 2828, 2840, 2841, 2842, 2862, 2892, 2899, 2930, 2936, 2956, 2978, 2990, 3046, 3057, 3108, 3135, 3138, 3153, 3155, 3219, 3226, 3244, 3270, 3272, 3292, 3336, 3367, 3375, 3380, 3390, 3406, 3414, 3416, 3430, 3436, 3501, 3510, 3519, 3539, 3562, 3573, 3573, 3619, 3642, 3652, 3659, 3664, 3689, 3694, 3709, 3711, 3731, 3736, 3744, 3791, 3813, 3848, 3859, 3872, 3900, 3909, 3924, 3965, 3971, 3980, 3993, 4005, 4029, 4052, 4078, 4101, 4105, 4142, 4154, 4162, 4203, 4208, 4239, 4252, 4274, 4299, 4333, 4336, 4338, 4338, 4354, 4387, 4396, 4434, 4464, 4501, 4516, 4519, 4533, 4534, 4552, 4581, 4582, 4585, 4590, 4599, 4612, 4621, 4627, 4656, 4668, 4669, 4681, 4725, 4760, 4762, 4770, 4798, 4815, 4836, 4837, 4935, 4943, 4946, 4954, 4970, 4978, 4991, 5017, 5037, 5041, 5052, 5054, 5073, 5082, 5112, 5131, 5131, 5155, 5162, 5203, 5234, 5237, 5241, 5251, 5269, 5294, 5297, 5299, 5329, 5332, 5338, 5346, 5419, 5442, 5513, 5568, 5569, 5603, 5621, 5652, 5680, 5689, 5709, 5730, 5739, 5756, 5777, 5783, 5802, 5831, 5876, 5890, 5912, 5918, 5928, 5955, 5970, 5970, 5991, 6061, 6062, 6068, 6086, 6119, 6122, 6123, 6247, 6268, 6340, 6389, 6406, 6417, 6421, 6422, 6444, 6479, 6482, 6500, 6533, 6550, 6553, 6555, 6582, 6597, 6664, 6687, 6705, 6717, 6735, 6763, 6770, 6774, 6791, 6792, 6808, 6811, 6825, 6856, 6863, 6881, 6902, 6907, 6969, 7019, 7024, 7036, 7162, 7163, 7172, 7219, 7219, 7247, 7301, 7305, 7362, 7383, 7406, 7406, 7420, 7445, 7494, 7509, 7523, 7527, 7534, 7541, 7557, 7568, 7623, 7664, 7665, 7681, 7681, 7688, 7691, 7696, 7702, 7714, 7754, 7771, 7784, 7793, 7810, 7811, 7817, 7817, 7832, 7860, 7902, 7905, 7909, 7912, 7926, 7944, 7944, 7975, 8011, 8026, 8027, 8064, 8100, 8162, 8174, 8241, 8261, 8265, 8275, 8323, 8325, 8354, 8384, 8389, 8417, 8422, 8445, 8524, 8547, 8578, 8578, 8601, 8607, 8629, 8662, 8711, 8719, 8723, 8732, 8742, 8784, 8812, 8820, 8821, 8836, 8862, 8891, 8901, 8910, 8930, 8982, 8985, 8999, 9042, 9054, 9070, 9101, 9110, 9139, 9143, 9173, 9177, 9209, 9281, 9300, 9303, 9330, 9334, 9401, 9432, 9435, 9449, 9486, 9550, 9742, 9742, 9784, 9837, 9893, 9904, 9930, 9942, 9962, 9992
        );

        List<Integer> c1 = Arrays.asList( 94, 128, 160, 220, 235, 249, 300, 393, 468, 487, 536, 548, 583, 587, 601, 601, 603, 659, 686, 713, 718, 765, 809, 898, 901, 917, 923, 945, 1074, 1112, 1151, 1194, 1233, 1286, 1288, 1314, 1322, 1347, 1403, 1411, 1519, 1614, 1724, 1768, 1824, 1842, 1862, 1877, 1896, 1966, 2061, 2067, 2071, 2094, 2097, 2102, 2104, 2129, 2235, 2284, 2312, 2395, 2434, 2587, 2649, 2655, 2674, 2729, 2758, 2839, 2869, 2902, 2909, 2955, 2960, 3005, 3034, 3043, 3081, 3132, 3152, 3158, 3175, 3177, 3183, 3284, 3332, 3341, 3378, 3428, 3458, 3501, 3515, 3541, 3561, 3574, 3587, 3664, 3684, 3725, 3734, 3744, 3792, 3902, 3931, 3936, 3947, 3979, 4045, 4058, 4064, 4181, 4208, 4262, 4278, 4342, 4415, 4654, 4678, 4747, 4833, 4864, 4901, 4939, 5041, 5064, 5092, 5137, 5140, 5146, 5205, 5220, 5226, 5229, 5322, 5359, 5376, 5428, 5452, 5512, 5533, 5547, 5567, 5672, 5745, 5801, 5802, 5843, 5852, 6068, 6072, 6128, 6140, 6175, 6187, 6190, 6216, 6277, 6306, 6438, 6455, 6495, 6569, 6607, 6609, 6634, 6692, 6739, 6752, 6784, 6825, 6829, 6855, 6862, 6899, 6965, 6976, 7001, 7067, 7087, 7161, 7208, 7252, 7290, 7351, 7420, 7433, 7435, 7435, 7522, 7581, 7647, 7712, 7731, 7749, 7782, 7827, 7839, 7845, 7854, 7893, 7933, 7938, 7969, 8009, 8176, 8228, 8253, 8253, 8276, 8289, 8309, 8323, 8330, 8332, 8343, 8356, 8385, 8391, 8425, 8518, 8572, 8623, 8627, 8635, 8635, 8661, 8715, 8716, 8719, 8776, 8802, 8825, 8830, 8841, 8853, 8884, 8903, 8905, 8907, 8985, 8995, 9018, 9039, 9077, 9093, 9141, 9191, 9214, 9242, 9344, 9444, 9488, 9594, 9602, 9610, 9622, 9640, 9646, 9650, 9705, 9706, 9711, 9760, 9780, 9799, 9813, 9876, 9913, 9937, 9968
        );

        System.out.println(minimize(a, b, c));

        System.out.println(minimize(Arrays.asList(1, 4, 10), Arrays.asList(2, 15, 20), Arrays.asList(10,20)));
    }
}
