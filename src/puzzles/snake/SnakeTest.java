package puzzles.snake;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SnakeTest {

    @Test
    void test5() {
        assertEquals(19, Snake.solve(5));
    }

    @Test
    void test7() {
        assertEquals(39, Snake.solve(7));
    }
}