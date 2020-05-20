package leetcode.leetcode6xx.leetcode628;

import java.util.Comparator;
import java.util.PriorityQueue;

@SuppressWarnings("ConstantConditions")
public class Solution {
    public int maximumProduct(int[] nums) {
        //3 max positive , 2 least negative + 1 max positive
        boolean zeroPresent = false;
        PriorityQueue<Integer> maxPos = new PriorityQueue<>(4);
        PriorityQueue<Integer> minNeg = new PriorityQueue<>(3, Comparator.reverseOrder());
        PriorityQueue<Integer> maxNeg = new PriorityQueue<>(4);
        //special case - 3 max negative
        for (int num : nums) {
            if (num == 0) zeroPresent = true;
            else if (num > 0) {
                maxPos.offer(num);
                if (maxPos.size() > 3) maxPos.poll();
            } else {
                minNeg.offer(num);
                if (minNeg.size() > 2) minNeg.poll();
                maxNeg.offer(num);
                if (maxNeg.size() > 3) maxNeg.poll();
            }
        }
        int ans = zeroPresent ? 0 : Integer.MIN_VALUE;

        int[] maxPosArray = new int[maxPos.size()];
        for (int i = 0; i < maxPosArray.length; i++) {
            maxPosArray[i] = maxPos.poll();
        }
        int[] minNegArray = new int[minNeg.size()];
        for (int i = 0; i < minNegArray.length; i++) {
            minNegArray[i] = minNeg.poll();
        }

        int[] maxNegArray = new int[maxNeg.size()];
        for (int i = 0; i < maxNegArray.length; i++) {
            maxNegArray[i] = maxNeg.poll();
        }

        if (maxPosArray.length == 3) {
            ans = maxPosArray[0] * maxPosArray[1] * maxPosArray[2];
        }
        if (minNegArray.length == 2 && maxPosArray.length > 0) {
            ans = Math.max(ans, minNegArray[0] * minNegArray[1] * maxPosArray[maxPosArray.length - 1]);
        }
        if (ans < 0) {
            if (maxNegArray.length == 3) {
                ans = maxNegArray[0] * maxNegArray[1] * maxNegArray[2];
            }
            if (maxPosArray.length == 2 && maxNegArray.length == 1) {
                ans = maxPosArray[0] * maxPosArray[1] * maxNegArray[0];
            }
        }
        return ans;
    }
}
