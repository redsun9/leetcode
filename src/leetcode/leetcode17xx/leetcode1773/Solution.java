package leetcode.leetcode17xx.leetcode1773;

import java.util.List;

public class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int ruleIndex = switch (ruleKey) {
            case "type" -> 0;
            case "color" -> 1;
            case "name" -> 2;
            default -> throw new IllegalStateException("Unexpected value: " + ruleKey);
        };
        int ans = 0;
        for (List<String> item : items) {
            if (item.get(ruleIndex).equals(ruleValue)) ans++;
        }
        return ans;
    }
}
