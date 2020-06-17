package leetcode.leetcode14xx.leetcode1408;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

//using rolling hash
public class Solution2 {
    private static final long base = 29L;
    private static final long mod = Integer.MAX_VALUE;

    public List<String> stringMatching(String[] words) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] full = new int[words.length];
        for (int k = 0; k < words.length; k++) {
            String str = words[k];
            int n = str.length();
            for (int i = 0; i < n; i++) {
                long hash = 0;
                for (int j = i; j < n; j++) {
                    hash = hash * base + str.charAt(j) % mod;
                    map.merge((int) hash, 1, Integer::sum);
                }
                if (i == 0) full[k] = (int) hash;
            }
        }
        List<String> ans = new LinkedList<>();
        for (int i = 0; i < words.length; i++) {
            if (map.get(full[i]) > 1) ans.add(words[i]);
        }
        return ans;
    }
}
