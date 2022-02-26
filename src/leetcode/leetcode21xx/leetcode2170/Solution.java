package leetcode.leetcode21xx.leetcode2170;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int minimumOperations(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0;
        Map<Integer, Integer> evenMap = new HashMap<>(), oddMap = new HashMap<>();
        for (int i = 0; i < n; i += 2) evenMap.compute(nums[i], (k, v) -> v == null ? 1 : v + 1);
        for (int i = 1; i < n; i += 2) oddMap.compute(nums[i], (k, v) -> v == null ? 1 : v + 1);

        int evenMaxVal1 = 0, oddMaxVal1 = 0, evenMaxCnt1 = 0, evenMaxCnt2 = 0, oddMaxCnt1 = 0, oddMaxCnt2 = 0;

        for (Map.Entry<Integer, Integer> entry : evenMap.entrySet()) {
            Integer value = entry.getValue();
            if (value > evenMaxCnt2) {
                if (value > evenMaxCnt1) {
                    evenMaxCnt2 = evenMaxCnt1;
                    evenMaxCnt1 = value;
                    evenMaxVal1 = entry.getKey();
                } else {
                    evenMaxCnt2 = value;
                }
            }
        }

        for (Map.Entry<Integer, Integer> entry : oddMap.entrySet()) {
            Integer value = entry.getValue();
            if (value > oddMaxCnt2) {
                if (value > oddMaxCnt1) {
                    oddMaxCnt2 = oddMaxCnt1;
                    oddMaxCnt1 = value;
                    oddMaxVal1 = entry.getKey();
                } else {
                    oddMaxCnt2 = value;
                }
            }
        }

        if (evenMaxVal1 == oddMaxVal1) return n - Math.max(evenMaxCnt1 + oddMaxCnt2, evenMaxCnt2 + oddMaxCnt1);
        else return n - evenMaxCnt1 - oddMaxCnt1;
    }
}
