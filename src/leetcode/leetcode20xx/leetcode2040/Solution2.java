package leetcode.leetcode20xx.leetcode2040;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

@SuppressWarnings({"ConstantConditions", "DuplicatedCode"})
public class Solution2 {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        int n1 = nums1.length, n2 = nums2.length;
        int nNeg1 = numberOfNegative(nums1), nPos1 = numberOfPositive(nums1), nZero1 = n1 - nNeg1 - nPos1;
        int nNeg2 = numberOfNegative(nums2), nPos2 = numberOfPositive(nums2), nZero2 = n2 - nNeg2 - nPos2;

        long totalNeg = (long) nNeg1 * nPos2 + (long) nNeg2 * nPos1;
        if (totalNeg >= k) {
            int[] pos1 = Arrays.copyOfRange(nums1, n1 - nPos1, n1);
            int[] pos2 = Arrays.copyOfRange(nums2, n2 - nPos2, n2);
            int[] neg1 = Arrays.copyOfRange(nums1, 0, nNeg1);
            int[] neg2 = Arrays.copyOfRange(nums2, 0, nNeg2);
            mirror(pos1);
            mirror(pos2);
            return kthSmallestPositiveProduct(pos1, neg2, pos2, neg1, k);
        }

        k -= totalNeg;
        long totalZero = (long) nZero1 * n2 + (long) nZero2 * n1 - (long) nZero1 * nZero2;

        if (totalZero >= k) return 0L;
        else {
            k -= totalZero;
            int[] pos1 = Arrays.copyOfRange(nums1, n1 - nPos1, n1);
            int[] pos2 = Arrays.copyOfRange(nums2, n2 - nPos2, n2);
            int[] neg1 = Arrays.copyOfRange(nums1, 0, nNeg1);
            int[] neg2 = Arrays.copyOfRange(nums2, 0, nNeg2);
            mirror(neg1);
            mirror(neg2);
            return kthSmallestPositiveProduct(pos1, pos2, neg1, neg2, k);
        }
    }

    private static void mirror(int[] arr) {
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }


    private static long kthSmallestPositiveProduct(int[] pos1, int[] pos2, int[] neg1, int[] neg2, long k) {
        int nPos1 = pos1.length, nPos2 = pos2.length, nNeg1 = neg1.length, nNeg2 = neg2.length;
        Queue<Node> pq = new PriorityQueue<>(Comparator.comparingLong(x -> x.val));
        if (nPos1 != 0 && nPos2 != 0) pq.offer(new Node(0, 0, 1, (long) pos1[0] * pos2[0]));
        if (nNeg1 != 0 && nNeg2 != 0) pq.offer(new Node(0, 0, 2, (long) neg1[0] * neg2[0]));
        while (--k > 0) {
            Node node = pq.poll();
            if (node.type == 1) {
                if (node.j == 0 && node.i + 1 < nPos1)
                    pq.offer(new Node(node.i + 1, 0, 1, (long) pos1[node.i + 1] * pos2[0]));
                if (node.j + 1 < nPos2)
                    pq.offer(new Node(node.i, node.j + 1, 1, (long) pos1[node.i] * pos2[node.j + 1]));
            } else {
                if (node.j == 0 && node.i + 1 < nNeg1)
                    pq.offer(new Node(node.i + 1, 0, 2, (long) neg1[node.i + 1] * neg2[0]));
                if (node.j + 1 < nNeg2)
                    pq.offer(new Node(node.i, node.j + 1, 2, (long) neg1[node.i] * neg2[node.j + 1]));
            }
        }
        return pq.poll().val;
    }

    private static class Node {
        final int i, j, type;
        final long val;

        public Node(int i, int j, int type, long val) {
            this.i = i;
            this.j = j;
            this.type = type;
            this.val = val;
        }
    }

    private static int numberOfNegative(int[] arr) {
        int lo = -1, hi = arr.length - 1;
        while (lo < hi) {
            int mid = (lo + hi + 1) / 2;
            if (arr[mid] >= 0) hi = mid - 1;
            else lo = mid;
        }
        return lo + 1;
    }

    private static int numberOfPositive(int[] arr) {
        int lo = 0, hi = arr.length;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] <= 0) lo = mid + 1;
            else hi = mid;
        }
        return arr.length - lo;
    }
}
