package leetcode.leetcode16xx.leetcode1625;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    //greatest common divisor
    private static int gcd(int a, int b) {
        int c;
        while (b != 0) {
            a %= b;
            c = a;
            a = b;
            b = c;
        }
        return a;
    }

    public String findLexSmallestString(String s, int a, int b) {
        int n = s.length();
        b = gcd(n, b);
        a = gcd(a, 10);
        boolean canChangeEvenOdd = b % 2 == 1;
        int[] digits = new int[2 * n];
        for (int i1 = 0, i2 = n; i1 < n; i1++, i2++) {
            int c = s.charAt(i1) - '0';
            digits[i1] = c;
            digits[i2] = c;
        }
        int totalVariants = n / b;
        int[][] diff = new int[totalVariants][2];
        for (int i = 0, pos = 1; i < totalVariants; i++, pos += b) diff[i][1] = 10 - (digits[pos] - digits[pos] % a);
        if (canChangeEvenOdd) {
            for (int i = 0, pos = 0; i < totalVariants; i++, pos += b)
                diff[i][0] = 10 - (digits[pos] - digits[pos] % a);
        }
        Deque<Integer> prevQueue = new ArrayDeque<>(diff.length);
        Deque<Integer> nextQueue = new ArrayDeque<>(diff.length);
        for (int i = 0; i < totalVariants; i++) prevQueue.push(i);
        int i = 0;
        while (i < n && prevQueue.size() > 1) {
            int min = 9;
            while (!prevQueue.isEmpty()) {
                Integer poll = prevQueue.poll();
                int tmp = (digits[poll * b + i] + diff[poll][i % 2]) % 10;
                if (tmp < min) nextQueue.clear();
                min = Math.min(min, tmp);
                if (tmp == min) nextQueue.push(poll);
            }
            Deque<Integer> tmp = nextQueue;
            nextQueue = prevQueue;
            prevQueue = tmp;
            i++;
        }
        Integer ansStart = prevQueue.poll();
        char[] ans = new char[n];
        int[] ansDiff = diff[ansStart];
        for (int j = 0, pos = ansStart * b; j < n; j++, pos++) {
            ans[j] = (char) ('0' + (digits[pos] + ansDiff[j % 2]) % 10);
        }
        return new String(ans);
    }
}