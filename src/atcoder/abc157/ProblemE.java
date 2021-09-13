package atcoder.abc157;

import java.util.Scanner;

public class ProblemE {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String str = scanner.nextLine().trim().substring(0, n);
        Fenwick fenwick = new Fenwick(str);
        int q = scanner.nextInt();
        for (int i = 0; i < q; i++) {
            int queryType = scanner.nextInt();
            if (queryType == 1) {
                int pos = scanner.nextInt();
                char c = scanner.nextLine().trim().charAt(0);
                fenwick.change(pos, c);
            } else {
                int lq = scanner.nextInt();
                int rq = scanner.nextInt();
                System.out.println(fenwick.numberOfDifferentChars(lq, rq));
            }
        }
    }

    public static class Fenwick {
        public static final int abc = 26;
        private char[] str;
        private final int[][] t;
        private final int n;

        public Fenwick(String string) {
            this.str = string.toCharArray();
            n = string.length();
            t = new int[n][abc];
            for (int i = 0; i < n; i++) {
                inc(i, str[i] - 'a', 1);
            }
        }

        public void change(int i, char c) {
            i = i - 1;
            if (str[i] != c) {
                int oldChar = str[i] - 'a';
                int newChar = c - 'a';
                str[i] = c;
                inc(i, oldChar, -1);
                inc(i, newChar, 1);
            }
        }

        private void inc(int i, int c, int delta) {
            for (; i < n; i = (i | (i + 1)))
                t[i][c] += delta;
        }

        public int numberOfDifferentChars(int l, int r) {
            l--;
            r--;
            int res = 0;
            for (int i = 0; i < abc; i++) {
                if (sum(l, r, i) != 0) res++;
            }
            return res;
        }

        private int sum(int l, int r, int c) {
            return sumR(r, c) - sumR(l - 1, c);
        }

        private int sumR(int r, int c) {
            int result = 0;
            for (; r >= 0; r = (r & (r + 1)) - 1)
                result += t[r][c];
            return result;
        }
    }
}
