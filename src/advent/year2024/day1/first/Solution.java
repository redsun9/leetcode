package advent.year2024.day1.first;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2024/day1/first/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2024/day1/first/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            long ans = 0;
            PriorityQueue<Integer> pq1 = new PriorityQueue<>();
            PriorityQueue<Integer> pq2 = new PriorityQueue<>();
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine().trim();
                String[] parts = s.split(" +");
                pq1.add(Integer.parseInt(parts[0]));
                pq2.add(Integer.parseInt(parts[1]));
            }
            while (!pq1.isEmpty()) ans += Math.abs(pq1.poll() - pq2.poll());
            printer.println(ans);
        }
    }
}
