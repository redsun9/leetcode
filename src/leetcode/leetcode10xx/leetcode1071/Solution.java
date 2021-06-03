package leetcode.leetcode10xx.leetcode1071;

public class Solution {
    //greatest common divisor
    private static int gcd(int a, int b) {
        int c;
        while (b != 0) {
            a %= b;
            c = a;
            a = b;
            b = c;
        }
        return a;
    }

    public String gcdOfStrings(String str1, String str2) {
        int k = gcd(str1.length(), str2.length());
        int t1 = str1.length() / k;
        int t2 = str2.length() / k;
        for (int t = 1, i2 = k; t < t1; t++) {
            for (int i1 = 0; i1 < k; i1++, i2++) {
                if (str1.charAt(i1) != str1.charAt(i2)) return "";
            }
        }
        for (int t = 0, i2 = 0; t < t2; t++) {
            for (int i1 = 0; i1 < k; i1++, i2++) {
                if (str1.charAt(i1) != str2.charAt(i2)) return "";
            }
        }
        return str1.substring(0, k);

    }
}
