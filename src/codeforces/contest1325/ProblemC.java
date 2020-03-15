package codeforces.contest1325;

import java.util.Scanner;

public class ProblemC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] numberOfEdgesFrom = new int[n];
        int[][] edges = new int[n - 1][2];
        int u, v;
        for (int i = 0; i < n - 1; i++) {
            u = scanner.nextInt() - 1;
            v = scanner.nextInt() - 1;
            edges[i][0] = u;
            edges[i][1] = v;
            numberOfEdgesFrom[u]++;
            numberOfEdgesFrom[v]++;
        }
        int nLists = 0;
        for (int i = 0; i < n; i++) {
            if (numberOfEdgesFrom[i] == 1) nLists++;
        }
        if (nLists < 3) {
            for (int i = 0; i < n - 1; i++) {
                System.out.print(i + " ");
            }
        } else {
            nLists = 3;
            int counter = 3;
            for (int i = 0; i < n - 1; i++) {
                if (nLists > 0 && (numberOfEdgesFrom[edges[i][0]] == 1 || numberOfEdgesFrom[edges[i][1]] == 1)) {
                    nLists--;
                    System.out.print(nLists + " ");
                } else {
                    System.out.print(counter + " ");
                    counter++;
                }
            }
        }
    }
}
