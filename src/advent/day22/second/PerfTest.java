package advent.day22.second;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class PerfTest {
    public static void main(String[] args) throws IOException {
        try (
                FileOutputStream fos = new FileOutputStream("src/advent/day22/second/input2.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            int n = 50, k = 1000;

            for (int i = n - 1, d = 2 * n - 1; i > 0; i--, d--) {
                int min1 = (-n - d) * k;
                int max1 = (-n + d) * k;
                int min2 = (n - d) * k;
                int max2 = (n + d) * k;

                printer.println(
                        ((i & 1) == 0 ? "off " : "on ") +
                                "x=" + min1 + ".." + max1 + "," +
                                "y=" + (-d * k) + ".." + d * k + "," +
                                "z=" + (-d * k) + ".." + d * k);
                printer.println(
                        ((i & 1) == 0 ? "off " : "on ") +
                                "x=" + min2 + ".." + max2 + "," +
                                "y=" + (-d * k) + ".." + d * k + "," +
                                "z=" + (-d * k) + ".." + d * k);
                printer.println(
                        ((i & 1) == 0 ? "off " : "on ") +
                                "x=" + (-d * k) + ".." + d * k + "," +
                                "y=" + min1 + ".." + max1 + "," +
                                "z=" + (-d * k) + ".." + d * k);
                printer.println(
                        ((i & 1) == 0 ? "off " : "on ") +
                                "x=" + (-d * k) + ".." + d * k + "," +
                                "y=" + min2 + ".." + max2 + "," +
                                "z=" + (-d * k) + ".." + d * k);
                printer.println(
                        ((i & 1) == 0 ? "off " : "on ") +
                                "x=" + (-d * k) + ".." + d * k + "," +
                                "y=" + (-d * k) + ".." + d * k + "," +
                                "z=" + min1 + ".." + max1);
                printer.println(
                        ((i & 1) == 0 ? "off " : "on ") +
                                "x=" + (-d * k) + ".." + d * k + "," +
                                "y=" + (-d * k) + ".." + d * k + "," +
                                "z=" + min2 + ".." + max2);
            }
        }

    }
}
