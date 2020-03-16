package codeforces.contest1324;

import java.util.ArrayList;
import java.util.Scanner;

public class ProblemF {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int n = Integer.parseInt(scanner.nextLine());
        int[] colours = new int[n];
        boolean onlyWhite = true;
        boolean onlyBlack = true;
        char[] colorLine = scanner.nextLine().toCharArray();
        for (int i = 0; i < n; i++) {
            int c = colorLine[2 * i] - '0';
            if (c == 0) onlyWhite = false;
            if (c == 1) onlyBlack = false;
            colours[i] = c * 2 - 1;
        }
        if (onlyWhite || onlyBlack) {
            int value = onlyWhite ? n : -1;
            for (int i = 0; i < n; i++) {
                System.out.print(value + " ");
            }
            return;
        }
        ArrayList<Integer>[] neighbours = new ArrayList[n];
        int[] weight = new int[n];
        for (int i = 0; i < n; i++) {
            neighbours[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            int u = scanner.nextInt() - 1;
            int v = scanner.nextInt() - 1;
            neighbours[u].add(v);
            neighbours[v].add(u);
        }


        boolean[] marked = new boolean[n];
        int[] stack = new int[n + 1];
        int[] queue = new int[n + 1];
        int stackPointer = 0;
        int queuePointer = 0;

        int tmpSum, wN;
        while (stackPointer >= 0) {
            int pop = stack[stackPointer];
            if (marked[pop]) {
                tmpSum = colours[pop];
                for (Integer neighbour : neighbours[pop]) {
                    if (!marked[neighbour]) {
                        wN = weight[neighbour];
                        if (wN > 0) {
                            tmpSum += wN;
                        }
                    }
                }
                marked[pop] = false;
                weight[pop] = tmpSum;
                stackPointer--;
            } else {
                marked[pop] = true;
                for (Integer neighbour : neighbours[pop]) {
                    if (!marked[neighbour]) {
                        stackPointer++;
                        stack[stackPointer] = neighbour;
                        queuePointer++;
                        queue[queuePointer] = neighbour;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            int next = queue[i];
            marked[next] = true;
            int weightCurrent = weight[next];
            if (weightCurrent > 0) {
                //у сверху стоящего наша сумма уже включена
                for (Integer neighbour : neighbours[next]) {
                    if (marked[neighbour]) {
                        weight[next] = Integer.max(weightCurrent, weight[neighbour]);
                        break;
                    }
                }
            } else {
                for (Integer neighbour : neighbours[next]) {
                    if (marked[neighbour]) {
                        int weightNeighbour = weight[neighbour];
                        if (weightNeighbour > 0) {
                            weight[next] += weightNeighbour;
                            break;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(weight[i] + " ");
        }
    }
}
