package leetcode.leetcode20xx.leetcode2049;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

@SuppressWarnings("unchecked")
public class Solution {
    public int countHighestScoreNodes(int[] parents) {
        int n = parents.length;
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int i = 1; i < n; i++) adj[parents[i]].add(i);

        long max = 0;
        int ans = 0;
        int[] numOfChildren = new int[n];
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(0);
        while (!deque.isEmpty()) {
            int u = deque.peekLast();
            if (numOfChildren[u] == 0) {
                numOfChildren[u] = 1;
                for (int v : adj[u]) deque.addLast(v);
            } else {
                deque.pollLast();
                long mul = 1;
                int sum = 1;
                for (int v : adj[u]) {
                    mul *= numOfChildren[v];
                    sum += numOfChildren[v];
                }
                if (n != sum) mul *= (n - sum);
                if (mul == max) ans++;
                else if (mul > max) {
                    max = mul;
                    ans = 1;
                }
                numOfChildren[u] = sum;
            }
        }
        return ans;
    }
}
