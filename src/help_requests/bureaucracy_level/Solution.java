package help_requests.bureaucracy_level;

import java.util.*;

// return max chain length
@SuppressWarnings({"DuplicatedCode", "unchecked"})
public class Solution {
    public static int bureaucracyLevel(int[] p) {
        int n = p.length;
        int[] h = new int[n];
        h[0] = 1;
        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i < n; i++) {
            if (h[i] != 0) continue;
            stack.push(i);
            while (!stack.isEmpty()) {
                if (h[p[stack.peek()]] == 0) stack.push(p[stack.peek()]);
                else h[stack.peek()] = h[p[stack.pop()]] + 1;
            }
        }
        int ans = 1;
        for (int a : h) ans = Math.max(ans, a);
        return ans;
    }

    public static int dummySolution(int[] p) {
        int n = p.length;
        int ans = 1;
        for (int i = 1; i < n; i++) {
            int curr = i, len = 1;
            while (curr != 0) {
                curr = p[curr];
                len++;
            }
            ans = Math.max(ans, len);
        }
        return ans;
    }

    public static int cycleSolution(int[] p) {
        int n = p.length;
        int[] h = new int[n];
        h[0] = 1;
        int ans = 1;
        for (int i = 1; i < n; i++) {
            if (h[i] != 0) continue;
            int curr = i, len = 0;
            while (h[curr] == 0) {
                curr = p[curr];
                len++;
            }
            int curr2 = i;
            int currH = h[curr] + len;
            ans = Math.max(ans, currH);
            while (curr2 != curr) {
                h[curr2] = currH;
                currH--;
                curr2 = p[curr2];
            }
        }
        return ans;
    }

    public static int recursiveSolution(int[] p) {
        int n = p.length;
        int[] h = new int[n];
        h[0] = 1;
        int ans = 1;
        for (int i = 1; i < n; i++) ans = Math.max(ans, f(i, p, h));
        return ans;
    }

    public static int kahnSolution(int[] p) {
        int n = p.length;
        int[] h = new int[n];
        h[0] = 1;
        List<Integer>[] adj = new List[n];
        for (int i = 1; i < n; i++) {
            if (adj[p[i]] == null) adj[p[i]] = new ArrayList<>();
            adj[p[i]].add(i);
        }
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(0);
        while (!q.isEmpty()) {
            int u = q.poll();
            if (adj[u] == null) continue;
            for (Integer v : adj[u]) {
                h[v] = h[u] + 1;
                q.offer(v);
            }
        }
        int ans = 1;
        for (int a : h) ans = Math.max(ans, a);
        return ans;
    }

    private static int f(int i, int[] p, int[] h) {
        if (h[i] != 0) return h[i];
        h[i] = f(p[i], p, h) + 1;
        return h[i];
    }

    public static int[] maxHeightAndIndex(int[] p) {
        int n = p.length;
        int[] h = new int[n];
        h[0] = 1;
        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i < n; i++) {
            if (h[i] != 0) continue;
            stack.push(i);
            while (!stack.isEmpty()) {
                if (h[p[stack.peek()]] == 0) stack.push(p[stack.peek()]);
                else h[stack.peek()] = h[p[stack.pop()]] + 1;
            }
        }
        int[] ans = {1, 0};
        for (int i = 1; i < n; i++) {
            if (h[i] > ans[0]) ans = new int[]{h[i], i};
        }
        return ans;
    }
}
