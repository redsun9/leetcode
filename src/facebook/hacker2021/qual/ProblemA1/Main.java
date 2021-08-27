package facebook.hacker2021.qual.ProblemA1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.Set;

@SuppressWarnings("UnnecessarySemicolon")
public class Main {
    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/facebook/hacker2021/qual/ProblemA1/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/facebook/hacker2021/qual/ProblemA1/output.txt");
                PrintStream printer = new PrintStream(fos);
        ) {
            int t = Integer.parseInt(scanner.nextLine());
            for (int i = 1; i <= t; i++) {
                String s = scanner.nextLine();
                int ans = minSubmissions(s);
                printer.println("Case #" + i + ": " + ans);
            }
        }
    }

    private static int minSubmissions(String s) {
        int n = s.length();
        Set<Integer> vowels = Set.of(0, 4, 8, 14, 20);
        int[] count = new int[26];
        for (int i = 0; i < n; i++) count[s.charAt(i) - 'A']++;

        int maxVowel = 0, maxConsonant = 0, totalVowels = 0, totalConsonants = 0;
        for (int i = 0; i < 26; i++) {
            if (vowels.contains(i)) {
                maxVowel = Math.max(maxVowel, count[i]);
                totalVowels += count[i];
            } else {
                maxConsonant = Math.max(maxConsonant, count[i]);
                totalConsonants += count[i];
            }
        }

        return Math.min(
                totalConsonants + 2 * (totalVowels - maxVowel),
                totalVowels + 2 * (totalConsonants - maxConsonant)
        );
    }
}
