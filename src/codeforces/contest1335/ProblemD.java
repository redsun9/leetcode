package codeforces.contest1335;

import java.util.Scanner;

public class ProblemD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int t = Integer.parseInt(scanner.nextLine()); t > 0; t--) {
            for (int i = 0; i < 9; i++) {
                System.out.println(scanner.nextLine().replace("2", "1"));
            }
        }
    }
}
