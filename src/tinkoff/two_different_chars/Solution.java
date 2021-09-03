package tinkoff.two_different_chars;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTests = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfTests; i++) {
            System.out.println(
                    solve(scanner.nextLine().toCharArray()) ? "Yes" : "No"
            );
        }
    }

    static boolean solve(char[] s) {
        return s[0] == s[1] && s[2] == s[3] && s[0] != s[2] ||
                s[0] == s[2] && s[1] == s[3] && s[0] != s[1] ||
                s[0] == s[3] && s[1] == s[2] && s[0] != s[1];
    }
}
