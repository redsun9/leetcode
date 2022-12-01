package advent.year2021.day22.first;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

@SuppressWarnings({"DuplicatedCode"})
public class Solution {
    private static final int MIN_VAL = -50;
    private static final int MAX_VAL = 50;
    private static final int N = MAX_VAL - MIN_VAL + 1;

    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2021/day22/first/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2021/day22/first/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            int posStart, posMid, posEnd;

            boolean[][][] a = new boolean[N][N][N];
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine().trim();

                posStart = s.indexOf('=');
                posMid = s.indexOf("..", posStart);
                posEnd = s.indexOf(',', posMid);

                int startX = Math.max(MIN_VAL, Integer.parseInt(s, posStart + 1, posMid, 10));
                int endX = Math.min(MAX_VAL, Integer.parseInt(s, posMid + 2, posEnd, 10));

                posStart = s.indexOf('=', posEnd);
                posMid = s.indexOf("..", posStart);
                posEnd = s.indexOf(',', posMid);

                int startY = Math.max(MIN_VAL, Integer.parseInt(s, posStart + 1, posMid, 10));
                int endY = Math.min(MAX_VAL, Integer.parseInt(s, posMid + 2, posEnd, 10));

                posStart = s.indexOf('=', posEnd);
                posMid = s.indexOf("..", posStart);
                posEnd = s.length();

                int startZ = Math.max(MIN_VAL, Integer.parseInt(s, posStart + 1, posMid, 10));
                int endZ = Math.min(MAX_VAL, Integer.parseInt(s, posMid + 2, posEnd, 10));

                boolean val = s.charAt(1) == 'n';

                for (int x = startX, i = startX - MIN_VAL; x <= endX; x++, i++)
                    for (int y = startY, j = startY - MIN_VAL; y <= endY; y++, j++)
                        for (int z = startZ, k = startZ - MIN_VAL; z <= endZ; z++, k++)
                            a[i][j][k] = val;
            }

            int ans = 0;
            for (boolean[][] mat : a) for (boolean[] row : mat) for (boolean val : row) ans += val ? 1 : 0;
            printer.println(ans);
        }
    }
}
