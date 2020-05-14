package leetcode.leetcode4xx.leetcode438;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int n = s.length();
        int k = p.length();
        List<Integer> ans = new LinkedList<>();
        if (n < k) return ans;
        int[] count = new int[26];
        for (char c : p.toCharArray()) {
            count[c - 'a']++;
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < k; i++) {
            count[chars[i] - 'a']--;
        }
        int numberOfOk = 0;
        for (int a : count) if (a == 0) numberOfOk++;
        if (numberOfOk == 26) ans.add(0);
        for (int i = k, j = 0; i < n; i++, j++) {
            int c1 = chars[j] - 'a';
            int c2 = chars[i] - 'a';
            if (count[c1] == 0) numberOfOk--;
            count[c1]++;
            if (count[c1] == 0) numberOfOk++;

            if (count[c2] == 0) numberOfOk--;
            count[c2]--;
            if (count[c2] == 0) numberOfOk++;

            if (numberOfOk == 26) ans.add(j + 1);
        }
        return ans;
    }
}
