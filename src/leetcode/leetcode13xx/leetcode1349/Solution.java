package leetcode.leetcode13xx.leetcode1349;

import java.util.*;

//using bitmasking
@SuppressWarnings("ALL")
public class Solution {
    private static int[] possibleSeats(int n) {
        LinkedList<Integer> seats = new LinkedList<>();
        possibleSeats(n, 0, 0, seats);
        int[] ans = new int[seats.size()];
        int i = 0;
        for (Integer seat : seats) {
            ans[i++] = seat;
        }
        return ans;
    }

    private static void possibleSeats(int n, int pos, int cur, List<Integer> ans) {
        if (pos == n) {
            ans.add(cur);
        } else {
            possibleSeats(n, pos + 1, cur << 1, ans);
            if ((cur & 1) == 0) possibleSeats(n, pos + 1, (cur << 1) + 1, ans);
        }
    }

    private static Collection<Integer>[] possibleSequences(int[] possibleRows, int n) {
        Collection<Integer>[] ans = new Collection[possibleRows.length];
        Map<Integer, Integer> reverseMap = reverseMap(possibleRows);
        for (int i = 0; i < possibleRows.length; i++) {
            ans[i] = new LinkedList<>();
            Collection<Integer> collection = ans[i];
            int possibleRow = possibleRows[i];
            int mask = (1 << n) - 1;
            mask &= ~(possibleRow >> 1);
            mask &= ~(possibleRow << 1);
            for (int subMask = mask; ; subMask = (subMask - 1) & mask) {
                if (reverseMap.containsKey(subMask)) collection.add(reverseMap.get(subMask));
                if (subMask == 0) break;
            }
        }
        return ans;
    }

    private static Map<Integer, Integer> reverseMap(int[] arr) {
        HashMap<Integer, Integer> ans = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            ans.put(arr[i], i);
        }
        return ans;
    }

    public int maxStudents(char[][] seats) {
        int m = seats.length;
        int n = seats[0].length;
        int[] possibleRows = possibleSeats(n);
        Collection<Integer>[] possibleSequences = possibleSequences(possibleRows, n);

        int[] previousMax = new int[possibleRows.length];
        int[] currentMax = new int[possibleRows.length];


        for (int i = 0; i < seats.length; i++) {
            char[] row = seats[i];
            int currentRowBitMask = 0;
            for (char seat : row) {
                currentRowBitMask = (currentRowBitMask << 1) | (seat == '.' ? 1 : 0);
            }

            for (int j = 0; j < possibleRows.length; j++) {
                int possibleRow = possibleRows[j];
                if ((currentRowBitMask & possibleRow) == possibleRow) {
                    int max = 0;
                    for (Integer prev : possibleSequences[j]) {
                        max = Math.max(max, previousMax[prev]);
                    }
                    currentMax[j] = max + Integer.bitCount(possibleRow);
                } else currentMax[j] = 0;
            }
            int[] t = previousMax;
            previousMax = currentMax;
            currentMax = t;
        }
        int ans = 0;
        for (int pMax : previousMax) {
            ans = Math.max(ans, pMax);
        }
        return ans;
    }
}
