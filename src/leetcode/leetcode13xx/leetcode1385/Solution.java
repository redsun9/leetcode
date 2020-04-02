package leetcode.leetcode13xx.leetcode1385;

import java.util.Arrays;
import java.util.HashSet;

public class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        if (arr2.length == 0 || arr1.length == 0) return arr1.length;
        if (d == 0) {
            HashSet<Integer> set = new HashSet<>();
            for (int i : arr2) {
                set.add(i);
            }
            int ans = 0;
            for (int i : arr1) {
                if (!set.contains(i)) ans++;
            }
            return ans;
        } else if (arr2.length == 1) {
            int a1 = arr2[0] - d;
            int a2 = arr2[0] + d;
            int ans = 0;
            for (int i : arr1) {
                if (i < a1 || i > a2) ans++;
            }
            return ans;
        } else if (arr1.length == 1) {
            int a1 = arr1[0] - d;
            int a2 = arr1[0] + d;
            for (int i : arr2) {
                if (a1 <= i && i <= a2) return 0;
            }
            return 1;
        } else if (d < 2) {
            HashSet<Integer> set = new HashSet<>();
            for (int j = -d; j <= d; j++) {
                for (int i : arr2) {
                    set.add(i + j);
                }
            }
            int ans = 0;
            for (int i : arr1) {
                if (!set.contains(i)) ans++;
            }
            return ans;
        } else {
            Arrays.sort(arr1);
            Arrays.sort(arr2);
            int ans = 0;
            int i1 = 0;
            int i2 = 0;
            int n1 = arr1.length;
            int n2 = arr2.length;
            while (i1 < n1) {
                int value1bot = arr1[i1] - d;
                int value1top = arr1[i1] + d;
                int value2 = arr2[i2];
                while (true) {
                    if (value1bot <= value2) break;
                    i2++;
                    if (i2 == n2) return ans + n1 - i1;
                    value2 = arr2[i2];
                }
                if (value1top < value2) ans++;
                i1++;
            }
            return ans;
        }
    }
}
