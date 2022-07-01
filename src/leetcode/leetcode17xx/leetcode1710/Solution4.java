package leetcode.leetcode17xx.leetcode1710;

// Binary search by answer
public class Solution4 {
    private static final int MAX_UNIT_PER_BOX = 1000;

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int total = 0;
        for (int[] boxType : boxTypes) total += boxType[0];
        if (total <= truckSize) {
            int sum = 0;
            for (int[] boxType : boxTypes) sum += boxType[0] * boxType[1];
            return sum;
        }

        int lo = 1, hi = MAX_UNIT_PER_BOX;
        while (true) {
            int mid = lo + (hi - lo) / 2;
            int gt = 0, eq = 0, sum = 0;
            for (int[] boxType : boxTypes) {
                if (boxType[1] >= mid) {
                    if (boxType[1] == mid) eq += boxType[0];
                    else {
                        gt += boxType[0];
                        sum += boxType[0] * boxType[1];
                    }
                }
            }
            if (gt <= truckSize && gt + eq >= truckSize) return sum + (truckSize - gt) * mid;
            if (gt < truckSize) hi = mid - 1;
            else lo = mid + 1;
        }
    }
}
