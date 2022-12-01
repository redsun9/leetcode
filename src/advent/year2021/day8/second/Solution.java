package advent.year2021.day8.second;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Map;
import java.util.Scanner;

@SuppressWarnings({"DuplicatedCode"})
public class Solution {
    private static final int NUM_SEGMENTS = 7;

    private static final Map<Integer, Integer> targetMap = Map.of(
            0b1110111, 0,
            0b0010010, 1,
            0b1011101, 2,
            0b1011011, 3,
            0b0111010, 4,
            0b1101011, 5,
            0b1101111, 6,
            0b1010010, 7,
            0b1111111, 8,
            0b1111011, 9
    );

    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2021/day8/second/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2021/day8/second/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            int ans = 0;
            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split("\\|");
                String[] digits = line[0].trim().split(" ");
                int[] digitMasks = new int[10];
                for (int i = 0; i < 10; i++) {
                    String digit = digits[i];
                    int mask = 0, n = digit.length();
                    for (int j = 0; j < n; j++) mask |= 1 << (digit.charAt(j) - 'a');
                    digitMasks[i] = mask;
                }
                int[] cypher = {0, 1, 2, 3, 4, 5, 6}; // decoded segment - original segment
                if (!decode(0, digitMasks, cypher)) throw new RuntimeException();

                String[] parts = line[1].trim().split(" ");
                int num = 0;
                for (String part : parts) {
                    int n = part.length();
                    int mask = 0;
                    for (int i = 0; i < n; i++) mask |= 1 << cypher[part.charAt(i) - 'a'];
                    num = num * 10 + targetMap.get(mask);
                }
                ans += num;
            }
            printer.println(ans);
        }
    }

    private static boolean decode(int i, int[] digitMasks, int[] cypher) {
        if (i == NUM_SEGMENTS) return check(digitMasks, cypher);
        for (int j = i; j < NUM_SEGMENTS; j++) {
            int tmp = cypher[i];
            cypher[i] = cypher[j];
            cypher[j] = tmp;

            if (decode(i + 1, digitMasks, cypher)) return true;
            tmp = cypher[i];
            cypher[i] = cypher[j];
            cypher[j] = tmp;
        }
        return false;
    }

    private static boolean check(int[] digitMasks, int[] cypher) {
        for (int digitMask : digitMasks) {
            int tmp = 0;
            for (int i = 0; i < NUM_SEGMENTS; i++) {
                if ((digitMask >>> i & 1) != 0) tmp |= 1 << cypher[i];
            }
            if (!targetMap.containsKey(tmp)) return false;
        }
        return true;
    }
}
