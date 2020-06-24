package vtb;

import java.util.List;

// minimum moves to make zigzag array
public class Solution13 {
    public static int moves(List<Integer> nums) {
        int v1 = helper(true, nums);
        int v2 = helper(false, nums);
        return Math.min(v1, v2);


    }

    private static int helper(boolean asc, List<Integer> nums) {
        int pre = nums.get(0);
        int count = 0;
        for (int i = 1; i < nums.size(); i++) {
            int diff = Math.abs(pre - nums.get(i));
            if (asc) {
                count += nums.get(i) <= pre ? diff + 1 : 0;
                pre = nums.get(i);
            } else {
                count += nums.get(i) >= pre ? diff + 1 : 0;
                pre = nums.get(i) >= pre ? pre - 1 : nums.get(i);
            }
            asc = !asc;
        }
        return count;
    }

}
