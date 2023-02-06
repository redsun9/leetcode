package help_requests.knight_and_queen;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings({"DuplicatedCode", "StringBufferReplaceableByString"})
class SolutionTest {
    private static final int n = 8;
    private static final int total = n * n;

    @Test
    void testPath() {
        int[][] expected = {{0, 6}, {2, 7}, {4, 6}, {6, 5}, {5, 7}, {7, 6}, {5, 5}, {4, 7}, {2, 6}, {0, 5}, {1, 7}};
        int[][] actual = Solution2.solve(0, 6, 1, 7, 3, 4);
        assertArrayEquals(expected, actual);
    }

    @Test
    void testDist() {
        assertEquals(10, Solution3.solve(0, 6, 1, 7, 3, 4));
    }

    @Test
    void testSolution3() {
        assertEquals(1, Solution3.solve("a1", "b3", "a5"));
        assertEquals(1, Solution3.solve("a1", "b3", "a6"));
        assertEquals(2, Solution3.solve("a1", "a3", "b5"));
        assertEquals(2, Solution3.solve("a1", "a3", "b6"));
        assertEquals(3, Solution3.solve("a1", "a2", "d6"));
        assertEquals(3, Solution3.solve("a1", "a2", "d7"));
        assertEquals(4, Solution3.solve("a1", "a3", "c6"));
        assertEquals(4, Solution3.solve("a1", "a3", "c7"));
        assertEquals(5, Solution3.solve("a1", "a2", "b5"));
        assertEquals(5, Solution3.solve("a1", "a2", "b6"));
        assertEquals(6, Solution3.solve("a1", "a3", "d2"));
        assertEquals(6, Solution3.solve("a1", "a3", "e2"));
        assertEquals(7, Solution3.solve("a1", "a2", "b4"));
        assertEquals(7, Solution3.solve("a1", "a2", "c1"));
        assertEquals(8, Solution3.solve("a1", "a7", "b5"));
        assertEquals(8, Solution3.solve("a1", "a7", "b4"));
        assertEquals(9, Solution3.solve("a1", "b7", "c5"));
        assertEquals(9, Solution3.solve("a1", "c8", "b4"));
        assertEquals(10, Solution3.solve("a2", "b1", "d4"));
        assertEquals(10, Solution3.solve("a3", "a5", "c4"));
    }


    @Test
    void testSolution4() {
        assertEquals(1, Solution4.solve("a1", "b3", "c2", "a3"));
        assertEquals(1, Solution4.solve("a1", "b3", "c2", "a5"));
        assertEquals(2, Solution4.solve("a1", "a3", "b4", "a2"));
        assertEquals(2, Solution4.solve("a1", "a3", "b4", "a5"));
        assertEquals(3, Solution4.solve("a1", "a2", "d3", "a6"));
        assertEquals(3, Solution4.solve("a1", "a2", "d3", "a7"));
        assertEquals(4, Solution4.solve("a1", "a3", "c2", "a5"));
        assertEquals(4, Solution4.solve("a1", "a3", "c2", "a8"));
        assertEquals(5, Solution4.solve("a1", "a2", "b3", "a5"));
        assertEquals(5, Solution4.solve("a1", "a2", "b3", "a8"));
        assertEquals(6, Solution4.solve("a1", "a3", "c2", "a7"));
        assertEquals(6, Solution4.solve("a1", "a3", "c2", "e3"));
        assertEquals(7, Solution4.solve("a1", "a2", "b3", "a7"));
        assertEquals(7, Solution4.solve("a1", "a2", "b3", "b6"));
        assertEquals(8, Solution4.solve("a1", "a3", "d2", "a5"));
        assertEquals(8, Solution4.solve("a1", "a3", "d5", "b1"));
        assertEquals(9, Solution4.solve("a1", "a2", "b4", "e1"));
        assertEquals(9, Solution4.solve("a1", "a2", "b4", "e3"));
        assertEquals(10, Solution4.solve("a1", "a3", "c4", "e4"));
        assertEquals(10, Solution4.solve("a1", "a3", "e2", "b5"));
        assertEquals(11, Solution4.solve("a1", "a4", "c5", "f2"));
        assertEquals(11, Solution4.solve("a1", "a4", "e3", "b6"));
        assertEquals(12, Solution4.solve("a1", "a5", "e4", "c4"));
        assertEquals(12, Solution4.solve("a1", "a7", "e4", "c4"));
    }

