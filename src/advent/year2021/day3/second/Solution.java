package advent.year2021.day3.second;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

@SuppressWarnings("DuplicatedCode")
public class Solution {
    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2021/day3/second/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2021/day3/second/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            List<Integer> l1 = new LinkedList<>(), l2 = new LinkedList<>();
            int m = 0;
            while (scanner.hasNextLine()) {
                int num = Integer.parseInt(scanner.nextLine().trim(), 2);
                l1.add(num);
                l2.add(num);
                m = Math.max(m, Integer.highestOneBit(num));
            }

            int oxygen = f(l1, m, true);
            int dioxide = f(l2, m, false);
            printer.println(oxygen * dioxide);
        }
    }

    private static int f(List<Integer> numbers, int m, boolean most) {
        while (numbers.size() > 1) {
            int count = 0, n = numbers.size();
            for (Integer number : numbers) {
                if ((number & m) != 0) count++;
            }

            int toStay;
            if (most) toStay = count * 2 >= n ? m : 0;
            else toStay = count * 2 >= n ? 0 : m;
            int finalM = m;
            numbers.removeIf(integer -> (integer & finalM) != toStay);
            m >>>= 1;
        }
        return numbers.get(0);
    }
}
