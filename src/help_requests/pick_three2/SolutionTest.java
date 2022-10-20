package help_requests.pick_three2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void test() {
        for (int i = 0; i <= Solution2.MAX_VAL; i++) {
            try {
                assertEquals(Solution.pickThree(i), Solution2.pickThree(i));
            } catch (Throwable e) {
                System.out.println(i);
                throw e;
            }
        }
    }
}