package atcoder.abc156;

import java.util.Scanner;

public class ProblemA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int r = scanner.nextInt();
        System.out.println(getInnerRating(n, r));
    }

    public static int getInnerRating(int n, int displayedRating) {
        if (n >= 10) return displayedRating;
        else return n + 100 * (10 - n);
    }
}
