package leetcode.leetcode1172;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DinnerPlatesTest {

    @Test
    void test1() {
        String[] cmd = new String[]{"DinnerPlates", "push", "push", "push", "push", "push", "popAtStack", "push", "push", "popAtStack", "popAtStack", "pop", "pop", "pop", "pop", "pop"};
        int[][] args = new int[][]{{2}, {1}, {2}, {3}, {4}, {5}, {0}, {20}, {21}, {0}, {2}, {}, {}, {}, {}, {}};
        Integer[] expected = new Integer[]{null, null, null, null, null, null, 2, null, null, 20, 21, 5, 4, 3, 1, -1};
        DinnerPlates dp = null;
        for (int i = 0; i < cmd.length; i++) {
            switch (cmd[i]) {
                case "DinnerPlates":
                    dp = new DinnerPlates(args[i][0]);
                    break;
                case "push":
                    dp.push(args[i][0]);
                    break;
                case "popAtStack":
                    assertEquals(expected[i], dp.popAtStack(args[i][0]));
                    break;
                case "pop":
                    assertEquals(expected[i], dp.pop());
                    break;
                default:
                    throw new UnsupportedOperationException(cmd[i]);
            }
        }
    }
}