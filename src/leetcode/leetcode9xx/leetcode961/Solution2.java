package leetcode.leetcode9xx.leetcode961;

import java.util.Random;

//probabilistic
public class Solution2 {
    public int repeatedNTimes(int[] a) {
        int n = a.length;
        Random random = new Random();
        while (true) {
            int i = random.nextInt(n);
            int j = random.nextInt(n);
            if (a[i] == a[j] && i != j) return a[i];
        }
    }
}
