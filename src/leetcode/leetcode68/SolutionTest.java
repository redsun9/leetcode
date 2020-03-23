package leetcode.leetcode68;

import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void fullJustify() {
        Solution solution = new Solution();
        solution.fullJustify(
                new String[]{"What", "must", "be", "acknowledgment", "shall", "be"},
                16
        ).forEach(str -> {
            System.out.println(str.replace(" ", "_"));
        });
        System.out.println();

        solution.fullJustify(
                new String[]{
                        "Science", "is", "what", "we", "understand", "well", "enough", "to", "explain",
                        "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"},
                20
        ).forEach(str -> {
            System.out.println(str.replace(" ", "_"));
        });
    }


}