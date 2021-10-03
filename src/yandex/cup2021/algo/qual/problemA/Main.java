package yandex.cup2021.algo.qual.problemA;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String t = scanner.nextLine();
        int ans = compare(s, t);
        if (ans == 0) System.out.println('=');
        else if (ans > 0) System.out.println('>');
        if (ans < 0) System.out.println('<');
    }

    private static int compare(String s, String t) {
        int i = s.length() - 1, j = t.length() - 1;
        int compare = 0;
        while (i > 0 && j > 0) {
            int c1 = s.charAt(i) == 'o' ? 0 : 1, c2 = t.charAt(j) == 'o' ? 0 : 1;
            if (c1 != c2) compare = c1 - c2;

            i -= c1 == 0 ? 4 : 3;
            j -= c2 == 0 ? 4 : 3;
        }

        if (compare > 0 && j <= 0) return 1;
        if (compare < 0 && i <= 0) return -1;
        if (i <= 0 && j <= 0) return compare;
        else if (i > 0) {
            while (s.charAt(i) == 'o') i -= 4;
            if (i > 0) return 1;
            else return compare;
        } else {
            while (t.charAt(j) == 'o') j -= 4;
            if (j > 0) return -1;
            else return compare;
        }
    }
}
