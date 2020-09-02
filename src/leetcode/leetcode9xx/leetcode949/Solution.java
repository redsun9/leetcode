package leetcode.leetcode9xx.leetcode949;

public class Solution {
    public String largestTimeFromDigits(int[] arr) {
        int[] count = new int[10];
        int count01 = 0, count03 = 0, count05 = 0;
        int d1, d2, d3, d4;
        for (int a : arr) {
            count[a]++;
            if (a <= 1) {
                count01++;
                count03++;
                count05++;
            } else if (a <= 3) {
                count03++;
                count05++;
            } else if (a <= 5) {
                count05++;
            }
        }
        if (count[2] != 0 && count03 >= 2 && count05 >= 3) {
            // 23:xx
            d1 = 2;
            count[d1]--;
            d2 = findDigit(count, 3);
            count[d2]--;
            d3 = findDigit(count, 5);
            count[d3]--;
            d4 = findDigit(count, 9);
            return "" + d1 + d2 + ":" + d3 + d4;
        } else if (count01 != 0 && count05 >= 2) {
            d1 = findDigit(count, 1);
            count[d1]--;
            d2 = findDigit(count, 9);
            count[d2]--;
            d3 = findDigit(count, 5);
            count[d3]--;
            d4 = findDigit(count, d2);
            return "" + d1 + d2 + ":" + d3 + d4;
        } else return "";
    }

    private int findDigit(int[] count, int max) {
        while (count[max] == 0) max--;
        return max;
    }
}
