package google.foobar.level1.minion_task_scheduling;

import java.util.HashMap;
import java.util.Map;

public class Answer {
    public static int[] answer(int[] data, int n) {
        if (n == 0) return new int[0];
        if (n >= data.length) return data;

        Map<Integer, Integer> count = new HashMap<>();
        for (int a : data) count.compute(a, (k, v) -> v == null ? 1 : v + 1);
        int ansLen = 0;
        for (Integer value : count.values()) if (value <= n) ansLen += value;

        int[] ans = new int[ansLen];
        int pos = 0;
        for (int a : data) if (count.get(a) <= n) ans[pos++] = a;
        return ans;
    }
}
