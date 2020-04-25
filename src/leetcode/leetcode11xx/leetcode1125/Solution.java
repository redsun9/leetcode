package leetcode.leetcode11xx.leetcode1125;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public int[] smallestSufficientTeam(String[] skills, List<List<String>> people) {
        HashMap<String, Integer> skillToNumber = new HashMap<>();
        for (int i = 0; i < skills.length; i++) {
            skillToNumber.put(skills[i], i);
        }
        int n = 1 << skills.length;
        int[] dp = new int[n];
        long[] team = new long[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0, peopleSize = people.size(); i < peopleSize; i++) {
            List<String> person = people.get(i);
            if (person.isEmpty()) continue;
            long pMask = 1L << i;
            int bitmask = 0;
            for (String s : person) {
                bitmask = bitmask | (1 << skillToNumber.get(s));
            }
            for (int j = 0; j < n - 1; j++) {
                if (dp[j] == Integer.MAX_VALUE) continue;
                int k = j | bitmask;
                if (k == j) continue;
                if (dp[k] > dp[j] + 1) {
                    dp[k] = dp[j] + 1;
                    team[k] = team[j] | pMask;
                }
            }
        }
        int[] ans = new int[dp[n - 1]];
        long tmp = team[n - 1];
        int tmp1 = 0;
        int tmp2 = 0;
        while (tmp != 0) {
            if ((tmp & 1) == 1) {
                ans[tmp1] = tmp2;
                tmp1++;
            }
            tmp2++;
            tmp >>= 1;
        }
        return ans;
    }
}
