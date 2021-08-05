package leetcode.leetcode11xx.leetcode1178;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        Map<Integer, Integer> map = new HashMap<>();
        for (String word : words) {
            int mask = 0;
            int length = word.length();
            for (int i = 0; i < length; i++) mask |= 1 << (word.charAt(i) - 'a');
            map.compute(mask, (k, v) -> v == null ? 1 : v + 1);
        }
        List<Integer> ans = new ArrayList<>(puzzles.length);
        for (String puzzle : puzzles) {
            int mask = 0;
            int length = puzzle.length();
            for (int i = 1; i < length; i++) mask |= 1 << (puzzle.charAt(i) - 'a');
            int firstChar = 1 << (puzzle.charAt(0) - 'a');
            mask &= ~firstChar;
            int subMask = mask;
            int sum = 0;
            while (true) {
                sum += map.getOrDefault(subMask | firstChar, 0);
                if (subMask == 0) break;
                subMask = (subMask - 1) & mask;
            }
            ans.add(sum);
        }
        return ans;
    }
}
