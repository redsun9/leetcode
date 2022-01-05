package leetcode.leetcode21xx.leetcode2117;

public class Solution {
    public String abbreviateProduct(int left, int right) {
        int twoPower = 0, fivePower = 0;
        double firstDigits = 1;
        long lastDigits = 1;
        boolean meaningfulDigitsAbove10 = false;

        for (int i = left; i <= right; i++) {
            int tmp = i;
            while (tmp % 2 == 0) {
                twoPower++;
                tmp /= 2;
            }
            while (tmp % 5 == 0) {
                fivePower++;
                tmp /= 5;
            }

            lastDigits *= tmp;
            if (lastDigits >= 10_000_000_000L) {
                meaningfulDigitsAbove10 = true;
                lastDigits %= 10_000_000_000L;
            }

            firstDigits *= tmp;
            while (firstDigits >= 10_000_000_000L) firstDigits /= 10;
        }

        int tenPower = Math.min(twoPower, fivePower);
        twoPower -= tenPower;
        fivePower -= tenPower;

        for (int i = 0; i < twoPower; i++) {
            lastDigits *= 2;
            if (lastDigits >= 10_000_000_000L) {
                meaningfulDigitsAbove10 = true;
                lastDigits %= 10_000_000_000L;
            }
            firstDigits *= 2;
            if (firstDigits >= 10_000_000_000L) firstDigits /= 10;
        }

        for (int i = 0; i < fivePower; i++) {
            lastDigits *= 5;
            if (lastDigits >= 10_000_000_000L) {
                meaningfulDigitsAbove10 = true;
                lastDigits %= 10_000_000_000L;
            }
            firstDigits *= 5;
            if (firstDigits >= 10_000_000_000L) firstDigits /= 10;
        }

        if (meaningfulDigitsAbove10) {
            return String.format("%d...%05de%d", (int) (firstDigits / 100_000), lastDigits % 100_000, tenPower);
        } else {
            return lastDigits + "e" + tenPower;
        }
    }
}
