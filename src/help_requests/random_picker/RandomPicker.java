package help_requests.random_picker;

import java.util.Random;

public class RandomPicker {
    public static int[] pick(int[] arr, int k, Random random) {
        int n = arr.length;
        int[] ans = new int[k];
        while (k != 0) if (random.nextInt(n--) < k) ans[--k] = arr[n];
        return ans;
    }
}
