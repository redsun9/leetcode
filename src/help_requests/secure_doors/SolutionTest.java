package help_requests.secure_doors;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        assertEquals(Solution.secureWays(2, 1), 1);
        assertEquals(Solution2.secureWays(2, 1), 1);
    }

    @Test
    void testEqualResults() {
        for (int n = 0; n <= 31; n++) {
            for (int k = 0; k <= n; k++) {
                assertEquals(Solution.secureWays(n, k), Solution2.secureWays(n, k));
            }
        }
    }
}