package atcoder.keyence2020;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class ProblemE {
    public static final int MAX_WEIGHT = 1_000_000_000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] d = new int[n];
        int[] toMin = new int[n];
        int[] curMin = new int[n];
        int[] edgeMin = new int[n];
        Arrays.fill(curMin, Integer.MAX_VALUE);

        for (int i = 0; i < n; i++) {
            d[i] = scanner.nextInt();
        }

        int u, v;
        for (int i = 0; i < m; i++) {
            u = scanner.nextInt() - 1;
            v = scanner.nextInt() - 1;
            if (curMin[u] > d[v]) {
                toMin[u] = v;
                curMin[u] = d[v];
                edgeMin[u] = i;
            }
            if (curMin[v] > d[u]) {
                toMin[v] = u;
                curMin[v] = d[u];
                edgeMin[v] = i;
            }
        }

        for (int i = 0; i < n; i++) {
            if (d[i] < curMin[i]) {
                System.out.println(-1);
                return;
            }
        }

        Boolean[] nodeColors = new Boolean[n];
        Integer[] edgeWeights = new Integer[m];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (nodeColors[i] != null) continue;
            stack.push(i);
            while (!stack.isEmpty()) {
                Integer peeked = stack.peek();
                if (nodeColors[toMin[peeked]] != null) {
                    nodeColors[peeked] = !nodeColors[toMin[peeked]];
                    edgeWeights[edgeMin[peeked]] = d[peeked];
                    stack.pop();
                } else {
                    if (d[toMin[peeked]] == d[peeked]) {
                        toMin[toMin[peeked]] = peeked;
                        nodeColors[toMin[peeked]] = true;
                        nodeColors[peeked] = false;
                        edgeWeights[edgeMin[peeked]] = d[peeked];
                        stack.pop();
                    } else {
                        stack.push(toMin[peeked]);
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            if (edgeWeights[i] == null) edgeWeights[i] = MAX_WEIGHT;
        }

        StringBuilder sb = new StringBuilder(n);
        for (boolean color : nodeColors) {
            sb.append(color ? "B" : "W");
        }
        System.out.println(sb.toString());
        for (int w : edgeWeights) {
            System.out.println(w);
        }
    }
}
