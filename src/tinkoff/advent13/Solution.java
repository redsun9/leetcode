package tinkoff.advent13;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

@SuppressWarnings({"DuplicatedCode", "ConstantConditions"})
public class Solution {
    private static final int n = 7493;
    private static final long maxVal = 10_000_000_000L;

    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/tinkoff/advent13/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/tinkoff/advent13/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingLong(x -> -x.number));
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine();
                long num = 0;
                for (int i = 0; i < s.length(); i++) {
                    char c = s.charAt(i);
                    if (c >= '0' && c <= '9') num = (num * 10 + c - '0') % maxVal;
                }
                pq.offer(new Pair(s, num));
                if (pq.size() > n) pq.poll();
            }

            printer.println(pq.poll().s);
        }
    }


    private record Pair(String s, long number) {
    }
}
