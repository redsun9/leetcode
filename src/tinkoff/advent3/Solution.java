package tinkoff.advent3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.PriorityQueue;
import java.util.Scanner;

@SuppressWarnings("ConstantConditions")
public class Solution {
    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/tinkoff/advent3/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/tinkoff/advent3/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            String[] s = scanner.nextLine().trim().split(" ");
            int h = Integer.parseInt(s[1]);

            s = scanner.nextLine().trim().split(" ");
            int ans = Integer.MAX_VALUE;
            int currLen = 0;
            PriorityQueue<Integer> pq = new PriorityQueue<>();

            for (String str : s) {
                int a = Integer.parseInt(str);
                currLen += a;
                pq.offer(a);
                if (currLen >= h) {
                    while (currLen >= h) currLen -= pq.poll();
                    ans = Math.min(ans, pq.size());
                }
            }
            printer.println(ans);
        }
    }
}
