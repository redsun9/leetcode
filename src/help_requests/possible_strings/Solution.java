package help_requests.possible_strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    private static final int ALPHABET = 26;

    public static long numberOfPossibleStrings(String s) {
        int[] count = new int[ALPHABET];
        int n = s.length();
        for (int i = 0; i < n; i++) count[s.charAt(i) - 'A']++;
        int numberOfDifferentLetters = 0;
        for (int a : count) if (a != 0) numberOfDifferentLetters++;

        int[] arr = new int[numberOfDifferentLetters];
        int pos = 0;
        for (int a : count) if (a != 0) arr[pos++] = a;

        Map<Key, Long> cache = new HashMap<>();
        return dfs(arr, n, cache) - 1;
    }

    private static long dfs(int[] arr, int left, Map<Key, Long> cache) {
        if (left == 0) return 1;
        Key key = new Key(arr);
        Long ans = cache.get(key);
        if (ans == null) {
            int n = arr.length;
            ans = 1L; // don't add more letters
            for (int i = 0; i < n; i++) {
                if (arr[i] != 0) {
                    arr[i]--;
                    ans += dfs(arr, left - 1, cache);
                    arr[i]++;
                }
            }
            cache.put(key, ans);
        }
        return ans;
    }

    private static class Key {
        private final int[] arr;
        private final int hashCode;

        public Key(int[] a) {
            this.arr = Arrays.copyOf(a, a.length);
            Arrays.sort(this.arr);
            this.hashCode = Arrays.hashCode(this.arr);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Key key = (Key) o;
            return Arrays.equals(arr, key.arr);
        }

        @Override
        public int hashCode() {
            return hashCode;
        }
    }
}
