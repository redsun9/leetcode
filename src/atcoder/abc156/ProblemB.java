package atcoder.abc156;

import java.util.Scanner;

public class ProblemB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        System.out.println(numberOfDigitsInBase(n, k));
    }

    public static final int numberOfDigitsInBase(int n, int k) {
        int c = 1;
        while (n >= k) {
            c++;
            n /= k;
        }
        return c;
    }
}
