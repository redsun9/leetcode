package leetcode.leetcode0xx.leetcode68;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        Solution solution = new Solution();
        String[] words = {"What", "must", "be", "acknowledgment", "shall", "be"};
        List<String> expected = List.of(
                "What   must   be",
                "acknowledgment  ",
                "shall be        "
        );
        List<String> actual = solution.fullJustify(words, 16);
        assertEquals(expected, actual);
    }

    @Test
    void test2() {
        Solution solution = new Solution();
        String[] words = {
                "Science", "is", "what", "we", "understand", "well", "enough", "to", "explain",
                "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"};

        List<String> expected = List.of(
                "Science  is  what we",
                "understand      well",
                "enough to explain to",
                "a  computer.  Art is",
                "everything  else  we",
                "do                  "
        );
        List<String> actual = solution.fullJustify(words, 20);
        assertEquals(expected, actual);

    }


}