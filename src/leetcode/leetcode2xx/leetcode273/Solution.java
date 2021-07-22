package leetcode.leetcode2xx.leetcode273;

public class Solution {
    private static final String[] digits = {
            "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
            "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen",
            "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };

    private static void multiplier(int num, StringBuilder sb) {
        if (num >= 100) sb.append(' ').append(digits[num / 100]).append(" Hundred");
        num %= 100;
        if (num == 0) return;
        if (num > 20) {
            sb.append(' ').append(digits[20 + (num - 20) / 10]);
            if (num % 10 != 0) sb.append(' ').append(digits[num % 10]);
        } else sb.append(' ').append(digits[num]);
    }

    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        StringBuilder sb = new StringBuilder();
        if (num >= 1_000_000_000) {
            multiplier(num / 1_000_000_000, sb);
            sb.append(" Billion");
        }
        num %= 1_000_000_000;
        if (num >= 1_000_000) {
            multiplier(num / 1_000_000, sb);
            sb.append(" Million");
        }
        num %= 1_000_000;
        if (num >= 1_000) {
            multiplier(num / 1_000, sb);
            sb.append(" Thousand");
        }
        num %= 1_000;
        if (num != 0) multiplier(num, sb);
        return sb.substring(1);
    }
}
