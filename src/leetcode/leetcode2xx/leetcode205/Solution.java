package leetcode.leetcode2xx.leetcode205;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> sToT = new HashMap<>();
        HashSet<Character> alreadyUsedInT = new HashSet<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (sToT.containsKey(c1)) {
                if (sToT.get(c1) != c2) return false;
            } else {
                if (alreadyUsedInT.contains(c2)) return false;
                sToT.put(c1, c2);
                alreadyUsedInT.add(c2);
            }
        }
        return true;
    }
}
