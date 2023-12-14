package advent.year2023.day14.second;

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

    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2023/day14/second/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2023/day14/second/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            List<String> list = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine().trim();
                if (!s.isBlank()) list.add(s);
            }
            printer.println(solve(list, 1_000_000_000));
        }
    }

    private static long solve(List<String> list, int steps) {
        int m = list.size(), n = list.get(0).length();
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            String s = list.get(i);
            for (int j = 0; j < n; j++) {
                if (s.charAt(j) == '#') arr[i][j] = 2;
                else if (s.charAt(j) == 'O') arr[i][j] = 1;
            }
        }

        int[][] resultField = processSteps(arr, steps);
        printField(resultField);
        return calculatePressure(resultField);
    }

    private static int[][] processSteps(int[][] arr, int steps) {
        int m = arr.length, n = arr[0].length;
        int[][] fast = new int[m][n], slow = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                slow[i][j] = fast[i][j] = arr[i][j];
            }
        }
        int firstMet = 0;

        do {
            f(fast);
            f(fast);
            f(slow);
            firstMet++;
        } while (!Arrays.deepEquals(fast, slow) && firstMet != steps);
        if (firstMet == steps) return slow;

        int cycleLength = 0;
        do {
            f(fast);
            f(fast);
            f(slow);
            cycleLength++;
        } while (!Arrays.deepEquals(fast, slow) && firstMet + cycleLength != steps);
        if (firstMet + cycleLength == steps) return slow;

        System.out.println("firstMet = " + firstMet);
        System.out.println("cycleLength = " + cycleLength);

        int leftSteps = (steps - firstMet - cycleLength) % cycleLength;
        for (int i = 0; i < leftSteps; i++) f(slow);
        return slow;
    }


    private static void f(int[][] field) {
        processNorth(field);
        processWest(field);
        processSouth(field);
        processEast(field);
    }

    private static void processNorth(int[][] field) {
        int m = field.length, n = field[0].length;
        int[] arr = new int[n];
        for (int i = 0; i < m; i++) {
            int[] row = field[i];
            for (int j = 0; j < n; j++) {
                if (row[j] == 2) arr[j] = i + 1;
                else if (row[j] == 1) {
                    row[j] = 0;
                    field[arr[j]++][j] = 1;
                }
            }
        }
    }

    private static void processWest(int[][] field) {
        int m = field.length, n = field[0].length;
        for (int[] row : field) {
            int place = 0;
            for (int j = 0; j < n; j++) {
                if (row[j] == 2) place = j + 1;
                else if (row[j] == 1) {
                    row[j] = 0;
                    row[place++] = 1;
                }
            }
        }
    }

    private static void processSouth(int[][] field) {
        int m = field.length, n = field[0].length;
        int[] arr = new int[n];
        Arrays.fill(arr, m - 1);
        for (int i = m - 1; i >= 0; i--) {
            int[] row = field[i];
            for (int j = 0; j < n; j++) {
                if (row[j] == 2) arr[j] = i - 1;
                else if (row[j] == 1) {
                    row[j] = 0;
                    field[arr[j]--][j] = 1;
                }
            }
        }
    }

    private static void processEast(int[][] field) {
        int m = field.length, n = field[0].length;
        for (int[] row : field) {
            int place = n - 1;
            for (int j = n - 1; j >= 0; j--) {
                if (row[j] == 2) place = j - 1;
                else if (row[j] == 1) {
                    row[j] = 0;
                    row[place--] = 1;
                }
            }
        }
    }

    private static long calculatePressure(int[][] field) {
        int m = field.length, n = field[0].length;
        long ans = 0;
        for (int i = 0; i < m; i++) {
            int[] s = field[i];
            for (int j = 0; j < n; j++) {
                if (s[j] == 1) ans += m - i;
            }
        }
        return ans;
    }

    private static void printField(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                char c = switch (arr[i][j]) {
                    case 1 -> 'O';
                    case 2 -> '#';
                    default -> '.';
                };
                System.out.print(c);
            }
            System.out.println();
        }
        System.out.println();
    }
}