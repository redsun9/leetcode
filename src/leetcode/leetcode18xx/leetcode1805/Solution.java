package leetcode.leetcode18xx.leetcode1805;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int numDifferentIntegers(String word) {
        Set<String> set = new HashSet<>();
        int n = word.length();
        int right = 0;
        while (right < n) {
            if (word.charAt(right) >= '0' && word.charAt(right) <= '9') {
                int left = right;
                boolean isZero = true;
                while (right < n && word.charAt(right) >= '0' && word.charAt(right) <= '9') {
                    if (word.charAt(right) != '0') {
                        if (isZero) left = right;
                        isZero = false;
                    }
                    right++;
                }
                if (!isZero) set.add(word.substring(left, right));
                else set.add("0");
            }
            right++;
        }
        return set.size();
    }
}
