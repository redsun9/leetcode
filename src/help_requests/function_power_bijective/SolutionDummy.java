package help_requests.function_power_bijective;

import static basic.utils.ArrayTools.naturalArray;

public class SolutionDummy {
    public static int[] powerDummy(int[] arr, int k) {
        int n = arr.length;
        int[] prev = naturalArray(n), next = new int[n], tmp;
        while (k-- != 0) {
            for (int i = 0; i < n; i++) next[i] = arr[prev[i]];
            tmp = prev;
            prev = next;
            next = tmp;
        }
        return prev;
    }
}
