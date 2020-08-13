package leetcode.leetcode5xx.leetcode599;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> first = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            first.put(list1[i], i);
        }
        String[] ans = new String[Math.min(list1.length, list2.length)];
        int ansSize = 0;
        int ansSum = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            Integer val = first.get(list2[i]);
            if (val != null) {
                if (val + i == ansSum) {
                    ans[ansSize++] = list2[i];
                } else if (val + i < ansSum) {
                    ans[0] = list2[i];
                    ansSize = 1;
                    ansSum = val + i;
                }
            }
        }
        return Arrays.copyOfRange(ans, 0, ansSize);
    }
}
