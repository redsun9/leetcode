package atcoder.abc164;

import java.util.Scanner;

public class ProblemB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();
        if ((c + (b - 1)) / b > (a + (d - 1)) / d) System.out.println("No");
        else System.out.println("Yes");
    }
}
