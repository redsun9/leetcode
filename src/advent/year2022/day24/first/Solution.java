package advent.year2022.day24.first;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SuppressWarnings({"DuplicatedCode"})
public class Solution {
    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2022/day24/first/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2022/day24/first/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            List<String> list = new ArrayList<>();
            while (scanner.hasNextLine()) list.add(scanner.nextLine().trim());
            int m = list.size() - 2;
            int n = list.get(1).length() - 2;
            int lcm = lcm(m, n);

            List<Integer>[] lbs = new List[m];
            List<Integer>[] rbs = new List[m];
            List<Integer>[] dbs = new List[n];
            List<Integer>[] ubs = new List[n];
            for (int i = 0; i < m; i++) {
                lbs[i] = new ArrayList<>();
                rbs[i] = new ArrayList<>();
            }
            for (int j = 0; j < n; j++) {
                dbs[j] = new ArrayList<>();
                ubs[j] = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    switch (list.get(i + 1).charAt(j + 1)) {
                        case '>' -> rbs[i].add(j);
                        case '<' -> lbs[i].add(j);
                        case 'v' -> dbs[j].add(i);
                        case '^' -> ubs[j].add(i);
                    }
                }
            }
            boolean[][][] restricted = new boolean[lcm][m][n];
            for (int i = 0; i < m; i++) {
                for (int rb : rbs[i]) {
                    for (int time = 0, pos = rb; time < lcm; time++) {
                        restricted[time][i][pos] = true;
                        pos++;
                        if (pos == n) pos = 0;
                    }
                }
                for (int lb : lbs[i]) {
                    for (int time = 0, pos = lb; time < lcm; time++) {
                        restricted[time][i][pos] = true;
                        pos--;
                        if (pos == -1) pos = n - 1;
                    }
                }
            }
            for (int j = 0; j < n; j++) {
                for (int db : dbs[j]) {
                    for (int time = 0, pos = db; time < lcm; time++) {
                        restricted[time][pos][j] = true;
                        pos++;
                        if (pos == m) pos = 0;
                    }
                }
                for (int ub : ubs[j]) {
                    for (int time = 0, pos = ub; time < lcm; time++) {
                        restricted[time][pos][j] = true;
                        pos--;
                        if (pos == -1) pos = m - 1;
                    }
                }
            }

            boolean[][] prev = new boolean[m][n];
            int ans = 0, time = 0;
            while (!prev[m - 1][n - 1]) {
                ans++;
                time++;
                if (time == lcm) time = 0;
                boolean[][] next = new boolean[m][n];
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        if (i == 0 && j == 0) next[0][0] = !restricted[time][0][0];
                        else {
                            next[i][j] = !restricted[time][i][j] && (
                                    prev[i][j] ||
                                            (i - 1 >= 0 && prev[i - 1][j]) ||
                                            (i + 1 < m && prev[i + 1][j]) ||
                                            (j - 1 >= 0 && prev[i][j - 1]) ||
                                            (j + 1 < n && prev[i][j + 1])
                            );
                        }
                    }
                }
                prev = next;
            }
            printer.println(ans + 1);
        }

    }

    private static int gcd(int a, int b) {
        int c;
        while (b != 0) {
            c = a % b;
            a = b;
            b = c;
        }
        return a;
    }

    private static int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }
}
