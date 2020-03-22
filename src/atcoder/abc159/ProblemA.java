package atcoder.abc159;

import java.util.Scanner;

public class ProblemA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        System.out.println(n * (n - 1) / 2 + m * (m - 1) / 2);
    }
}
