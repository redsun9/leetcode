package leetcode.leetcode16xx.leetcode1662;

public class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int n1 = word1.length;
        int n2 = word2.length;
        int i1 = 0, i2 = 0, j1 = 0, j2 = 0, l1 = 0, l2 = 0;
        while (i1 < n1 && i2 < n2) {
            l1 = word1[i1].length();
            l2 = word2[i2].length();
            while (j1 < l1 && j2 < l2) {
                if (word1[i1].charAt(j1) != word2[i2].charAt(j2)) return false;
                j1++;
                j2++;
            }
            if (j1 >= l1) {
                i1++;
                j1 = 0;
                while (i1 < n1 && word1[i1].length() == 0) i1++;
            }
            if (j2 >= l2) {
                i2++;
                j2 = 0;
                while (i2 < n2 && word2[i2].length() == 0) i2++;
            }
        }
        while (i1 < n1) if (word1[i1++].length() != 0) return false;
        while (i2 < n2) if (word2[i2++].length() != 0) return false;
        return true;
    }
}
