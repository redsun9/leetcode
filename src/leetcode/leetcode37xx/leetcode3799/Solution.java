package leetcode.leetcode37xx.leetcode3799;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<String>> wordSquares(String[] words) {
        int n = words.length;
        Arrays.sort(words);
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j || words[i].charAt(0) != words[j].charAt(0)) continue;
                for (int k = 0; k < n; k++) {
                    if (k == i || k == j || words[i].charAt(3) != words[k].charAt(0)) continue;
                    for (int l = 0; l < n; l++) {
                        if (l == i || l == j || l == k || words[j].charAt(3) != words[l].charAt(0) || words[k].charAt(3) != words[l].charAt(3)) continue;
                        ans.add(List.of(words[i], words[j], words[k], words[l]));
                    }
                }
            }
        }
        return ans;
    }
}
