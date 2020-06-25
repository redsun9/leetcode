package atcoder.dp;

import java.util.Scanner;

public class ProblemH {
    public static final int mod = 1_000_000_007;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split(" ");
        int h = Integer.parseInt(strings[0]);
        int w = Integer.parseInt(strings[1]);
        long[] prev = new long[w + 1];
        long[] curr = new long[w + 1];
        prev[1] = 1;
        for (int i = 0; i < h; i++) {
            String row = scanner.nextLine();
            for (int j = 0; j < w; j++) {
                curr[j + 1] = row.charAt(j) == '.' ? (curr[j] + prev[j + 1]) % mod : 0;
            }
            long[] tmp = prev;
            prev = curr;
            curr = tmp;
        }
        System.out.println(prev[w]);
    }
}
