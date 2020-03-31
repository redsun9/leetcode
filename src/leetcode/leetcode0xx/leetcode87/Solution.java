package leetcode.leetcode0xx.leetcode87;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) return true;
        if (s1.length() != s2.length()) return false;
        int n = s1.length();
        HashMap<Character, Integer> linkToChar = new HashMap<>();
        int counter = 0;
        for (char c : s1.toCharArray()) {
            if (!linkToChar.containsKey(c)) {
                linkToChar.put(c, counter);
                counter++;
            }
        }
        int[][] firstChars = new int[n + 1][];
        int[][] secondChars = new int[n + 1][];
        firstChars[0] = new int[counter];
        secondChars[0] = new int[counter];
        for (int i = 1; i <= n; i++) {
            firstChars[i] = Arrays.copyOf(firstChars[i - 1], counter);
            secondChars[i] = Arrays.copyOf(secondChars[i - 1], counter);
            firstChars[i][linkToChar.get(s1.charAt(i - 1))]++;
            Integer integer = linkToChar.get(s2.charAt(i - 1));
            if (integer == null) return false;
            else secondChars[i][integer]++;
        }
        Map<Request, Boolean> memoized = new HashMap<>();
        return isScramble(s1, s2, new Request(0, n, 0, n), firstChars, secondChars, memoized);
    }

    private static boolean isScramble(String s1, String s2, Request request, int[][] fStats, int[][] sStats, Map<Request, Boolean> memoized) {
        if (memoized.containsKey(request)) return memoized.get(request);
        boolean result = false;
        if (request.end1 - request.start1 == 1) {
            result = s1.charAt(request.start1) == s2.charAt(request.start2);
        } else if (checkStatsForRequest(request, fStats, sStats)) {
            for (int i = 1; i < request.end1 - request.start1; i++) {
                if (isScramble(s1, s2, new Request(request.start1, request.start1 + i, request.start2, request.start2 + i), fStats, sStats, memoized)
                        && isScramble(s1, s2, new Request(request.start1 + i, request.end1, request.start2 + i, request.end2), fStats, sStats, memoized) ||
                        isScramble(s1, s2, new Request(request.start1, request.start1 + i, request.end2 - i, request.end2), fStats, sStats, memoized)
                                && isScramble(s1, s2, new Request(request.start1 + i, request.end1, request.start2, request.end2 - i), fStats, sStats, memoized)
                ) {
                    result = true;
                    break;
                }
            }

        }
        memoized.put(request, result);
        return result;
    }

    private static boolean checkStatsForRequest(Request request, int[][] fStats, int[][] sStats) {
        for (int i = 0; i < fStats[0].length; i++) {
            if (fStats[request.end1][i] - fStats[request.start1][i] != sStats[request.end2][i] - sStats[request.start2][i]) {
                return false;
            }
        }
        return true;
    }


    public static class Request {
        final int start1;
        final int end1;
        final int start2;
        final int end2;

        public Request(int start1, int end1, int start2, int end2) {
            this.start1 = start1;
            this.end1 = end1;
            this.start2 = start2;
            this.end2 = end2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Request request = (Request) o;
            return start1 == request.start1 &&
                    end1 == request.end1 &&
                    start2 == request.start2 &&
                    end2 == request.end2;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start1, end1, start2, end2);
        }
    }
}
