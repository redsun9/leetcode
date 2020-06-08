package leetcode.leetcode14xx.leetcode1431;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (int candy : candies) max = Math.max(max, candy);
        max -= extraCandies;
        List<Boolean> ans = new ArrayList<>(candies.length);
        for (int candy : candies) ans.add(candy >= max);
        return ans;
    }
}
