package cses_fi.task1751;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

@SuppressWarnings("DuplicatedCode")
public class Solution {
    public static int[] planetCycles(int[] teleports) {
        changeIndices(teleports, -1);
        int n = teleports.length;
        int[] ans = new int[n];

        //detect nodes in cycles
        int[] numberOfDependencies = new int[n];
        for (int v : teleports) numberOfDependencies[v]++;

        Queue<Integer> queue = new ArrayDeque<>();
        for (int v = 0; v < n; v++) if (numberOfDependencies[v] == 0) queue.offer(v);
        while (!queue.isEmpty()) {
            int v = teleports[queue.poll()];
            if (--numberOfDependencies[v] == 0) queue.offer(v);
        }

        //process cycle nodes
        for (int i = 0; i < n; i++) {
            if (ans[i] != 0 || numberOfDependencies[i] == 0) continue;
            int curNode = i, cycleLength = 0;
            do {
                curNode = teleports[curNode];
                cycleLength++;
            } while (curNode != i);

            do {
                ans[curNode] = cycleLength;
                curNode = teleports[curNode];
            } while (curNode != i);
        }

        // process nodes not in cycle
        List<Integer>[] dependents = new List[n];
        for (int u = 0; u < n; u++) {
            if (ans[u] != 0) continue;
            int v = teleports[u];
            if (dependents[v] == null) dependents[v] = new ArrayList<>();
            dependents[v].add(u);
        }

        for (int v = 0; v < n; v++) if (ans[v] != 0 && dependents[v] != null) queue.addAll(dependents[v]);
        while (!queue.isEmpty()) {
            int u = queue.poll();
            int v = teleports[u];
            ans[u] = ans[v] + 1;
            if (dependents[u] != null) queue.addAll(dependents[u]);
        }

        changeIndices(teleports, 1);
        return ans;
    }

    private static void changeIndices(int[] teleports, int change) {
        int n = teleports.length;
        for (int i = 0; i < n; i++) teleports[i] += change;
    }
}
