package codeforces.contest1769;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class ProblemD2 {
    private static final long[] ans = {
            44638803535L, 2114441327L, 37688141227L, 51184207205L, 18144820618L,
            38190408566L, 54613330700L, 64497041035L, 4408175150L, 5926267818L,
            48462539803L, 53033318331L, 8442097602L, 66990621194L, 56385327596L,
            1949592055L, 67567718920L, 10332418292L, 13686018551L, 15717372407L,
            7903384055L, 3076002295L, 7911510519L, 1080291287L, 1080291303L,
            1076097015L
    };

    private static final char[] colors = {'C', 'D', 'S', 'H'};
    private static final char[] values = {'6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A'};
    private static final long fullMask = (1L << 36) - 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintStream printer = new PrintStream(System.out);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            if (i != 0) printer.println();
            printer.println(convert(ans[i]));
            printer.println(convert(fullMask ^ ans[i]));
        }

    }

    private static String convert(long a) {
        char[] ans = new char[18 * 3 - 1];
        Arrays.fill(ans, ' ');
        for (int i = 0, pos = 0; i < 36; i++) {
            if ((a >> i & 1) == 1) {
                ans[3 * pos] = values[i % 9];
                ans[3 * pos + 1] = colors[i / 9];
                pos++;
            }
        }
        return new String(ans);
    }
}
