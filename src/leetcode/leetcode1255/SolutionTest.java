package leetcode.leetcode1255;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("SpellCheckingInspection")
class SolutionTest {

    @Test
    void maxScoreWords() {
        Solution solution = new Solution();
        assertEquals(23, solution.maxScoreWords(
                new String[]{"dog", "cat", "dad", "good"},
                new char[]{'a', 'a', 'c', 'd', 'd', 'd', 'g', 'o', 'o'},
                new int[]{1, 0, 9, 5, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        ));
        assertEquals(27, solution.maxScoreWords(
                new String[]{"xxxz", "ax", "bx", "cx"},
                new char[]{'z', 'a', 'b', 'c', 'x', 'x', 'x'},
                new int[]{4, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 10}
        ));
        assertEquals(0, solution.maxScoreWords(
                new String[]{"leetcode"},
                new char[]{'l', 'e', 't', 'c', 'o', 'd'},
                new int[]{0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0}
        ));
        assertEquals(51, solution.maxScoreWords(
                new String[]{"add", "dda", "bb", "ba", "add"},
                new char[]{'a', 'a', 'a', 'a', 'b', 'b', 'b', 'b', 'c', 'c', 'c', 'c', 'c', 'd', 'd', 'd'},
                new int[]{3, 9, 8, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        ));
    }
}