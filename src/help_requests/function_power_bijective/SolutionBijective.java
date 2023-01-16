package help_requests.function_power_bijective;

@SuppressWarnings("DuplicatedCode")
public class SolutionBijective {
    public static int[] powerBijective(int[] arr, int k) {
        int n = arr.length;
        if (k == 1 || n <= 1) return arr;

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            if (arr[i] < 0) continue;
            markAndCopy(arr, ans, i, k);
        }
        for (int i = 0; i < n; i++) arr[i] = -arr[i] - 1;
        return ans;
    }

    private static int lengthOfCycle(int[] arr, int start) {
        int lenOfCycle = 1;
        int i = arr[start];
        while (i != start) {
            lenOfCycle++;
            i = arr[i];
        }
        return lenOfCycle;
    }

    private static void markAndCopy(int[] arr, int[] ans, int start, int k) {
        int lengthOfCycle = lengthOfCycle(arr, start);
        int shiftLeft = k % lengthOfCycle;

        int[] valuesInCycle = new int[lengthOfCycle];
        for (int i = 0; i < lengthOfCycle; i++) {
            valuesInCycle[i] = start;
            start = arr[start];
        }
        for (int i = 0; i < lengthOfCycle; i++) {
            ans[start] = valuesInCycle[(i + shiftLeft) % lengthOfCycle];
            start = arr[start];
        }

        for (int i = 0; i < lengthOfCycle; i++) {
            arr[start] = -arr[start] - 1;
            start = -arr[start] - 1;
        }
    }
}
