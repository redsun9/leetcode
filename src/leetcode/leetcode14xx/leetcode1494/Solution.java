package leetcode.leetcode14xx.leetcode1494;

public class Solution {
    private static int bt(int allowed, int k, int n, int[] prevCourses, int[] nextCourses, int[] cache) {
        if (allowed == 0) return 0;
        if (cache[allowed] != 0) return cache[allowed];

        if (Integer.bitCount(allowed) <= k) {
            int nextAllowed = moveForward(allowed, allowed, n, prevCourses, nextCourses);
            cache[allowed] = 1 + bt(nextAllowed, k, n, prevCourses, nextCourses, cache);
            moveBackward(allowed, n, prevCourses, nextCourses);
        } else {
            int ans = Integer.MAX_VALUE;
            for (int mask = allowed; mask != 0; mask = (mask - 1) & allowed) {
                if (Integer.bitCount(mask) != k) continue;
                int nextAllowed = moveForward(allowed, mask, n, prevCourses, nextCourses);
                ans = Math.min(ans, bt(nextAllowed, k, n, prevCourses, nextCourses, cache));
                moveBackward(mask, n, prevCourses, nextCourses);
            }
            cache[allowed] = 1 + ans;
        }
        return cache[allowed];
    }

    private static int moveForward(int allowed, int move, int n, int[] prevCourses, int[] nextCourses) {
        allowed ^= move;
        for (int i = 0; i < n; i++) {
            if ((move >> i & 1) == 1) {
                int nextCourse = nextCourses[i];
                if (nextCourse != 0) {
                    for (int j = 0; j < n; j++) {
                        if ((nextCourse >> j & 1) == 1) {
                            prevCourses[j] ^= 1 << i;
                            if (prevCourses[j] == 0) allowed ^= 1 << j;
                        }
                    }
                }
            }
        }
        return allowed;
    }

    private static void moveBackward(int move, int n, int[] prevCourses, int[] nextCourses) {
        for (int i = 0; i < n; i++) {
            if ((move >> i & 1) == 1) {
                int nextCourse = nextCourses[i];
                if (nextCourse != 0) {
                    for (int j = 0; j < n; j++) {
                        if ((nextCourse >> j & 1) == 1) {
                            prevCourses[j] ^= 1 << i;
                        }
                    }
                }
            }
        }
    }

    public int minNumberOfSemesters(int n, int[][] relations, int k) {
        int[] prevCourses = new int[n];
        int[] nextCourses = new int[n];
        for (int[] relation : relations) {
            int u = relation[0] - 1, v = relation[1] - 1;
            prevCourses[v] |= 1 << u;
            nextCourses[u] |= 1 << v;
        }
        int allowed = 0;
        for (int i = 0; i < n; i++) {
            if (prevCourses[i] == 0) allowed |= 1 << i;
        }
        int[] cache = new int[1 << n];
        return bt(allowed, k, n, prevCourses, nextCourses, cache);
    }
}
