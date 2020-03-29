package atcoder.abc160;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class ProblemF {
    private static final int p = 1_000_000_007;
    private static final BigInteger bigP = BigInteger.valueOf(p);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        LinkedList<Integer>[] neighbours = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            neighbours[i] = new LinkedList<>();
        }
        boolean[] visited = new boolean[n];

        long[] factors = new long[n];
        long[] revFactors = new long[n];
        factors[0] = 1;
        factors[1] = 1;
        revFactors[0] = 1;
        revFactors[1] = 1;
        long tmp = 1;
        for (int i = 2; i < n; i++) {
            tmp = tmp * i % p;
            factors[i] = tmp;
            revFactors[i] = BigInteger.valueOf(tmp).modInverse(bigP).intValue();
        }


        for (int i = 0; i < n - 1; i++) {
            int a = scanner.nextInt() - 1;
            int b = scanner.nextInt() - 1;
            neighbours[a].add(b);
            neighbours[b].add(a);
        }

        int[] nodesInSubtree = new int[n];
        long[] numberWays = new long[n];


        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        while (!stack.isEmpty()) {
            Integer pop = stack.peek();
            if (!visited[pop]) {
                visited[pop] = true;
                for (Integer neighbour : neighbours[pop]) {
                    if (!visited[neighbour]) stack.push(neighbour);
                }
            } else {
                nodesInSubtree[pop] = 0;
                numberWays[pop] = 1;
                for (Integer neighbour : neighbours[pop]) {
                    if (!visited[neighbour]) {
                        numberWays[pop] =
                                numberWays[pop]
                                        * factors[nodesInSubtree[pop] + nodesInSubtree[neighbour]] % p
                                        * revFactors[nodesInSubtree[pop]] % p
                                        * revFactors[nodesInSubtree[neighbour]] % p
                                        * numberWays[neighbour] % p;
                        nodesInSubtree[pop] += nodesInSubtree[neighbour];
                    }
                }
                visited[pop] = false;
                nodesInSubtree[pop]++;
                stack.pop();
            }
        }

//        System.out.println(Arrays.toString(nodesInSubtree));
//        System.out.println(Arrays.toString(numberWays));

        stack.add(0);
        while (!stack.isEmpty()) {
            Integer pop = stack.pop();
            visited[pop] = true;
            for (Integer neighbour : neighbours[pop]) {
                if (visited[neighbour]) {
                    numberWays[pop] = numberWays[neighbour]
                            * factors[n - nodesInSubtree[pop] - 1] % p
                            * factors[nodesInSubtree[pop]] % p
                            * revFactors[nodesInSubtree[pop] - 1] % p
                            * revFactors[n - nodesInSubtree[pop]] % p;
                } else {
                    stack.push(neighbour);
                }
            }
        }

        for (long numberWay : numberWays) {
            System.out.println(numberWay);
        }
    }
}
