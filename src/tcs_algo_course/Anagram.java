package tcs_algo_course;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagram {
    private static final boolean CHECK_COLLISIONS = false;

    public static int[] maxLengthOfCommonAnagram(int[] a, int[] b) {
        int n = a.length, m = b.length;
        for (int len = Math.min(n, m); len > 0; len--) {
            Map<Long, List<Integer>> multisetHashToStart = new HashMap<>();
            MyCountMap map = new MyCountMap();
            for (int i = 0; i < len; i++) map.addValue(a[i]);
            multisetHashToStart.computeIfAbsent(map.getHashCode(), key -> new ArrayList<>()).add(0);
            for (int l = 0, r = len; r < n; ) {
                map.addValue(a[r++]);
                map.removeValue(a[l++]);
                multisetHashToStart.computeIfAbsent(map.getHashCode(), key -> new ArrayList<>()).add(l);
            }

            map = new MyCountMap();
            for (int i = 0; i < len; i++) map.addValue(b[i]);
            List<Integer> toCheck = multisetHashToStart.get(map.getHashCode());
            if (toCheck != null)
                for (Integer start : toCheck)
                    if (check(a, b, start, 0, len, CHECK_COLLISIONS)) return new int[]{start, 0, len};

            for (int l = 0, r = len; r < m; ) {
                map.addValue(b[r++]);
                map.removeValue(b[l++]);
                toCheck = multisetHashToStart.get(map.getHashCode());
                if (toCheck != null)
                    for (Integer start : toCheck)
                        if (check(a, b, start, l, len, CHECK_COLLISIONS)) return new int[]{start, l, len};
            }
        }
        return new int[]{0, 0, 0};
    }


    private static class MyCountMap {
        private final Map<Integer, Integer> count = new HashMap<>();
        private long hashCode = 0;

        public long getHashCode() {
            return hashCode;
        }

        public void addValue(int key) {
            long encodeKey = encodeKey(key);
            int prevVal = count.getOrDefault(key, 0);
            if (prevVal != 0) hashCode -= encodeKey ^ encodeVal(prevVal);
            hashCode += encodeKey ^ encodeVal(prevVal + 1);
            count.put(key, prevVal + 1);
        }

        public void removeValue(int key) {
            long encodeKey = encodeKey(key);
            int prevVal = count.get(key);
            hashCode -= encodeKey ^ encodeVal(prevVal);
            if (prevVal != 1) {
                hashCode += encodeKey ^ encodeVal(prevVal - 1);
                count.put(key, prevVal - 1);
            } else count.remove(key);
        }

        private static long encodeVal(long a) { // XorShiftStar
            a ^= a >>> 12;
            a ^= a << 25;
            a ^= a >>> 27;
            return a * 0x2545F4914F6CDD1DL;
        }

        private static long encodeKey(long a) { // XorShift64
            a ^= a << 13;
            a ^= a >>> 7;
            a ^= a << 17;
            return a * 0x2545F4914F6CDD1DL;
        }
    }

    public static boolean check(int[] arr1, int[] arr2, int start1, int start2, int n, boolean checkCollisions) {
        if (!checkCollisions) return true;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) map.compute(arr1[start1++], (k, v) -> v == null ? 1 : v + 1);
        for (int i = 0; i < n; i++) {
            Integer prevVal = map.getOrDefault(arr2[start2], 0);
            if (prevVal == null) return false;
            if (prevVal == 1) map.remove(arr2[start2++]);
            else map.put(arr2[start2++], prevVal - 1);
        }
        return map.isEmpty();
    }
}
