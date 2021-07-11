package leetcode.leetcode18xx.leetcode1813;

public class Solution {
    public boolean areSentencesSimilar(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        if (m == 0 || n == 0) return true;
        if (m == n) return s1.equals(s2);
        if (m > n) {
            int tmpInt = m;
            m = n;
            n = tmpInt;
            String tmpStr = s1;
            s1 = s2;
            s2 = tmpStr;
        }
        int l1 = -1, i = 0;
        while (i < m) {
            if (s1.charAt(i) != s2.charAt(i)) break;
            if (s1.charAt(i) == ' ') {
                l1 = i;
            }
            i++;
        }
        if (i == m && s2.charAt(m) == ' ') return true;

        int i1 = m - 1, i2 = n - 1;
        while (i1 >= 0) {
            if (s1.charAt(i1) != s2.charAt(i2)) break;
            if (s1.charAt(i1) == ' ') {
                if (l1 == i1) return true;
            }
            i1--;
            i2--;
        }
        return i1 == l1 && s2.charAt(i2) == ' ';

    }
}
