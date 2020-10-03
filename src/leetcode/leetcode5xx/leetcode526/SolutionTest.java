package leetcode.leetcode5xx.leetcode526;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] expected = {1, 2, 3, 8, 10, 36, 41, 132, 250, 700, 750, 4010, 4237, 10680, 24679};
        Solution solution = new Solution();
        for (int i = 1; i <= 15; i++) {
            assertEquals(expected[i - 1], solution.countArrangement(i));
        }
    }

    // can take up to 10 minutes
    //32 2076570000 33923638848
    //33 2867880400 59455553072
    //34 4017842000 126536289568
    //35 10650582900 207587882368
    //36 19420024000 1495526775088
    //37 23_005222000 1510769105288
    //38 27_989633400 3187980614208
    //39 38_352772300 5415462995568
    //40 155_761057200 29811240618112
    @Test
    @org.junit.jupiter.api.Disabled
    void testPerf() {
        Solution2 solution = new Solution2();
        for (int i = 32; i <= 40; i++) {
            long startTime = System.nanoTime();
            long ans = solution.countArrangement(i);
            long endTime = System.nanoTime();
            System.out.println(i + " " + (endTime - startTime) + " " + ans);
        }
    }

    //32 1488633900 33923638848
    //33 993486400 59455553072
    //34 1339707900 126536289568
    //35 3236415400 207587882368
    //36 6017411000 1495526775088
    //37 7_304646100 1510769105288
    //38 8_464850800 3187980614208
    //39 10_708053800 5415462995568
    //40 53_094639300 29811240618112
    @Test
    @org.junit.jupiter.api.Disabled
    void testPerf2() {
        Solution3 solution = new Solution3();
        for (int i = 32; i <= 40; i++) {
            long startTime = System.nanoTime();
            long ans = solution.countArrangement(i);
            long endTime = System.nanoTime();
            System.out.println(i + " " + (endTime - startTime) + " " + ans);
        }
    }
}