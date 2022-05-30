package leetcode.leetcode22xx.leetcode2288;

public class Solution {
    public String discountPrices(String sentence, int discount) {
        String[] s = sentence.split(" ");
        for (int i = 0; i < s.length; i++) {
            if (isPrice(s[i])) {
                double price = Double.parseDouble(s[i].substring(1)) * 100;
                price = price - price * discount / 100;
                long cents = (long) price;
                s[i] = "$" + cents / 100 + "." + cents % 100 / 10 + cents % 10;
            }
        }
        return String.join(" ", s);
    }

    private static boolean isPrice(String s) {
        if (s.length() < 2) return false;
        if (s.charAt(0) != '$') return false;
        boolean dot = false;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '.') {
                if (dot) return false;
                dot = true;
            } else if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }
}
