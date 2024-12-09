package advent.year2024.day9.second;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2024/day9/input/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2024/day9/second/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            printer.println(solve(scanner.nextLine().trim()));
        }
    }

    @SuppressWarnings({"unchecked", "DataFlowIssue"})
    private static long solve(String s) {
        int n = s.length();

        PriorityQueue<Integer>[] holes = new PriorityQueue[10];
        for (int i = 0; i < 10; i++) holes[i] = new PriorityQueue<>();
        int[] startingPositions = new int[(n + 1) / 2];

        for (int i = 0, sum = 0; i < n; i++) {
            int c = s.charAt(i) - '0';
            if (i % 2 == 0) startingPositions[i / 2] = sum;
            else holes[c].add(sum);
            sum += c;
        }

        long ans = 0;
        for (int i = startingPositions.length - 1; i >= 0; i--) {
            int c = s.charAt(2 * i) - '0';

            int maxLeft = Integer.MAX_VALUE, maxLeftSize = -1;
            for (int j = c; j < 10; j++) {
                if (!holes[j].isEmpty() && holes[j].peek() < startingPositions[i] && holes[j].peek() < maxLeft) {
                    maxLeft = holes[j].peek();
                    maxLeftSize = j;
                }
            }
            if (maxLeftSize != -1) {
                holes[maxLeftSize].poll();
                ans += i * c * (2L * maxLeft + c - 1) / 2;
                holes[maxLeftSize - c].offer(maxLeft + c);
            } else {
                ans += i * c * (2L * startingPositions[i] + c - 1) / 2;
            }
        }
        return ans;
    }
}