    @Test
    void testSolution5() {
        String[] field = {
                "##..#####.",
                ".#.#.#....",
                "###..##.#.",
                "..##.....#",
                ".###.#####",
        };
        int[][] expected1 = {{0, 9}, {1, 7}, {3, 6}};
        int[][] actual1 = Solution5.solve(field, 0, 9, 3, 6);
        assertArrayEquals(expected1, actual1);

        int[][] expected2 = {{0, 2}, {2, 3}, {4, 4}, {3, 6}, {1, 7}, {0, 9}};
        int[][] actual2 = Solution5.solve(field, 0, 2, 0, 9);
        assertArrayEquals(expected2, actual2);

        assertNull(Solution5.solve(field, 4, 0, 0, 9));
    }


    @Test
    void testSolution6() {
        assertEquals("a2,c1,b3,a5,c6,b8,a6,c7,b5,a3,b1", Solution6.solve("a2", "b1", "d4"));
        assertEquals("a3,b1,d2,f3,g5,h7,f6,e8,d6,b7,a5", Solution6.solve("a3", "a5", "c4"));
        assertEquals("a1,c2,a3", Solution6.solve("a1", "a3", "b6"));
        assertEquals("a1,b3", Solution6.solve("a1", "b3", "c5"));
        assertEquals("a1,c2,e1,d3,c1,a2", Solution6.solve("a1", "a2", "b6"));
    }

    public static void main(String[] args) {
        generateTestsForSolution3();
        generateTestsForSolution4();
    }

    private static void generateTestsForSolution3() {
        int[] count = new int[11];
        for (int start = 0; start < total; start++) {
            int startX = start / n, startY = start % n;
            if (startX >= n / 2 || startX > startY) continue;
            for (int end = start + 1; end < total; end++) {
                int endX = end / n, endY = end % n;
                for (int queen = 0; queen < total; queen++) {
                    if (queen == start || queen == end) continue;
                    int queenX = queen / n, queenY = queen % n;
                    int ans = Solution3.solve(startX, startY, endX, endY, queenX, queenY);
                    if (ans <= 0) continue;
                    if (++count[ans] <= 2) print3(startX, startY, endX, endY, queenX, queenY, ans);
                }
            }
        }
    }

    private static void generateTestsForSolution4() {
        int[] count = new int[100];
        for (int start = 0; start < total; start++) {
            int startX = start / n, startY = start % n;
            if (startX >= n / 2 || startX > startY) continue;
            for (int end = start + 1; end < total; end++) {
                int endX = end / n, endY = end % n;
                for (int rook = 0; rook < total; rook++) {
                    if (rook == start || rook == end) continue;
                    int rookX = rook / n, rookY = rook % n;
                    if (rookX == startX || rookX == endX || rookY == startY || rookY == endY) continue;
                    for (int bishop = 0; bishop < total; bishop++) {
                        int bishopX = bishop / n, bishopY = bishop % n;
                        if (bishopX + bishopY == startX + startY || bishopX - bishopY == startX - startY) continue;
                        if (bishopX + bishopY == endX + endY || bishopX - bishopY == endX - endY) continue;
                        int ans = Solution4.solve(startX, startY, endX, endY, rookX, rookY, bishopX, bishopY);
                        if (ans <= 0) continue;
                        if (++count[ans] <= 2) print4(startX, startY, endX, endY, rookX, rookY, bishopX, bishopY, ans);
                    }
                }
            }
        }
    }

    private static void print3(int startX, int startY, int endX, int endY, int queenX, int queenY, int ans) {
        StringBuilder sb = new StringBuilder();
        sb.append("assertEquals(").append(ans).append(", Solution3.solve(");
        sb.append("\"").append((char) ('a' + startX)).append(startY + 1).append("\", ");
        sb.append("\"").append((char) ('a' + endX)).append(endY + 1).append("\", ");
        sb.append("\"").append((char) ('a' + queenX)).append(queenY + 1).append("\"));");
        System.out.println(sb);
    }

    private static void print4(int startX, int startY, int endX, int endY, int rookX, int rookY, int bishopX, int bishopY, int ans) {
        StringBuilder sb = new StringBuilder();
        sb.append("assertEquals(").append(ans).append(", Solution4.solve(");
        sb.append("\"").append((char) ('a' + startX)).append(startY + 1).append("\", ");
        sb.append("\"").append((char) ('a' + endX)).append(endY + 1).append("\", ");
        sb.append("\"").append((char) ('a' + rookX)).append(rookY + 1).append("\", ");
        sb.append("\"").append((char) ('a' + bishopX)).append(bishopY + 1).append("\"));");
        System.out.println(sb);
    }
}