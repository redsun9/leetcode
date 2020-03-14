package atcoder.panasonic2020;

import java.util.Scanner;

public class ProblemB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long h = scanner.nextInt();
        long w = scanner.nextInt();
        long total = h * w;
        if (h == 1 || w == 1) {
            System.out.println(1);
        } else {
            System.out.println(total / 2 + total % 2);
        }
    }
}
