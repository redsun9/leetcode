package help_requests.beautiful_alley;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    private static final int N = 30;

    @Test
    void test1() {
        assertEquals(9, Solution.maxBeauty("01111010001"));
        assertEquals(9, Solution.maxBeauty("10000101110"));
        assertEquals(4, Solution.maxBeauty("1010"));
        assertEquals(4, Solution.maxBeauty("10101"));
    }

    @Test
    void maxBeauty() {
        for (int i = 0; i < 10; i++) {
            String s = generate(i);
            System.out.println(s + " " + Solution.maxBeauty(s));
        }
    }


    private static String generate(long seed) {
        char[] arr = new char[N];
        Random random = new Random(seed);
        for (int i = 0; i < N; i++) arr[i] = random.nextBoolean() ? '0' : '1';
        return new String(arr);
    }
}