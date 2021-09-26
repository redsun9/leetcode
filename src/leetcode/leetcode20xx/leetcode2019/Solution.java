package leetcode.leetcode20xx.leetcode2019;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("DuplicatedCode")
public class Solution {
    private static final int MAX_VAL = 1000;

    public int scoreOfStudents(String s, int[] answers) {
        int n = (s.length() + 1) / 2;
        Set<Integer>[][] set = new Set[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                set[i][j] = new HashSet<>();
            }
        }
        for (int i = 0; i < n; i++) set[i][i].add(s.charAt(2 * i) - '0');

        for (int d = 2; d <= n; d++) {
            for (int left = 0, right = d - 1; right < n; left++, right++) {
                Set<Integer> res = set[left][right];
                for (int mid = left; mid < right; mid++) {
                    Set<Integer> leftVals = set[left][mid];
                    Set<Integer> riteVals = set[mid + 1][right];
                    if (s.charAt(1 + 2 * mid) == '+') {
                        for (Integer leftVal : leftVals) {
                            for (Integer riteVal : riteVals) {
                                int resVal = leftVal + riteVal;
                                if (resVal <= MAX_VAL) res.add(resVal);
                            }
                        }
                    } else {
                        for (Integer leftVal : leftVals) {
                            for (Integer riteVal : riteVals) {
                                int resVal = leftVal * riteVal;
                                if (resVal <= MAX_VAL) res.add(resVal);
                            }
                        }
                    }
                }
            }
        }

        Node head = new Node();
        head.val = s.charAt(0) - '0';
        head.mult = false;

        Node tmp = head;
        int i = 1;

        while (i < n) {
            Node nxt = new Node();
            tmp.nxt = nxt;
            tmp.mult = s.charAt(2 * i - 1) == '*';
            nxt.val = s.charAt(2 * i) - '0';
            tmp = tmp.nxt;
            i++;
        }

        tmp = head;
        while (tmp.nxt != null) {
            if (tmp.mult) {
                tmp.val *= tmp.nxt.val;
                tmp.mult = tmp.nxt.mult;
                tmp.nxt = tmp.nxt.nxt;
            } else tmp = tmp.nxt;
        }
        tmp = head;
        while (tmp.nxt != null) {
            tmp.val += tmp.nxt.val;
            tmp.nxt = tmp.nxt.nxt;
        }

        int rightAnswer = head.val;


        int ans = 0;
        for (int answer : answers) {
            if (rightAnswer == answer) ans += 5;
            else if (set[0][n - 1].contains(answer)) ans += 2;
        }
        return ans;
    }


    private static class Node {
        int val;
        boolean mult;
        Node nxt;
    }
}
