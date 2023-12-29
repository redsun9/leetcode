package help_requests.max_mountain_range;


import java.util.ArrayDeque;
import java.util.Deque;

// Дается набор maxHeights размера n.
// Вам необходимо расположить n холмиков на координатной прямой.
// i-ый холмик построен на координате i и имеет высоту heights[i].
// Набор холмиков является горным массивом, если следующие условия корректные:
//
// 1) 1 <= heights[i] <= maxHeights[i]
// 2) height - массив скал, если существует индекс i, такой, что:
//    - Для всех 0 < j <= i, heights[j-1] <= heights[j]
//    - Для всех i <= k < n-1, heights[k+1] <= heights[k]
//
// Верните максимально возможную сумму высот горного массива.
public class Solution {
    public static long maxHeightSum(int[] maxHeights) {
        long[] leftSum = maxLeftSumIfPeak(maxHeights);
        mmirror(maxHeights);
        long[] rightSum = maxLeftSumIfPeak(maxHeights);
        mmirror(rightSum);
        mmirror(maxHeights);

        long ans = 0;
        int n = maxHeights.length;
        for (int i = 0; i < n; i++) ans = Math.max(ans, maxHeights[i] + leftSum[i] + rightSum[i]);
        return ans;
    }

    private static long[] maxLeftSumIfPeak(int[] maxHeights) {
        int n = maxHeights.length;
        long[] ans = new long[n];
        Deque<int[]> stack = new ArrayDeque<>();
        long sumOfElementsInDeque = 0L;
        for (int i = 0; i < n; i++) {
            int startOfRange = i;
            while (!stack.isEmpty() && maxHeights[stack.peekLast()[1]] >= maxHeights[i]) {
                int[] range = stack.pollLast();
                sumOfElementsInDeque -= (range[1] - range[0] + 1L) * (maxHeights[range[1]] - maxHeights[i]);
                startOfRange = range[0];
            }
            ans[i] = sumOfElementsInDeque;
            stack.offerLast(new int[]{startOfRange, i});
            sumOfElementsInDeque += maxHeights[i];
        }
        return ans;
    }

    private static void mmirror(int[] arr) {
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }

    private static void mmirror(long[] arr) {
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            long tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }
}
