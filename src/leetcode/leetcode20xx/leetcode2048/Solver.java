package leetcode.leetcode20xx.leetcode2048;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solver {
    public static void main(String[] args) {
        int[] count = new int[10];
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= 1_22_4444; i++) {
            Arrays.fill(count, 0);
            int tmp = i;
            while (tmp != 0) {
                count[tmp % 10]++;
                tmp /= 10;
            }
            boolean ok = true;
            for (int j = 0; j <= 9; j++) ok &= count[j] == 0 || count[j] == j;
            if (ok) ans.add(i);
        }
        System.out.println(ans);
    }
}
