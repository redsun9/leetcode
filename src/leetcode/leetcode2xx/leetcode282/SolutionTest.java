package leetcode.leetcode2xx.leetcode282;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        String num = "123";
        int target = 6;
        List<String> expected = List.of("1*2*3", "1+2+3");
        assertEquals(new HashSet<>(expected), new HashSet<>(new Solution().addOperators(num, target)));
    }

    @Test
    void test2() {
        String num = "232";
        int target = 8;
        List<String> expected = List.of("2*3+2", "2+3*2");
        assertEquals(new HashSet<>(expected), new HashSet<>(new Solution().addOperators(num, target)));
    }

    @Test
    void test3() {
        String num = "105";
        int target = 5;
        List<String> expected = List.of("1*0+5", "10-5");
        assertEquals(new HashSet<>(expected), new HashSet<>(new Solution().addOperators(num, target)));
    }

    @Test
    void test4() {
        String num = "00";
        int target = 0;
        List<String> expected = List.of("0*0", "0+0", "0-0");
        assertEquals(new HashSet<>(expected), new HashSet<>(new Solution().addOperators(num, target)));
    }

    @Test
    void test5() {
        String num = "3456237490";
        int target = 9191;
        List<String> expected = List.of();
        assertEquals(new HashSet<>(expected), new HashSet<>(new Solution().addOperators(num, target)));
    }
}