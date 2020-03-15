package codeforces.contest1324;

import java.util.Scanner;

public class ProblemC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < t; i++) {
            char[] s = scanner.nextLine().toCharArray();
            int maxLen = 0;
            int tmp = 0;
            for (int j = 0; j < s.length; j++) {
                if (s[j] == 'R') tmp = 0;
                else {
                    tmp++;
                    maxLen = Integer.max(maxLen, tmp);
                }
            }
            System.out.println(maxLen + 1);
        }
    }
}
