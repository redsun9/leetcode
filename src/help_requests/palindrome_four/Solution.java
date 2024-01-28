package help_requests.palindrome_four;

// you can delete any number of elements
// can the remaining elements form a palindrome of length 3/4/5?

import java.util.HashMap;
import java.util.Map;

public class Solution {
    // aba
    public static boolean solve3(int[] arr) {
        Map<Integer, Integer> first = new HashMap<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int a = arr[i];
            if (first.containsKey(a)) {
                int pos = first.get(a);
                if (pos + 2 <= i) return true;
            } else first.put(a, i);
        }
        return false;
    }

    // abba
    public static boolean solve4(int[] arr) {
        Map<Integer, Integer> first = new HashMap<>();
        Map<Integer, Integer> last = new HashMap<>();
        int n = arr.length;
        int rightMostPair = -1;
        for (int i = 0; i < n; i++) {
            int a = arr[i];
            if (first.containsKey(a)) {
                int pos = first.get(a);
                if (pos < rightMostPair) return true;
                rightMostPair = Math.max(rightMostPair, last.get(a));
            } else first.put(a, i);
            last.put(a, i);
        }
        return false;
    }

    //abcba
    public static boolean solve5(int[] arr) {
        Map<Integer, Positions> positions = new HashMap<>();
        int n = arr.length;
        int rightMostPair = -1;
        for (int i = 0; i < n; i++) {
            int a = arr[i];
            if (positions.containsKey(a)) {
                Positions pos = positions.get(a);
                if (pos.first < rightMostPair) return true;
                if (pos.last1 + 2 <= i) rightMostPair = Math.max(rightMostPair, pos.last1);
                else if (pos.last2 != null) rightMostPair = Math.max(rightMostPair, pos.last2);

                pos.last2 = pos.last1;
                pos.last1 = i;
            } else positions.put(a, new Positions(i, i, null));
        }
        return false;
    }

    private static class Positions {
        private final int first;
        private int last1;
        private Integer last2;

        public Positions(Integer first, Integer last1, Integer last2) {
            this.first = first;
            this.last1 = last1;
            this.last2 = last2;
        }
    }
}
