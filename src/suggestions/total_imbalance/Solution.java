package suggestions.total_imbalance;

// You are given an array called a rank, and it has size of n, and all its elements are from 1 to n and there's no duplicates.
// Now there are several rules:
//get an subarray of any possible size k (1 <= k <= n)
//sort this subarray
//find the imbalance of this subarray.
//Imbalance is defined as, for each element a[i] at index i, a[i] - a[i - 1] > 1. Then a[i] contributes 1 imbalance. e.g. for subarry [1,5,4], after sorting it's [1,4,5]. So 1 and 4 this pair will contribute 1 imbalance. but 4 and 5 won't contribute imbalance. But for subarray [1, 4, ,6], there will be 2 imbalance.
//Find the total imbalance of all possible subarray
//For example, given [4,1,3,2] rank array. There could be [4], [1], [3], [2], [4,1], [1,3], [3,2], [4,1,3],[1,3,2] and [4,1,3,2] subarrays. [4,1], [1,3], [4,1,3] each of these 3 subarrays has 1 imbalance. So return 3.

// O(N) - space and time complexity
public class Solution {
    public long totalImbalance(int[] rank) {
        int n = rank.length;
        int[] idx = new int[n];
        for (int i = 0; i < n; i++) idx[rank[i] - 1] = i;

        int[] left = new int[n];
        left[0] = -1;
        for (int i = 1; i < n; i++) {
            int tmp = i - 1;
            while (tmp >= 0 && rank[tmp] <= rank[i]) tmp = left[tmp];
            left[i] = tmp;
        }

        int[] right = new int[n];
        right[n - 1] = n;
        for (int i = n - 2; i >= 0; i--) {
            int tmp = i + 1;
            while (tmp < n && rank[tmp] <= rank[i]) tmp = right[tmp];
            right[i] = tmp;
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            int posNext = rank[i] == n ? n : idx[rank[i]];
            int posLeft = left[i], posRight = right[i], maxLeft = -1, maxRight = n;
            if (posNext > i) maxRight = posNext;
            if (posNext < i) maxLeft = posNext;
            ans += (long) (i - maxLeft) * (maxRight - i) - (long) (i - posLeft) * (posRight - i);
        }
        return ans;
    }
}
