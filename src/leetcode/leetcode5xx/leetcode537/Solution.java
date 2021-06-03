package leetcode.leetcode5xx.leetcode537;

public class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        int pos1 = num1.indexOf('+');
        int pos2 = num2.indexOf('+');
        int a = Integer.parseInt(num1.substring(0, pos1));
        int b = Integer.parseInt(num1.substring(pos1 + 1, num1.length() - 1));
        int c = Integer.parseInt(num2.substring(0, pos2));
        int d = Integer.parseInt(num2.substring(pos2 + 1, num2.length() - 1));
        int re = a * c - b * d;
        int im = a * d + b * c;
        return re + "+" + im + "i";
    }
}
