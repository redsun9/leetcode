package atcoder.panasonic2020;

import java.util.Scanner;

public class ProblemC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextInt();
        long b = scanner.nextInt();
        long c = scanner.nextInt();
        if (c - a - b < 0) {
            System.out.println("No");
        } else if ((c - a - b) * (c - a - b) > 4 * a * b) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
