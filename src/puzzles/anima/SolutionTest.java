package puzzles.anima;

import org.junit.jupiter.api.Test;
import puzzles.anima.Solution.Direction;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static puzzles.anima.Solution.Direction.*;

class SolutionTest {

    @Test
    void testLineDance() {
        int[][] field = {{1, 1, 1}};
        int[][] redStartCoords = {{0, 0}};
        int[][] redEndCoords = {{0, 2}};
        int[][] blueStartCoords = {};
        int[][] blueEndCoords = {};
        Direction[] expected = {RIGHT, RIGHT};
        Direction[] actual = Solution.solve(field, redStartCoords, redEndCoords, blueStartCoords, blueEndCoords);
        assertArrayEquals(expected, actual);
    }

    @Test
    void testUTurn() {
        int[][] field = {
                {1, 0, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        int[][] redStartCoords = {{0, 2}};
        int[][] redEndCoords = {{0, 0}};
        int[][] blueStartCoords = {};
        int[][] blueEndCoords = {};
        Direction[] expected = {DOWN, DOWN, LEFT, LEFT, UP, UP};
        Direction[] actual = Solution.solve(field, redStartCoords, redEndCoords, blueStartCoords, blueEndCoords);
        assertArrayEquals(expected, actual);
    }

    @Test
    void testGimbalLock() {
        int[][] field = {
                {1, 1, 1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1, 0, 1},
                {1, 1, 1, 0, 1, 1, 1}
        };
        int[][] redStartCoords = {{0, 0}};
        int[][] redEndCoords = {{1, 2}};
        int[][] blueStartCoords = {{0, 6}};
        int[][] blueEndCoords = {{2, 6}};
        Direction[] expected = {UP, RIGHT, UP, RIGHT, DOWN, LEFT};
        Direction[] actual = Solution.solve(field, redStartCoords, redEndCoords, blueStartCoords, blueEndCoords);
        assertArrayEquals(expected, actual);
    }

    @Test
    void testAntiparticle() {
        int[][] field = {
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
        };
        int[][] redStartCoords = {{1, 2}, {2, 1}, {2, 3}, {3, 2}};
        int[][] redEndCoords = {{1, 1}, {1, 3}, {3, 1}, {3, 3}};
        int[][] blueStartCoords = {{2, 2}};
        int[][] blueEndCoords = {};
        Direction[] expected = {UP, UP, DOWN, DOWN, DOWN, LEFT, DOWN, LEFT, RIGHT, RIGHT, RIGHT, UP, UP, UP, LEFT, UP, RIGHT, RIGHT, DOWN, DOWN, UP, LEFT};
        Direction[] actual = Solution.solve(field, redStartCoords, redEndCoords, blueStartCoords, blueEndCoords);
        assertArrayEquals(expected, actual);
    }
}