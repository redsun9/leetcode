package codejam.moon_and_umbrellas;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < t; i++) {
            String[] parts = scanner.nextLine().split(" ");
            int x = Integer.parseInt(parts[0]);
            int y = Integer.parseInt(parts[1]);
            String s = parts[2];
            int ans = 0;
            char prevChar = '?';
            char curChar = s.charAt(0);
            char nextChar;
            int pos = 0;
            int n = s.length();
            while (true) {
                while (pos + 1 < n && s.charAt(pos + 1) == curChar) pos++;
                nextChar = pos + 1 < n ? s.charAt(pos + 1) : '?';
                if (curChar == 'J' && prevChar == 'C') ans += x;
                else if (curChar == 'C' && prevChar == 'J') ans += y;
                else if (curChar == '?') {
                    if (nextChar == 'J' && prevChar == 'C') ans += x;
                    else if (nextChar == 'C' && prevChar == 'J') ans += y;
                }
                prevChar = curChar;
                curChar = nextChar;
                if (++pos >= n) break;
            }
            System.out.printf("Case #%d: %d\n", (i + 1), ans);
        }
    }
}
