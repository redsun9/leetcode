package codeforces.contest1672.problemE;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Grader grader = new Grader() {
            @Override
            public int test(int w) {
                System.out.println("? " + w);
                return scanner.nextInt();
            }

            @Override
            public int getN() {
                return n;
            }

            @Override
            public void checkAns(int s) {
                System.out.println("! " + s);
            }
        };
        Solver solver = new Solver(grader);
        solver.solve();
    }

}
