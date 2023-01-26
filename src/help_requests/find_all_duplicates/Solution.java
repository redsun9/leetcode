package help_requests.find_all_duplicates;

// Find all numbers which occur not less than k times
// all number between 1 and n, where n=len(arr)


// o(1) - extra memory (we don't count ans)
// o(n) - time complexity
public class Solution {
    // no met -> 0
    // first met -> -1
    // second met -> -2
    public static int[] findAllDuplicates(int[] arr, int k) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] <= 0) continue;
            int tmp = arr[i];
            arr[i] = 0;
            while (true) {
                int next = arr[tmp - 1];
                if (next <= 0) {
                    arr[tmp - 1]--;
                    break;
                } else {
                    arr[tmp - 1] = -1;
                    tmp = next;
                }
            }
        }

        int ansLength = 0;
        for (int j : arr) if (j <= -k) ansLength++;
        int[] ans = new int[ansLength];
        for (int i = 0, pos = 0; i < n; i++) {
            if (arr[i] <= -k) ans[pos++] = i + 1;
        }
        return ans;
    }
}
