package leetcode.leetcode28xx.leetcode2828;

import java.util.List;

public class Solution {
    public boolean isAcronym(List<String> words, String s) {
        if (words.size() != s.length()) return false;
        for (int i = 0; i < s.length(); i++) {
            if (words.get(i).charAt(0) != s.charAt(i)) return false;
        }
        return true;
    }
}
