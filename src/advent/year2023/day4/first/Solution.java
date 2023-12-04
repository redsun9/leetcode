package advent.year2023.day4.first;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2023/day4/first/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2023/day4/first/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            long ans = 0;
            while (scanner.hasNextLine()) {
                ans += solve(scanner.nextLine().trim());
            }
            printer.println(ans);
        }
    }

    private static long solve(String s) {
        String[] split1 = s.split("(: )|( \\| )");
        String[] winningStrings = split1[1].trim().split(" +");
        Set<Integer> winningNumbers = new HashSet<>();
        for (String winningNumbersString : winningStrings) winningNumbers.add(Integer.parseInt(winningNumbersString));
        int numberOfMatches = 0;
        for (String havingString : split1[2].trim().split(" +")) {
            if (winningNumbers.contains(Integer.parseInt(havingString))) numberOfMatches++;
        }
        return numberOfMatches != 0 ? 1L << (numberOfMatches - 1) : 0;
    }
}
