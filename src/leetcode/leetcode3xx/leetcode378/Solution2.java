package leetcode.leetcode3xx.leetcode378;

import java.util.Arrays;

public class Solution2 {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;

        int[] index = new int[n];

        for (int i = 0; i < n; i++) {
            index[i] = i;
        }

        int[] L = new int[12 * n];

        return biselect(matrix, index, k, k, L)[0];
    }

    private int[] biselect(int[][] matrix, int[] index, int k1, int k2, int[] L) {
        int n = index.length;

        if (n <= 2) {
            int[] nums = new int[n * n];

            for (int i = 0, k = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    nums[k++] = matrix[index[i]][index[j]];
                }
            }

            Arrays.sort(nums);

            return new int[]{nums[k1 - 1], nums[k2 - 1]};
        }

        int[] index_ = new int[(n + 1) / 2 + (n - 1) % 2];
        int k1_ = 0;
        int k2_ = (k2 + 3) / 4;

        for (int i = 0, k = 0; i < n; i += 2) {
            index_[k++] = index[i];
        }

        if (n % 2 == 0) {
            index_[index_.length - 1] = index[n - 1];
            k1_ = (k1 + 3) / 4 + n + 1;
        } else {
            k1_ = (k1 + 2 * n) / 4 + 1;
        }

        int[] pair = biselect(matrix, index_, k1_, k2_, L);
        int a = pair[0], b = pair[1];
        int ra_less = 0, rb_more = 0;

        int Len = 0;

        for (int i = 0, ja = n, jb = n; i < n; i++) {
            while (ja > 0 && matrix[index[i]][index[ja - 1]] >= a) ja--;
            ra_less += ja;

            while (jb > 0 && matrix[index[i]][index[jb - 1]] > b) jb--;
            rb_more += n - jb;

            for (int j = jb; j < ja; j++) {
                L[Len++] = matrix[index[i]][index[j]];
            }
        }

        int x = 0, y = 0;

        if (ra_less <= k1 - 1) {
            x = a;
        } else if (k1 + rb_more - n * n <= 0) {
            x = b;
        } else {
            x = L[pick(L, 0, Len, k1 + rb_more - n * n)];
        }

        if (ra_less <= k2 - 1) {
            y = a;
        } else if (k2 + rb_more - n * n <= 0) {
            y = b;
        } else {
            y = L[pick(L, 0, Len, k2 + rb_more - n * n)];
        }

        return new int[]{x, y};
    }

    private int pick(int[] nums, int l, int r, int k) {
        int[] pos = partition(nums, l, r, medianOfMedians(nums, l, r));

        int p = pos[0], q = pos[1];

        if (q - l < k) {
            return pick(nums, q, r, k - (q - l));
        } else if (k <= p - l) {
            return pick(nums, l, p, k);
        } else {
            return p;
        }
    }

    private int[] partition(int[] nums, int l, int r, int pos) {
        int pivot = nums[pos];
        swap(nums, pos, r - 1);

        int p = l, q = r - 1;

        for (int i = l; i < q; ) {
            if (nums[i] < pivot) {
                swap(nums, p++, i++);
            } else if (nums[i] > pivot) {
                swap(nums, i, --q);
            } else {
                i++;
            }
        }

        swap(nums, q++, r - 1);

        return new int[]{p, q};
    }

    private int medianOfMedians(int[] nums, int l, int r) {
        if (r - l <= 5) return medianOfFive(nums, l, r);

        int rr = l;

        for (int i = l; i < r; i += 5) {
            swap(nums, rr++, medianOfFive(nums, i, Math.min(i + 5, r)));
        }

        return pick(nums, l, rr, (rr - l + 1) / 2);
    }

    private int medianOfFive(int[] nums, int l, int r) {
        Arrays.sort(nums, l, r);
        return l + (r - l - 1) / 2;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
