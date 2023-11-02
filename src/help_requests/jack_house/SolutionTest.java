package help_requests.jack_house;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class SolutionTest {

    @Test
    void test1() {
        long[] x = {3, 6, 4};
        long c = 10;
        long[] ans = Solution.solve(x, c);
        System.out.println(Arrays.toString(ans));
    }

    @Test
    void test2() {
        long[] x = {179, 57, 2022};
        long c = 1;
        long[] ans = Solution.solve(x, c);
        System.out.println(Arrays.toString(ans));
    }

    @Test
    void test3() {
        long[] x = {3, 5, 7};
        long c = 4;
        long[] ans = Solution.solve(x, c);
        System.out.println(Arrays.toString(ans));
    }

    @Test
    void test4() {
        long[] x = {101, 102, 103};
        long c = 1000;
        long[] ans = Solution.solve(x, c);
        System.out.println(Arrays.toString(ans));
    }

    @Test
    void solve2d() {
        long[] ans = Solution.solve2d(6, 6, 8);
        System.out.println(Arrays.toString(ans));
    }
}