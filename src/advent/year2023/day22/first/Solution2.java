package advent.year2023.day22.first;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.MAX_VALUE;
import static java.util.Comparator.comparingInt;

@SuppressWarnings("DuplicatedCode")
public class Solution2 {
    public static void main(String[] args) throws IOException {
        try (
//                FileInputStream fis = new FileInputStream("src/advent/year2023/day22/example.txt");
                FileInputStream fis = new FileInputStream("src/advent/year2023/day22/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2023/day22/first/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            printer.println(solve(parseInput(scanner)));
        }
    }

    private static List<int[]> parseInput(Scanner scanner) {
        List<int[]> input = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine().trim();
            if (!s.isBlank()) {
                String[] split = s.split("\\D+");
                int[] block = new int[6];
                for (int i = 0; i < 6; i++) block[i] = Integer.parseInt(split[i]);
                input.add(block);
            }

        }
        return input;
    }

    private static int solve(List<int[]> input) {
        int n = input.size();
        input.sort(comparingInt(x -> x[2]));

        boolean[] cantBeRemoved = new boolean[n + 1];

        int minX = MAX_VALUE, maxX = Integer.MIN_VALUE, minY = MAX_VALUE, maxY = Integer.MIN_VALUE;
        for (int[] block : input) {
            minX = Math.min(minX, block[0]);
            maxX = Math.max(maxX, block[3]);
            minY = Math.min(minY, block[1]);
            maxY = Math.max(maxY, block[4]);
        }

        int[][][] maximumsForColumns = new int[maxX - minX + 1][maxY - minY + 1][2];
        for (int idx = 0; idx < n; idx++) {
            int[] block = input.get(idx);
            int max1 = 0, max2 = 0, idx1 = 0, idx2 = 0;
            for (int i = block[0] - minX; i <= block[3] - minX; i++) {
                for (int j = block[1] - minY; j <= block[4] - minY; j++) {
                    int[] maximum = maximumsForColumns[i][j];
                    if (maximum[1] == idx1 || maximum[1] == idx2) continue;
                    if (maximum[0] > max1) {
                        max2 = max1;
                        idx2 = idx1;
                        max1 = maximum[0];
                        idx1 = maximum[1];
                    } else if (maximum[0] > max2) {
                        max2 = maximum[0];
                        idx2 = maximum[1];
                    }
                }
            }
            if (max1 != max2) cantBeRemoved[idx1] = true;

            int newH = max1 + block[5] - block[2] + 1;
            for (int i = block[0] - minX; i <= block[3] - minX; i++) {
                for (int j = block[1] - minY; j <= block[4] - minY; j++) {
                    maximumsForColumns[i][j][0] = newH;
                    maximumsForColumns[i][j][1] = idx + 1;
                }
            }
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) if (!cantBeRemoved[i]) ans++;
        return ans;
    }
}
