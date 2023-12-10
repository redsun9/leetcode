package advent.year2023.day10.first;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static final int[] direction = {-1, 0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2023/day10/first/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2023/day10/first/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            List<String> field = new ArrayList<>();
            while (scanner.hasNextLine()) field.add(scanner.nextLine().trim());
            printer.println(solve(field) / 2);
        }
    }

    private static int solve(List<String> field) {
        int m = field.size(), n = field.get(0).length();
        boolean foundStart = false;
        int startI = 0, startJ = 0;
        for (int i = 0; i < m && !foundStart; i++) {
            for (int j = 0; j < n && !foundStart; j++) {
                if (field.get(i).charAt(j) == 'S') {
                    startI = i;
                    startJ = j;
                    foundStart = true;
                }
            }
        }
        int firstI = 0, firstJ = 0;
        for (int k = 0; k < 4; k++) {
            firstI = startI + direction[k];
            firstJ = startJ + direction[k + 1];
            if (firstI < 0 || firstI >= m || firstJ < 0 || firstJ >= n) continue;
            int mask = movesMask(field.get(firstI).charAt(firstJ));
            if ((mask >> ((2 + k) % 4) & 1) == 1) break;
        }

        int ans = 1;
        int i1 = startI, j1 = startJ, i2 = firstI, j2 = firstJ, i3 = 0, j3 = 0;

        while (i2 != startI || j2 != startJ) {
            int movesMask = movesMask(field.get(i2).charAt(j2));
            for (int k = 0; k < 4; k++) {
                if ((movesMask >> k & 1) == 0) continue;
                i3 = i2 + direction[k];
                j3 = j2 + direction[k + 1];
                if (i3 < 0 || j3 < 0 || i3 >= m || j3 >= n) continue;
                if (i3 == i1 && j3 == j1) continue;
                break;
            }
            ans++;
            i1 = i2;
            j1 = j2;
            i2 = i3;
            j2 = j3;
        }
        return ans;
    }


    private static int movesMask(char c) {
        return switch (c) {
            case '|' -> 5;
            case '-' -> 10;
            case 'L' -> 3;
            case 'J' -> 9;
            case '7' -> 12;
            case 'F' -> 6;
            default -> 0;
        };
    }
}
