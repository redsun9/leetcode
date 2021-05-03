package leetcode.leetcode17xx.leetcode1754;

public class Solution {
    public String largestMerge(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        char[] arr1 = word1.toCharArray();
        char[] arr2 = word2.toCharArray();
        char[] ans = new char[n1 + n2];
        int i = 0, i1 = 0, i2 = 0, j1, j2;
        while (i1 < n1 && i2 < n2) {
            j1 = i1;
            j2 = i2;
            while (true) {
                if (j1 >= n1) ans[i++] = arr2[i2++];
                else if (j2 >= n2) ans[i++] = arr1[i1++];
                else if (arr1[j1] > arr2[j2]) ans[i++] = arr1[i1++];
                else if (arr1[j1] < arr2[j2]) ans[i++] = arr2[i2++];
                else {
                    j1++;
                    j2++;
                    continue;
                }
                break;
            }
        }
        while (i1 < n1) ans[i++] = arr1[i1++];
        while (i2 < n2) ans[i++] = arr2[i2++];
        return new String(ans);
    }
}
