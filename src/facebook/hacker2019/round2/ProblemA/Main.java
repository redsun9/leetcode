package facebook.hacker2019.round2.ProblemA;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

@SuppressWarnings("UnnecessarySemicolon")
public class Main {
    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/facebook/hacker2019/round2/ProblemA/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/facebook/hacker2019/round2/ProblemA/output.txt");
                PrintStream printer = new PrintStream(fos);
        ) {
            int t = Integer.parseInt(scanner.nextLine());
            String[] parts;
            for (int i = 1; i <= t; i++) {
                parts = scanner.nextLine().split(" ");
                int n = Integer.parseInt(parts[0]);
                int m = Integer.parseInt(parts[1]);
                int k = Integer.parseInt(parts[2]);
                parts = scanner.nextLine().split(" ");
                int[] mister = new int[2];
                mister[0] = Integer.parseInt(parts[0]);
                mister[1] = Integer.parseInt(parts[1]);
                int[][] agents = new int[k][2];
                for (int j = 0; j < k; j++) {
                    parts = scanner.nextLine().split(" ");
                    agents[j][0] = Integer.parseInt(parts[0]);
                    agents[j][1] = Integer.parseInt(parts[1]);
                }
                boolean ans = solve(mister, agents);
                printer.println("Case #" + i + ": " + (ans ? "Y" : "N"));
            }
        }
    }

    private static boolean solve(int[] mister, int[][] agents) {
        if (agents.length <= 1) return false;
        int mPos = (mister[0] + mister[1]) & 1;
        return ((agents[0][0] + agents[0][1]) & 1) == mPos &&
                ((agents[1][0] + agents[1][1]) & 1) == mPos;
    }
}
