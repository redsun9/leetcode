package advent.day20.second;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@SuppressWarnings({"DuplicatedCode"})
public class Solution {
    private static final boolean debug = false;
    private static final int times = 50;

    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/day20/second/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/day20/second/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            String s = scanner.nextLine().trim();
            int cypherLength = s.length();
            int[] cypher = new int[cypherLength];
            for (int i = 0; i < cypherLength; i++) cypher[i] = s.charAt(i) == '#' ? 1 : 0;

            scanner.nextLine();
            List<String> lines = new ArrayList<>();
            while (scanner.hasNextLine()) lines.add(scanner.nextLine());

            int m = lines.size(), n = lines.get(0).length();
            int[][][] images = new int[2][m + 2 * times + 2][n + 2 * times + 2];
            int[][] startingImage = images[0];
            for (int i1 = 0, i2 = 1 + times; i1 < m; i1++, i2++) {
                int[] row = startingImage[i2];
                String line = lines.get(i1);
                for (int j1 = 0, j2 = 1 + times; j1 < n; j1++, j2++) {
                    row[j2] = line.charAt(j1) == '#' ? 1 : 0;
                }
            }

            int left = times;
            while (left > 0) {
                process(images[left & 1], images[left & 1 ^ 1], left, cypher);
                if (debug) debugPrint(images[left & 1], printer);
                left--;
            }

            int ans = 0;
            for (int[] row : images[0]) for (int a : row) ans += a;
            printer.println(ans);
        }

    }

    private static void process(int[][] prev, int[][] next, int timesLeft, int[] cypher) {
        int lb = timesLeft - 1, rb = prev[0].length - timesLeft;
        int tb = timesLeft - 1, bb = prev.length - timesLeft;
        int val = cypher[0] & timesLeft;
        for (int i = tb; i <= bb; i++) {
            prev[i][lb] = val;
            prev[i][lb + 1] = val;
            prev[i][rb] = val;
            prev[i][rb - 1] = val;
        }
        Arrays.fill(prev[lb], val);
        Arrays.fill(prev[lb + 1], val);
        Arrays.fill(prev[bb], val);
        Arrays.fill(prev[bb - 1], val);

        for (int i = tb + 1; i < bb; i++) {
            for (int j = lb + 1; j < rb; j++) {
                next[i][j] = cypher[calculateKey(prev, i, j)];
            }
        }
    }


    private static void debugPrint(int[][] image, PrintStream printer) {
        for (int[] row : image) {
            for (int a : row) printer.print(a == 1 ? '#' : '.');
            printer.println();
        }
        printer.println();
    }

    private static int calculateKey(int[][] image, int i, int j) {
        int key = 0;
        for (int k1 = 0, i1 = i - 1; k1 < 3; k1++, i1++) {
            for (int k2 = 0, j1 = j - 1; k2 < 3; k2++, j1++) {
                key = key << 1 | image[i1][j1];
            }
        }
        return key;
    }
}
