package vtb;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
        maximum sum of elements divisible by 3
 */

public class Solution1 {
    public static int maxSum(List<Integer> nums) {
        int length = nums.size();
        if (length == 0) return 0;
        ArrayList<Integer> l1 = new ArrayList<>();
        ArrayList<Integer> l2 = new ArrayList<>();
        int ans = 0;
        for (Integer num : nums) {
            if (num % 3 == 0) ans += Math.max(num, 0);
            else if (num % 3 == 1 || num % 3 == -2) l1.add(num);
            else l2.add(num);
        }
        l1.sort(Comparator.naturalOrder());
        l2.sort(Comparator.naturalOrder());
        int m = l1.size();
        int n = l2.size();
        int[] left1 = new int[m + 1]; //max sum of elements from [0;i) divisible by 3
        int[] left2 = new int[n + 1]; //max sum of elements from [0;i) divisible by 3
        int[] right1 = new int[m + 1]; //sum of elements from [i;)
        int[] right2 = new int[n + 1]; //sum of elements from [i;)
        for (int i = 3; i <= m; i++)
            left1[i] = Math.max(0, left1[i - 3] + l1.get(i - 3) + l1.get(i - 2) + l1.get(i - 1));
        for (int i = 3; i <= n; i++)
            left2[i] = Math.max(0, left2[i - 3] + l2.get(i - 3) + l2.get(i - 2) + l2.get(i - 1));
        for (int i = m - 1; i >= 0; i--) right1[i] = right1[i + 1] + l1.get(i);
        for (int i = n - 1; i >= 0; i--) right2[i] = right2[i + 1] + l2.get(i);

        int max = 0;
        for (int i = Math.min(m, n), i1 = m - i, i2 = n - i; i >= 0; i--, i1++, i2++) {
            max = Math.max(max, left1[i1] + left2[i2] + right1[i1] + right2[i2]);
        }
        return ans + max;
    }
}
