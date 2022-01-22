package leetcode.leetcode21xx.leetcode2127;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    public int maximumInvitations(int[] favorite) {
        State[] marks = markAllPeople(favorite);
        return Math.max(maxWithShortLoops(favorite, marks), maxLengthOfLongCycle(favorite, marks));
    }

    private static State[] markAllPeople(int[] favorite) {
        int n = favorite.length;
        State[] states = new State[n];
        for (int i = 0; i < n; i++) {
            if (states[i] != null) continue;
            if (favorite[favorite[i]] == i) {
                states[i] = State.INSIDE_LOOP_2;
                states[favorite[i]] = State.INSIDE_LOOP_2;
            }
        }
        for (int i = 0; i < n; i++) {
            if (states[i] != null) continue;

            int tmp = i;
            while (states[tmp] == null) {
                states[tmp] = State.TEMP;
                tmp = favorite[tmp];
            }

            if (states[tmp] == State.TEMP) {
                while (states[tmp] == State.TEMP) {
                    states[tmp] = State.INSIDE_LONG_LOOP;
                    tmp = favorite[tmp];
                }
            }

            State stateToSet = switch (states[tmp]) {
                case INSIDE_LOOP_2, OUTSIDE_LOOP_2 -> State.OUTSIDE_LOOP_2;
                case INSIDE_LONG_LOOP, OUTSIDE_LONG_LOOP -> State.OUTSIDE_LONG_LOOP;
                case TEMP -> null;
            };
            tmp = i;
            while (states[tmp] == State.TEMP) {
                states[tmp] = stateToSet;
                tmp = favorite[tmp];
            }
        }
        return states;
    }

    private static int maxWithShortLoops(int[] favorite, State[] states) {
        int n = favorite.length;
        int[] inDegree = new int[n];
        for (int fav : favorite) inDegree[fav]++;

        int[] dp = new int[n];
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) if (states[i] == State.OUTSIDE_LOOP_2 && inDegree[i] == 0) queue.add(i);
        while (!queue.isEmpty()) {
            int poll = queue.poll();
            int next = favorite[poll];
            dp[next] = Math.max(dp[next], dp[poll] + 1);
            if (--inDegree[next] == 0 && states[next] == State.OUTSIDE_LOOP_2) queue.add(next);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) if (states[i] == State.INSIDE_LOOP_2) ans += dp[i] + 1;
        return ans;
    }

    private static int maxLengthOfLongCycle(int[] favorite, State[] states) {
        int n = favorite.length, ans = 0;
        boolean[] processed = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (states[i] != State.INSIDE_LONG_LOOP || processed[i]) continue;
            int curLen = 0, curTmp = i;
            while (!processed[curTmp]) {
                processed[curTmp] = true;
                curLen++;
                curTmp = favorite[curTmp];
            }
            ans = Math.max(ans, curLen);
        }
        return ans;
    }

    private enum State {
        TEMP,
        INSIDE_LOOP_2,
        OUTSIDE_LOOP_2,
        INSIDE_LONG_LOOP,
        OUTSIDE_LONG_LOOP
    }
}
