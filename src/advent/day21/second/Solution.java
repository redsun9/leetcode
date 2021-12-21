package advent.day21.second;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

@SuppressWarnings({"DuplicatedCode"})
public class Solution {
    private static final int sides = 3;
    private static final int targetScore = 21;
    private static final int len = 10;

    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/day21/second/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/day21/second/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            int firstStartPos = Integer.parseInt(scanner.nextLine().trim().split(" ")[4]);
            int secondStartPos = Integer.parseInt(scanner.nextLine().trim().split(" ")[4]);

            int[] possibilities = new int[len];
            for (int a = 1; a <= sides; a++) {
                for (int b = 1; b <= sides; b++) {
                    for (int c = 1; c <= sides; c++) {
                        possibilities[(a + b + c) % len]++;
                    }
                }
            }

            // turn, firstScore, secondScore, firstPos, secondPos
            long[][][][][] dp = new long[2][targetScore + len][targetScore + len][len + 1][len + 1];
            dp[0][0][0][firstStartPos][secondStartPos] = 1;

            for (int firstScore = 0; firstScore < targetScore; firstScore++) {
                for (int secondScore = 0; secondScore < targetScore; secondScore++) {
                    for (int firstPos = 1; firstPos <= len; firstPos++) {
                        for (int secondPos = 1; secondPos <= len; secondPos++) {
                            for (int d = 0; d < len; d++) {
                                int firstPosAfter = (firstPos + d - 1) % len + 1;
                                int secondPosAfter = (secondPos + d - 1) % len + 1;

                                dp[1][firstScore + firstPosAfter][secondScore][firstPosAfter][secondPos] +=
                                        possibilities[d] * dp[0][firstScore][secondScore][firstPos][secondPos];
                                dp[0][firstScore][secondScore + secondPosAfter][firstPos][secondPosAfter] +=
                                        possibilities[d] * dp[1][firstScore][secondScore][firstPos][secondPos];
                            }
                        }
                    }
                }
            }

            long sum1 = 0;
            long sum2 = 0;

            for (int winningOverthrow = 0; winningOverthrow < len; winningOverthrow++) {
                for (int losingScore = 0; losingScore < targetScore; losingScore++) {
                    for (int firstPos = 1; firstPos <= len; firstPos++) {
                        for (int secondPos = 1; secondPos <= len; secondPos++) {
                            sum1 += dp[1][targetScore + winningOverthrow][losingScore][firstPos][secondPos];
                            sum2 += dp[0][losingScore][targetScore + winningOverthrow][firstPos][secondPos];
                        }
                    }
                }
            }

            printer.println(Math.max(sum1, sum2));
        }
    }
}
