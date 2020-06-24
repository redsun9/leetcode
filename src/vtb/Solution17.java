package vtb;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.List;

/*
Divide Array in Sets of K Consecutive Numbers
 */
public class Solution17 {
    public static boolean canGroup(List<Integer> cards, int w) {
        int n = cards.size();
        if (n == 0) return true;
        if (n % w != 0) return false;
        cards.sort(Comparator.naturalOrder());
        ArrayDeque<Pair> deque = new ArrayDeque<>(w);
        int i = 0;
        int waitingTotal = 0;
        int prev = 0;

        while (i < n) {
            int curr = cards.get(i);
            int cnt = 0;
            while (i < n && cards.get(i) == curr) {
                i++;
                cnt++;
            }
            if (curr != prev + 1) {
                if (waitingTotal != 0) return false;
                deque.addLast(new Pair(curr, cnt));
            } else {
                if (cnt < waitingTotal) return false;
                if (!deque.isEmpty() && deque.peekFirst().val == curr - w + 1) {
                    Pair pair = deque.pollFirst();
                    waitingTotal -= pair.cnt;
                    cnt -= pair.cnt;
                }
                if (waitingTotal < cnt) {
                    deque.addLast(new Pair(curr, cnt - waitingTotal));
                }
            }
            waitingTotal = cnt;
            prev = curr;
        }
        return waitingTotal == 0;
    }

    private static class Pair {
        private int val, cnt;

        public Pair(int val, int cnt) {
            this.val = val;
            this.cnt = cnt;
        }
    }
}
