package atcoder.abc159;

import java.util.Scanner;

public class ProblemB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] chars = scanner.nextLine().toCharArray();
        int n = chars.length;
        for (int i = 0; i < n / 2; i++) {
            if (chars[i] != chars[n - i - 1]) {
                System.out.println("No");
                return;
            }
        }
        int n2 = (n - 1) / 2;
        int n1 = (n - 1) / 4;
        for (int i = 0; i < n1; i++) {
            if (chars[i] != chars[n2 - 1 - i]) {
                System.out.println("No");
                return;
            }
        }
        int n3 = (n + 3) / 2 - 1;
        for (int i = n3; i < n; i++) {
            if (chars[i] != chars[n - i + n3 - 1]) {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }
}
