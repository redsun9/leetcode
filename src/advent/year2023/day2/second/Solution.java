package advent.year2023.day2.second;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

@SuppressWarnings({"DuplicatedCode"})
public class Solution {
    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2023/day2/second/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2023/day2/second/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            long ans = 0;
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine().trim();
                String[] split1 = s.split(": ");
                long possible = calculatePower(split1[1]);
                ans += possible;
            }
            printer.println(ans);
        }
    }

    private static long calculatePower(String split1) {
        int maxRed = 0, maxBlue = 0, maxGreen = 0;
        for (String str : split1.split("(; )|(, )")) {
            String[] split3 = str.split(" ");
            int parsedInt = Integer.parseInt(split3[0]);
            switch (split3[1]) {
                case "red" -> maxRed = Math.max(maxRed, parsedInt);
                case "green" -> maxBlue = Math.max(maxBlue, parsedInt);
                case "blue" -> maxGreen = Math.max(maxGreen, parsedInt);
                default -> {
                }
            }
        }
        return (long) maxRed * maxGreen * maxBlue;
    }
}
