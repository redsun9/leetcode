package leetcode.leetcode6xx.leetcode676;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MagicDictionaryTest {

    @Test
    void test1() {
        String[] words = {"hello", "leetcode"};
        MagicDictionary md = new MagicDictionary();
        md.buildDict(words);

        String[] searchWords = {"hello", "hhllo", "hell", "leetcoded"};
        boolean[] expected = {false, true, false, false};
        int numberOfTests = expected.length;
        boolean[] actual = new boolean[numberOfTests];
        for (int i = 0; i < numberOfTests; i++) actual[i] = md.search(searchWords[i]);
        assertArrayEquals(expected, actual);
    }
}