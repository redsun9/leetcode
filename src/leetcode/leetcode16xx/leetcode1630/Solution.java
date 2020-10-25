package leetcode.leetcode16xx.leetcode1630;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int n = l.length;
        List<Boolean> ans = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            int i1 = l[i];
            int i2 = r[i];
            if (i2 != i1 + 1) {
                int max = nums[i1];
                int min = nums[i1];
                for (int j = i1 + 1; j <= i2; j++) {
                    int num = nums[j];
                    max = Math.max(max, num);
                    min = Math.min(min, num);
                }
                if (max != min) {
                    if ((max - min) % (i2 - i1) == 0) {
                        int d = (max - min) / (i2 - i1);
                        Set<Integer> set = new HashSet<>();
                        boolean result = true;
                        for (int j = i1; j <= i2; j++) {
                            int num = nums[j];
                            if ((num - min) % d != 0 || !set.add(num)) {
                                result = false;
                                break;
                            }
                        }
                        ans.add(result);
                    } else ans.add(false);
                } else ans.add(true);
            } else ans.add(true);
        }
        return ans;
    }
}
