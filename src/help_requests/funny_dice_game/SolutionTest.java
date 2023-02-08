package help_requests.funny_dice_game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        assertEquals(33_333_333_6, Solution.solve(2, 3));
        assertEquals(263680002, Solution.solve(5, 5));
    }
}