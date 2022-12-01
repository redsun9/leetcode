package advent.year2021.day20.first;

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

    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2021/day20/first/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2021/day20/first/output.txt");
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

            int[][][] images = new int[3][m + 6][n + 6];
            int[][] startingImage = images[0];
            for (int i1 = 0, i2 = 3; i1 < m; i1++, i2++) {
                int[] row = startingImage[i2];
                String line = lines.get(i1);
                for (int j1 = 0, j2 = 3; j1 < n; j1++, j2++) {
                    row[j2] = line.charAt(j1) == '#' ? 1 : 0;
                }
            }

            if (debug) debugPrint(images[0], printer);

            for (int i = 2; i < m + 4; i++) {
                for (int j = 2; j < n + 4; j++) {
                    images[1][i][j] = cypher[calculateKey(images[0], i, j)];
                }
            }
            if (cypher[0] == 1) {
                for (int i = 0; i < m + 6; i++) {
                    images[1][i][0] = 1;
                    images[1][i][1] = 1;
                    images[1][i][n + 4] = 1;
                    images[1][i][n + 5] = 1;
                }
                Arrays.fill(images[1][0], 1);
                Arrays.fill(images[1][1], 1);
                Arrays.fill(images[1][m + 4], 1);
                Arrays.fill(images[1][m + 5], 1);
            }

            if (debug) debugPrint(images[1], printer);

            for (int i = 1; i < m + 5; i++) {
                for (int j = 1; j < n + 5; j++) {
                    images[2][i][j] = cypher[calculateKey(images[1], i, j)];
                }
            }

            if (debug) debugPrint(images[2], printer);

            int ans = 0;
            for (int[] row : images[2]) for (int a : row) ans += a;
            printer.println(ans);
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
