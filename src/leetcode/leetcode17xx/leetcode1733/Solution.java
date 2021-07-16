package leetcode.leetcode17xx.leetcode1733;

import java.util.Arrays;

public class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        int m = languages.length;
        boolean[] processed = new boolean[m];
        boolean[] counted = new boolean[m];
        int[] count = new int[n + 1];
        int total = 0;
        int maxCount = 0;

        for (int[] friendship : friendships) {
            int u = friendship[0] - 1, v = friendship[1] - 1;
            if (counted[u] && counted[v]) continue;
            int[] arr1 = languages[u];
            if (!processed[u]) {
                processed[u] = true;
                Arrays.sort(arr1);
            }
            int[] arr2 = languages[v];
            if (!processed[v]) {
                processed[v] = true;
                Arrays.sort(arr2);
            }
            boolean haveCommonLanguage = false;
            int i1 = 0, i2 = 0, n1 = arr1.length, n2 = arr2.length;
            while (i1 < n1 && i2 < n2) {
                if (arr1[i1] == arr2[i2]) {
                    haveCommonLanguage = true;
                    break;
                } else if (arr1[i1] < arr2[i2]) i1++;
                else i2++;
            }
            if (!haveCommonLanguage && !counted[u]) {
                total++;
                counted[u] = true;
                for (int a : arr1) if (++count[a] > maxCount) maxCount = count[a];
            }
            if (!haveCommonLanguage && !counted[v]) {
                total++;
                counted[v] = true;
                for (int a : arr2) if (++count[a] > maxCount) maxCount = count[a];
            }
        }
        return total - maxCount;
    }
}
