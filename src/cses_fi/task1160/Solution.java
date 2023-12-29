package cses_fi.task1160;

import java.util.*;

/*
   You are playing a game consisting of n planets. Each planet has a teleporter to another planet (or the planet itself).
    You have to process q queries of the form: You are now on planet a and want to reach planet b. What is the minimum number of teleportations?
 */
@SuppressWarnings({"unchecked", "DuplicatedCode"})
public class Solution {
    public static int[] planetQueries(int[] teleports, int[][] queries) {
        changeIndices(teleports, queries, -1);
        int n = teleports.length;
        boolean[] nodeInCycle = new boolean[n];
        int[] cycleIndexForNode = new int[n];
        int[] distanceToCycleForNode = new int[n];
        int[] firstCycleNodeForNode = new int[n];
        int[] indexInCycleForNode = new int[n];
        List<Integer> cycleLength = new ArrayList<>();

        //detect nodes in cycles
        int[] numberOfDependencies = new int[n];
        for (int v : teleports) numberOfDependencies[v]++;
        Queue<Integer> queue = new ArrayDeque<>();
        for (int v = 0; v < n; v++) if (numberOfDependencies[v] == 0) queue.offer(v);
        while (!queue.isEmpty()) {
            int v = teleports[queue.poll()];
            if (--numberOfDependencies[v] == 0) queue.offer(v);
        }

        //mark cycle nodes
        int numberOfCycles = 0;
        for (int i = 0; i < n; i++) {
            if (nodeInCycle[i] || numberOfDependencies[i] == 0) continue;
            int curNode = i, indexInCycle = 0;
            do {
                nodeInCycle[curNode] = true;
                cycleIndexForNode[curNode] = numberOfCycles;
                indexInCycleForNode[curNode] = indexInCycle++;
                firstCycleNodeForNode[curNode] = curNode;
                curNode = teleports[curNode];
            } while (curNode != i);
            cycleLength.add(indexInCycle);
            numberOfCycles++;
        }

        // process nodes not in cycle
        List<Integer>[] dependents = new List[n];
        for (int u = 0; u < n; u++) {
            if (nodeInCycle[u]) continue;
            int v = teleports[u];
            if (dependents[v] == null) dependents[v] = new ArrayList<>();
            dependents[v].add(u);
        }

        for (int v = 0; v < n; v++) if (nodeInCycle[v] && dependents[v] != null) queue.addAll(dependents[v]);
        while (!queue.isEmpty()) {
            int u = queue.poll();
            int v = teleports[u];
            cycleIndexForNode[u] = cycleIndexForNode[v];
            distanceToCycleForNode[u] = distanceToCycleForNode[v] + 1;
            firstCycleNodeForNode[u] = firstCycleNodeForNode[v];
            if (dependents[u] != null) queue.addAll(dependents[u]);
        }

        //create binary jumps
        int maxNeeded = 0;
        for (int v = 0; v < n; v++) maxNeeded = Math.max(maxNeeded, distanceToCycleForNode[v]);
        int maxPower2 = 32 - Integer.numberOfLeadingZeros(maxNeeded);
        int[][] dest = new int[maxPower2][n];
        dest[0] = teleports;
        for (int k = 1; k < maxPower2; k++) for (int i = 0; i < n; i++) dest[k][i] = dest[k - 1][dest[k - 1][i]];

        int m = queries.length;
        int[] ans = new int[m];
        Arrays.fill(ans, -1);
        for (int i = 0; i < m; i++) {
            int a = queries[i][0], b = queries[i][1];
            if (cycleIndexForNode[a] != cycleIndexForNode[b]) continue;
            if (distanceToCycleForNode[a] < distanceToCycleForNode[b]) continue;

            if (distanceToCycleForNode[b] == 0) {
                int diffOfIndices = indexInCycleForNode[b] - indexInCycleForNode[firstCycleNodeForNode[a]];
                if (diffOfIndices < 0) diffOfIndices += cycleLength.get(cycleIndexForNode[b]);
                ans[i] = distanceToCycleForNode[a] + diffOfIndices;
            } else {
                int distance = distanceToCycleForNode[a] - distanceToCycleForNode[b];
                int c = binaryJump(a, distance, dest);
                if (c == b) ans[i] = distance;
            }
        }

        changeIndices(teleports, queries, 1);
        return ans;
    }

    private static int binaryJump(int x, int k, int[][] dest) {
        int bit = 0;
        while (k != 0) {
            if ((k & 1) != 0) x = dest[bit][x];
            k >>= 1;
            bit++;
        }
        return x;
    }

    private static void changeIndices(int[] teleports, int[][] queries, int change) {
        int n = teleports.length, m = queries.length;
        for (int i = 0; i < n; i++) teleports[i] += change;
        for (int[] query : queries) {
            query[0] += change;
            query[1] += change;
        }
    }
}
