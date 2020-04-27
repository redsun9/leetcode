package atcoder.abc164;

import java.util.Scanner;

public class ProblemA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(scanner.nextInt() <= scanner.nextInt() ? "unsafe" : "safe");
    }
}
