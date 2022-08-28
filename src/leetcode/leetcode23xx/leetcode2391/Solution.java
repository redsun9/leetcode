package leetcode.leetcode23xx.leetcode2391;

public class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int n = garbage.length, ans = 0;
        for (int i = 2; i < n; i++) travel[i - 1] += travel[i - 2];
        int paperIdx = 0, metalIdx = 0, glassIdx = 0;
        for (int i = 0; i < n; i++) {
            String s = garbage[i];
            int m = s.length();
            for (int j = 0; j < m; j++) {
                switch (s.charAt(j)) {
                    case 'P' -> paperIdx = i;
                    case 'M' -> metalIdx = i;
                    case 'G' -> glassIdx = i;
                }
            }
            ans += m;
        }
        if (paperIdx > 0) ans += travel[paperIdx - 1];
        if (metalIdx > 0) ans += travel[metalIdx - 1];
        if (glassIdx > 0) ans += travel[glassIdx - 1];
        return ans;
    }
}
