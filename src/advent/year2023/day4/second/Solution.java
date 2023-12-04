package advent.year2023.day4.second;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

@SuppressWarnings({"DuplicatedCode"})
public class Solution {
    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2023/day4/second/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2023/day4/second/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            long ans = 0;
            Map<Integer, Long> additionalCards = new HashMap<>();
            int currentCard = 0;
            while (scanner.hasNextLine()) {
                long matches = countMatches(scanner.nextLine().trim());
                long currentCount = 1 + additionalCards.getOrDefault(currentCard, 0L);
                ans += currentCount;
                for (int i = 1; i <= matches; i++) {
                    additionalCards.put(currentCard + i, currentCount + additionalCards.getOrDefault(currentCard + i, 0L));
                }
                currentCard++;
            }
            printer.println(ans);
        }
    }

    private static int countMatches(String s) {
        String[] split1 = s.split("(: )|( \\| )");
        String[] winningStrings = split1[1].trim().split(" +");
        Set<Integer> winningNumbers = new HashSet<>();
        for (String winningNumbersString : winningStrings) winningNumbers.add(Integer.parseInt(winningNumbersString));
        int numberOfMatches = 0;
        for (String havingString : split1[2].trim().split(" +")) {
            if (winningNumbers.contains(Integer.parseInt(havingString))) numberOfMatches++;
        }
        return numberOfMatches;
    }
}