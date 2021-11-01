package leetcode.leetcode20xx.leetcode2053;

import java.util.HashMap;

public class Solution {
    public String kthDistinct(String[] arr, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : arr) map.compute(s, (key, v) -> v == null ? 1 : v + 1);
        for (String s : arr) if (map.get(s) == 1) if (--k == 0) return s;
        return "";
    }
}
