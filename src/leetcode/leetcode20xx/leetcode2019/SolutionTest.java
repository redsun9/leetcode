package leetcode.leetcode20xx.leetcode2019;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void scoreOfStudents() {
        String s = "1+4+4+1*0+2";
        int[] answers = {7, 717, 2, 11, 11, 236, 7, 15, 7, 11, 11, 561, 7, 164, 19, 11, 11, 15, 11, 15, 11, 826, 7, 733, 19, 2, 831, 2, 11, 2, 665, 3, 11, 3, 2, 11, 52, 19, 7, 559, 2, 19, 7, 15, 664, 3, 113, 11, 454};
        Assertions.assertEquals(108, new Solution().scoreOfStudents(s, answers));
    }
}