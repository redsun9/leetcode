package advent.year2023.day2.first;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Solution {
    public static final int MAX_RED = 12;
    public static final int MAX_GREEN = 13;
    public static final int MAX_BLUE = 14;

    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2023/day2/first/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2023/day2/first/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            long ans = 0;
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine().trim();
                String[] split1 = s.split(": ");
                int gameNumber = Integer.parseInt(split1[0].split(" ")[1]);
                boolean possible = isPossible(split1);
                if (possible) ans += gameNumber;
            }
            printer.println(ans);
        }
    }

    private static boolean isPossible(String[] split1) {
        boolean possible = true;
        for (String str : split1[1].split("(; )|(, )")) {
            String[] split3 = str.split(" ");
            switch (split3[1]) {
                case "red" -> possible &= Integer.parseInt(split3[0]) <= MAX_RED;
                case "green" -> possible &= Integer.parseInt(split3[0]) <= MAX_GREEN;
                case "blue" -> possible &= Integer.parseInt(split3[0]) <= MAX_BLUE;
                default -> {
                }
            }
        }
        return possible;
    }
}
