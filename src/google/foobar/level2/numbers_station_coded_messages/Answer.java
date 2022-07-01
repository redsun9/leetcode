package google.foobar.level2.numbers_station_coded_messages;

import java.util.HashMap;
import java.util.Map;

public class Answer {
    public static int[] answer(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> prefSums = new HashMap<>();
        prefSums.put(0, -1);
        for (int i = 0, sum = 0; i < n; i++) {
            sum += nums[i];
            Integer pos = prefSums.get(sum - target);
            if (pos != null) return new int[]{pos + 1, i};
            prefSums.putIfAbsent(sum, i);
        }
        return new int[]{-1, -1};
    }
}
