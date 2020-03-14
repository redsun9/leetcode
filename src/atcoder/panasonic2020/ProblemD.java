package atcoder.panasonic2020;

import java.util.Scanner;

public class ProblemD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        char[] str = new char[n];
        process(str, 0, 'a');
    }

    private static void process(char[] str, int pos, char maxChar) {
        if (str.length == pos) {
            System.out.println(new String(str));
        } else {
            for (char c = 'a'; c <= maxChar; c++) {
                str[pos] = c;
                process(str, pos + 1, c == maxChar ? (char) (maxChar + 1) : maxChar);
            }
        }
    }
}

