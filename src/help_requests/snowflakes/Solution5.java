package help_requests.snowflakes;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// O(n*k) - space, O(n*k) - time worst
public class Solution5 {
    public static boolean allUnique(int[][] snowflakes) {
        Trie trie = new Trie();
        for (int[] snowflake : snowflakes) if (!trie.add(canonize(snowflake))) return false;
        return true;
    }

    private static class Trie {
        Map<Integer, Trie> children = new HashMap<>();

        boolean add(int[] arr) {
            int n = arr.length;
            Trie node = this;
            for (int i = 1; i < n; i++) node = children.computeIfAbsent(arr[i], key -> new Trie());
            Trie prev = node.children.putIfAbsent(arr[0], new Trie());
            return prev == null;
        }
    }

    private static int[] canonize(int[] arr) {
        int n = arr.length;
        int k1 = leastRotation(arr);
        mirror(arr);
        int k2 = n - 1 - leastRotation(arr);
        mirror(arr);

        int k, direction;
        if (less(arr, k1, k2)) {
            k = k1;
            direction = 1;
        } else {
            k = k2;
            direction = -1;
        }

        int[] ans = new int[n];
        for (int i = 0, j = k; i < n; i++) {
            ans[i] = arr[j];
            j += direction;
            if (j == n) j = 0;
            else if (j < 0) j = n - 1;
        }
        return ans;
    }

    private static boolean less(int[] arr, int k1, int k2) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[k1] != arr[k2]) return arr[k1] < arr[k2];
            k1++;
            if (k1 == n) k1 = 0;
            k2--;
            if (k2 < 0) k2 = n - 1;
        }
        return true;
    }

    private static int leastRotation(int[] arr) {
        int n = arr.length;
        int[] f = new int[2 * n];
        Arrays.fill(f, -1);
        int k = 0;
        for (int j = 1; j < 2 * n; j++) {
            int i = f[j - k - 1];
            while (i != -1 && arr[j % n] != arr[(k + i + 1) % n]) {
                if (arr[j % n] < arr[(k + i + 1) % n]) k = j - i - 1;
                i = f[i];
            }
            if (i == -1 && arr[j % n] != arr[(k + i + 1) % n]) {
                if (arr[j % n] < arr[(k + i + 1) % n]) k = j;
                f[j - k] = -1;
            } else {
                f[j - k] = i + 1;
            }
        }
        return k;
    }

    private static void mirror(int[] arr) {
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }
}
