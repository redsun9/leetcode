package leetcode.leetcode22xx.leetcode2227;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("SpellCheckingInspection")
class EncrypterTest {
    @Test
    void test1() {
        char[] keys = {'a', 'b', 'c', 'd'};
        String[] values = {"ei", "zf", "ei", "am"};
        String[] dictionary = {"abcd", "acbd", "adbc", "badc", "dacb", "cadb", "cbda", "abad"};

        Encrypter encrypter = new Encrypter(keys, values, dictionary);
        assertEquals("eizfeiam", encrypter.encrypt("abcd"));
        assertEquals(2, encrypter.decrypt("eizfeiam"));
    }
}