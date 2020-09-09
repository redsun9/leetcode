package sber;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PalindromCheckerTest {
    @Test
    void test1() {
        assertTrue(new PalindromChecker().isPalindrom("abcd", "!!;d№;%;c...ba<><>"));
    }
}