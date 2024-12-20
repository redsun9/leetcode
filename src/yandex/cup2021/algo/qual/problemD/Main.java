package yandex.cup2021.algo.qual.problemD;

import java.util.Scanner;

public class Main {
    private static final int[] ans = {
            0, 1, 1, 2, 2, 2, 3, 3, 4, 3, 4, 5, 5, 6, 4, 5, 7, 6, 9, 8, 5, 6, 9, 9, 9, 13, 10, 6, 7, 11, 13, 10, 17,
            17, 12, 7, 8, 13, 17, 16, 15, 25, 21, 14, 8, 9, 15, 21, 23, 16, 31, 33, 25, 16, 9, 10, 17, 25, 31, 28,
            25, 47, 41, 29, 18, 10, 11, 19, 29, 39, 42, 26, 57, 63, 49, 33, 20, 11, 12, 21, 33, 47, 57, 50, 43, 89,
            79, 57, 37, 22, 12, 13, 23, 37, 55, 73, 78, 44, 107, 121, 95, 65, 41, 24, 13, 14, 25, 41, 63, 89, 108,
            92, 77, 171, 153, 111, 73, 45, 26, 14, 15, 27, 45, 71, 105, 139, 148, 78, 205, 235, 185, 127, 81, 49,
            28, 15, 16, 29, 49, 79, 121, 171, 208, 174, 143, 333, 299, 217, 143, 89, 53, 30, 16, 17, 31, 53, 87,
            137, 203, 270, 286, 144, 399, 461, 363, 249, 159, 97, 57, 32, 17, 18, 33, 57, 95, 153, 235, 333, 406,
            336, 273, 655, 589, 427, 281, 175, 105, 61, 34, 18, 19, 35, 61, 103, 169, 267, 397, 530, 560, 274, 785,
            911, 717, 491, 313, 191, 113, 65, 36, 19, 20, 37, 65, 111, 185, 299, 461, 656, 800, 658, 531, 1297,
            1167, 845, 555, 345, 207, 121, 69, 38, 20, 21, 39, 69, 119, 201, 331, 525, 783, 1048, 1106, 532, 1555,
            1809, 1423, 973, 619, 377, 223, 129, 73, 40, 21, 22, 41, 73, 127, 217, 363, 589, 911, 1300, 1586, 1300,
            1045, 2579, 2321, 1679, 1101, 683, 409, 239, 137, 77, 42, 22, 23, 43, 77, 135, 233, 395, 653, 1039,
            1554, 2082, 2196, 1046, 3093, 3603, 2833, 1935, 1229, 747, 441, 255, 145, 81, 44, 23, 24, 45, 81, 143,
            249, 427, 717, 1167, 1809, 2586, 3156, 2582, 2071, 5141, 4627, 3345, 2191, 1357, 811, 473, 271, 153,
            85, 46, 24, 25, 47, 85, 151, 265, 459, 781, 1295, 2065, 3094, 4148, 4374, 2072, 6167, 7189, 5651, 3857,
            2447, 1485, 875, 505, 287, 161, 89, 48, 25, 26, 49, 89, 159, 281, 491, 845, 1423, 2321, 3604, 5156,
            6294, 5144, 4121, 10263, 9237, 6675, 4369, 2703, 1613, 939, 537, 303, 169, 93, 50, 26, 27, 51, 93, 167,
            297, 523, 909, 1551, 2577, 4115, 6172, 8278, 8728, 4122, 12313, 14359, 11285, 7699, 4881, 2959, 1741,
            1003, 569, 319, 177, 97, 52, 27, 28, 53, 97, 175, 313, 555, 973, 1679, 2833, 4627, 7192, 10294, 12568,
            10266, 8219, 20505, 18455, 13333, 8723, 5393, 3215, 1869, 1067, 601, 335, 185, 101, 54, 28, 29, 55,
            101, 183, 329, 587, 1037, 1807, 3089, 5139, 8214, 12326, 16536, 17434, 8220, 24603, 28697, 22551,
            15381, 9747, 5905, 3471, 1997, 1131, 633, 351, 193, 105, 56, 29, 30, 57, 105, 191, 345, 619, 1101,
            1935, 3345, 5651, 9237, 14366, 20568, 25114, 20508, 16413, 40987, 36889, 26647, 17429, 10771, 6417,
            3727, 2125, 1195, 665, 367, 201, 109, 58, 30
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        System.out.println(solve(n, m));
    }

    private static int solve(int n, int m) {
        int a = 31 - Integer.numberOfLeadingZeros(n);
        int b = 31 - Integer.numberOfLeadingZeros(m);
        return m * n + ans[(a + b) * (a + b + 1) / 2 + a];
    }
}
