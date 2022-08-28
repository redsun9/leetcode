package leetcode.leetcode23xx.leetcode2391;

public class Solution2 {
    public int garbageCollection(String[] garbage, int[] travel) {
        int n = garbage.length;
        int paperIdx = n - 1;
        while (paperIdx > 0 && garbage[paperIdx].indexOf('P') == -1) paperIdx--;
        int metalIdx = n - 1;
        while (metalIdx > 0 && garbage[metalIdx].indexOf('M') == -1) metalIdx--;
        int glassIdx = n - 1;
        while (glassIdx > 0 && garbage[glassIdx].indexOf('G') == -1) glassIdx--;

        for (int i = 2; i < n; i++) travel[i - 1] += travel[i - 2];
        int ans = 0;
        for (String s : garbage) ans += s.length();
        if (paperIdx > 0) ans += travel[paperIdx - 1];
        if (metalIdx > 0) ans += travel[metalIdx - 1];
        if (glassIdx > 0) ans += travel[glassIdx - 1];
        return ans;
    }
}
