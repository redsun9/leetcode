package advent.year2024.day4.first;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2024/day4/input/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2024/day4/first/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            List<String> strings = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine().trim();
                if (!s.isBlank() && !s.isEmpty()) strings.add(s);
            }
            printer.println(solve(strings));
        }
    }

    private static int solve(List<String> arr) {
        String xmas = "XMAS";
        int L = xmas.length();

        int m = arr.size();
        int n = arr.get(0).length();
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int di = -1; di <= 1; di++) {
                    for (int dj = -1; dj <= 1; dj++) {
                        boolean ok = true;
                        for (int k = 0, newI = i, newJ = j; k < L && ok; k++, newI += di, newJ += dj) {
                            ok = newI >= 0 && newI < m && newJ >= 0 && newJ < n && arr.get(newI).charAt(newJ) == xmas.charAt(k);
                        }
                        if (ok) ans++;
                    }
                }
            }
        }
        return ans;
    }
}
