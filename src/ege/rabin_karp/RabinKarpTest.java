package ege.rabin_karp;

import antihash.AntiRollingHash;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RabinKarpTest {

    @Test
    void test1() {
        String haystack = "abcabcd";
        int n = haystack.length();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                assertTrue(RabinKarp.contains(haystack, haystack.substring(i, j)));
                assertTrue(RabinKarp2.contains(haystack, haystack.substring(i, j)));
            }
        }

    }

    @Test
    void test2() {
        String haystack = "abcabcd";
        String needle = "aa";
        assertFalse(RabinKarp.contains(haystack, needle));
        assertFalse(RabinKarp2.contains(haystack, needle));
    }

    @Test
    void test3() {
        String haystack = "abcabcd";
        String needle = "dbcd";
        //collision, 'a'%3 == 'd'%3  => hash("abca")==hash("dbcd")
        assertTrue(RabinKarp.contains(haystack, needle));
        assertTrue(RabinKarp2.contains(haystack, needle));
    }

    @Test
    void test4() {
        String haystack = "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb";
        String needle = "a";
        assertFalse(RabinKarp.contains(haystack, needle));
        assertFalse(RabinKarp2.contains(haystack, needle));
    }

    @Test
        // read for explanation https://codeforces.com/blog/entry/60442
    void test5() {
        // Thue–Morse sequences
        String haystack = AntiRollingHash.str11;
        String needle = AntiRollingHash.str12;

        //collision should occur for all hashes of form
        // hash = sum_{i=0}^n c[i]*base^i
        assertTrue(RabinKarp.contains(haystack, needle));

        //collision shouldn't occur for hashes which aware of integer overflow
        // hash = (sum_{i=0}^n c[i]*base^i) % mod
        assertFalse(RabinKarp2.contains(haystack, needle));
    }
}