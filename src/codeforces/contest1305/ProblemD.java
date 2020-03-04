package codeforces.contest1305;

import java.util.LinkedList;
import java.util.Scanner;

public class ProblemD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        LinkedList<Integer>[] neighbours = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            neighbours[i] = new LinkedList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            int u = scanner.nextInt() - 1;
            int v = scanner.nextInt() - 1;
            neighbours[u].add(v);
            neighbours[v].add(u);
        }
        int currentTop = 0;
        while (!neighbours[currentTop].isEmpty()) {
            Integer u1 = currentTop;
            while (!neighbours[u1].isEmpty()) {
                Integer v = neighbours[u1].removeFirst();
                neighbours[v].remove(u1);
                u1 = v;
            }
            Integer u2 = currentTop;
            while (!neighbours[u2].isEmpty()) {
                Integer v = neighbours[u2].removeFirst();
                neighbours[v].remove(u2);
                u2 = v;
            }
            System.out.println("? " + (u1 + 1) + " " + (u2 + 1));
            System.out.flush();
            currentTop = scanner.nextInt() - 1;
        }
        System.out.println("! " + (currentTop + 1));
    }
}
