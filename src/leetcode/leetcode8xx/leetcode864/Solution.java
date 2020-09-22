package leetcode.leetcode8xx.leetcode864;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    public static final int[] moves = {1, 0, -1, 0, 1};
    public static final int mask = (1 << 5) - 1;
    public static final int keyMask = ((1 << 6) - 1) << 10;

    public int shortestPathAllKeys(String[] grid) {
        int m = grid.length;
        int n = grid[0].length();
        int allKeys = 0; //0-4 for i, 5-9 for j, 10-15 for keys
        int startI = 0, startJ = 0;
        for (int i = 0; i < grid.length; i++) {
            String s = grid[i];
            for (int j = 0; j < n; j++) {
                char c = s.charAt(j);
                if (c >= 'a' && c <= 'f') allKeys |= 1 << (c - 'a' + 10);
                else if (c == '@') {
                    startI = i;
                    startJ = j;
                }
            }
        }
        if (allKeys == 0) return 0;
        boolean[] visited = new boolean[1 << 16];
        Queue<Integer> queue = new ArrayDeque<>();
        int startKey = startI | startJ << 5;
        visited[startKey] = true;
        queue.add(startKey);
        int ans = 0;
        int currentGeneration = 1;
        while (true) {
            while (currentGeneration-- > 0) {
                Integer key = queue.poll();
                if ((key & keyMask) == allKeys) return ans;
                int i = key & mask;
                int j = (key >> 5) & mask;
                for (int k = 0; k < 4; k++) {
                    int nextI = i + moves[k];
                    int nextJ = j + moves[k + 1];
                    if (nextI >= 0 && nextI < m && nextJ >= 0 && nextJ < n) {
                        int nextKey;
                        char c = grid[nextI].charAt(nextJ);
                        if (c == '#') continue;
                        if (c >= 'a' && c <= 'f') {
                            nextKey = key & keyMask | 1 << (c - 'a' + 10) | nextI | nextJ << 5;
                        } else if (c < 'A' || c > 'F' || ((key & (1 << (c - 'A' + 10))) != 0)) {
                            nextKey = key & keyMask | nextI | nextJ << 5;
                        } else continue;
                        if (visited[nextKey]) continue;
                        visited[nextKey] = true;
                        queue.add(nextKey);
                    }
                }
            }
            currentGeneration = queue.size();
            if (currentGeneration == 0) return -1;
            ans++;
        }
    }
}
