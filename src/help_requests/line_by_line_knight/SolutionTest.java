package help_requests.line_by_line_knight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        String[] field = {
                "##S.#####E",
                ".#.#.#....",
                "###..##.#.",
                "..##.....#",
                ".###.#####",
        };
        assertEquals(5, Solution.minDistance(field));
    }

    @Test
    void test2() {
        String[] field = {
                "##.###.###",
                "####.###.#",
                "#.########",
                "#########.",
                "E###S#####",
                "########.#",
                "###.######",
                "#####.###.",
                "#######.##"
        };
        assertEquals(12, Solution.minDistance(field));
    }
}