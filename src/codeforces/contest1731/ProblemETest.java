package codeforces.contest1731;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProblemETest {

    @Test
    void solve() throws IOException {
        try (
                FileInputStream testFis = new FileInputStream("src/codeforces/contest1731/testsE.txt");
                Scanner testScanner = new Scanner(testFis);
                FileInputStream ansFis = new FileInputStream("src/codeforces/contest1731/answersE.txt");
                Scanner answerScanner = new Scanner(ansFis);
        ) {
            while (testScanner.hasNextLine()) {
                int n = testScanner.nextInt();
                long m = testScanner.nextLong();
                long expected = answerScanner.nextLong();
                long actual = ProblemE.solve(n, m);
                if (expected != actual) System.out.println(n + " " + m);
                assertEquals(expected, actual);
            }
        }
    }

    @Test
    void test1() {
        assertEquals(2, ProblemE.solve(9, 1));
    }
}