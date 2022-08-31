package help_requests.colour_fill;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// O(m*n*invAckerman(n)) - time
// O(n) - space

@SuppressWarnings("SuspiciousNameCombination")
public class Solution4 {
    public static int numberOfFills(int[][] mat) {
        int ans = 0, n = mat[0].length, counter = 0;
        int[] prevColour = new int[n], curColour = new int[n], prevRow = prevColour, tmp;
        Map<Integer, Integer> parent = new HashMap<>();
        Map<Integer, Integer> rank = new HashMap<>();

        for (int[] curRow : mat) {
            Arrays.fill(curColour, 0);
            //try to pick colour from previous row
            for (int i = 0; i < n; i++) if (prevRow[i] == curRow[i]) curColour[i] = prevColour[i];

            //union from left to right
            for (int l = 0, r = 1; r < n; r++, l++) {
                if (curRow[r] == curRow[l] && curColour[l] != 0 && curColour[l] != curColour[r]) {
                    if (curColour[r] != 0) {
                        if (union(curColour[l], curColour[r], parent, rank)) ans--;
                    } else curColour[r] = curColour[l];
                }
            }

            //union from right to left
            for (int l = n - 2, r = n - 1; l >= 0; r--, l--) {
                if (curRow[r] == curRow[l] && curColour[r] != 0 && curColour[l] != curColour[r]) {
                    if (curColour[l] != 0) {
                        if (union(curColour[l], curColour[r], parent, rank)) ans--;
                    } else curColour[l] = curColour[r];
                }
            }

            //set final colours
            for (int i = 0; i < n; i++) if (curColour[i] != 0) curColour[i] = find(curColour[i], parent);

            //process new groups
            for (int i = 0; i < n; i++) {
                if (curColour[i] == 0) {
                    if (i != 0 && curRow[i - 1] == curRow[i]) curColour[i] = curColour[i - 1];
                    else {
                        curColour[i] = ++counter;
                        ans++;
                        parent.put(counter, counter);
                        rank.put(counter, 0);
                    }
                }
            }

            Map<Integer, Integer> newParent = new HashMap<>();
            Map<Integer, Integer> newRank = new HashMap<>();

            //left only used colours to reduce memory
            for (int i = 0; i < n; i++) {
                newParent.put(curColour[i], parent.get(curColour[i]));
                newRank.put(curColour[i], rank.get(curColour[i]));
            }


            prevRow = curRow;
            parent = newParent;
            rank = newRank;

            tmp = prevColour;
            prevColour = curColour;
            curColour = tmp;
        }
        return ans;
    }

    private static int find(int x, Map<Integer, Integer> p) {
        if (x == p.get(x)) return x;
        int val = find(p.get(x), p);
        p.put(x, val);
        return val;
    }

    private static boolean union(int x, int y, Map<Integer, Integer> p, Map<Integer, Integer> rank) {
        x = find(x, p);
        y = find(y, p);
        if (x == y) return false;
        int rankX = rank.get(x), rankY = rank.get(y);
        if (rankX < rankY) p.put(x, y);
        else {
            p.put(y, x);
            if (rankX == rankY) rank.put(x, rankX + 1);
        }
        return true;
    }
}
