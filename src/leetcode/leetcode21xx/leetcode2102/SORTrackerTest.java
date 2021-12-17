package leetcode.leetcode21xx.leetcode2102;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("SpellCheckingInspection")
class SORTrackerTest {

    @Test
    void test1() {
        String[] commands = {"SORTracker", "add", "add", "get", "add", "get", "add", "get", "add", "get", "add", "get", "get"};
        Object[][] arguments = {{}, {"bradford", 2}, {"branford", 3}, {}, {"alps", 2}, {}, {"orland", 2}, {}, {"orlando", 3}, {}, {"alpine", 2}, {}, {}};
        Object[] expected = {null, null, null, "branford", null, "alps", null, "bradford", null, "bradford", null, "bradford", "orland"};
        check(commands, arguments, expected);
    }


    private static void check(String[] commands, Object[][] arguments, Object[] expected) {
        SORTracker tracker = new SORTracker();
        int n = commands.length;
        for (int i = 1; i < n; i++) {
            switch (commands[i]) {
                case "add" -> tracker.add((String) arguments[i][0], (Integer) arguments[i][1]);
                case "get" -> assertEquals(expected[i], tracker.get());
            }
        }
    }
}