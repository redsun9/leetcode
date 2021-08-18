package leetcode.leetcode6xx.leetcode648;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        List<String> dictionary = List.of("cat", "bat", "rat");
        String sentence = "the cattle was rattled by the battery";
        String expected = "the cat was rat by the bat";
        assertEquals(expected, new Solution().replaceWords(dictionary, sentence));

    }

    @Test
    void test2() {
        List<String> dictionary = List.of("a", "b", "c");
        String sentence = "aadsfasf absbs bbab cadsfafs";
        String expected = "a a b c";
        assertEquals(expected, new Solution().replaceWords(dictionary, sentence));
    }

    @Test
    void test3() {
        List<String> dictionary = List.of("a", "aa", "aaa", "aaaa");
        String sentence = "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa";
        String expected = "a a a a a a a a bbb baba a";
        assertEquals(expected, new Solution().replaceWords(dictionary, sentence));
    }

    @Test
    void test4() {
        List<String> dictionary = List.of("catt", "cat", "bat", "rat");
        String sentence = "the cattle was rattled by the battery";
        String expected = "the cat was rat by the bat";
        assertEquals(expected, new Solution().replaceWords(dictionary, sentence));
    }

    @Test
    void test5() {
        List<String> dictionary = List.of("ac", "ab");
        String sentence = "it is abnormal that this solution is accepted";
        String expected = "it is ab that this solution is ac";
        assertEquals(expected, new Solution().replaceWords(dictionary, sentence));
    }
}