package suggestions.boolean_satisfiability;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

class SolutionTest {

    @Test
    void test1() {
        String[] equations = {"a!=b", "b!=c", "c!=a"};
        assertFalse(new Solution().equationsPossible(equations));
    }
}