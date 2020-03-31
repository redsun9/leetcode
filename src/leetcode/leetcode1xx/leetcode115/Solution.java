package leetcode.leetcode1xx.leetcode115;

import java.util.HashMap;
import java.util.LinkedList;

public class Solution {
    public int numDistinct(String s, String t) {
        int[] count = new int[t.length() + 1];
        count[0] = 1;
        HashMap<Character, LinkedList<Integer>> pos = new HashMap<>();
        char[] chars = t.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            int finalI = i;
            pos.compute(c, (key, val) -> {
                if (val == null) val = new LinkedList<>();
                val.addFirst(finalI);
                return val;
            });
        }
        for (char c : s.toCharArray()) {
            LinkedList<Integer> list = pos.get(c);
            if (list != null) {
                for (Integer integer : list) {
                    count[integer + 1] += count[integer];
                }
            }
        }
        return count[count.length - 1];
    }
}
