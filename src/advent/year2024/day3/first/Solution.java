package advent.year2024.day3.first;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2024/day3/first/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2024/day3/first/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            long ans = 0;
            Pattern pattern = Pattern.compile("mul\\(\\d{1,3},\\d{1,3}\\)");

            while (scanner.hasNextLine()) {
                String s = scanner.nextLine().trim();
                Matcher matcher = pattern.matcher(s);
                int groupCount = matcher.groupCount();
                for (int i = 0; i < groupCount; i++) {
                    String group = matcher.group(i);
                    int pos = group.indexOf(",");
                    ans += (long) parseInt(group, 4, pos, 10) * parseInt(group, pos + 1, group.length() - 1, 10);
                }
            }
            printer.println(ans);
        }
    }
}
