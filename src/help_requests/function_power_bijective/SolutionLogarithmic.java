package help_requests.function_power_bijective;

import java.util.Arrays;

import static basic.utils.ArrayTools.naturalArray;

public class SolutionLogarithmic {
    public static int[] logarithmicPower(int[] arr, int k) {
        int n = arr.length;
        int[] ans = naturalArray(n);
        int[] tmp = Arrays.copyOf(arr, n);

        while (k != 0) {
            if ((k & 1) != 0) multiply(ans, tmp);
            tmp = sqr(tmp);
            k >>>= 1;
        }
        return ans;
    }

    private static int[] sqr(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) ans[i] = arr[arr[i]];
        return ans;
    }

    private static void multiply(int[] a, int[] b) {
        int n = a.length;
        for (int i = 0; i < n; i++) a[i] = b[a[i]];
    }
}
