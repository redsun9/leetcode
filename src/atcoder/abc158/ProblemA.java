package atcoder.abc158;

import java.util.Scanner;

public class ProblemA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        if (s.equals("AAA") || s.equals("BBB")) System.out.println("No");
        else System.out.println("Yes");
    }
}
