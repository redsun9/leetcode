package leetcode.leetcode13xx.leetcode1311;

import java.util.*;
import java.util.function.ToIntFunction;

@SuppressWarnings("ConstantConditions")
public class Solution {
    private static final Comparator<Map.Entry<String, Integer>> comparator =
            Comparator.comparingInt(
                    (ToIntFunction<Map.Entry<String, Integer>>) Map.Entry::getValue
            ).thenComparing(Map.Entry::getKey);

    public List<String> watchedVideosByFriends(
            List<List<String>> watchedVideos, int[][] friends, int id, int level
    ) {
        int n = friends.length;
        boolean[] seen = new boolean[n];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(id);
        seen[id] = true;
        while (level-- > 0) {
            int genSize = queue.size();
            for (int i = 0; i < genSize; i++)
                for (int friend : friends[queue.poll()])
                    if (!seen[friend]) {
                        seen[friend] = true;
                        queue.add(friend);
                    }
        }

        Map<String, Integer> map = new HashMap<>();
        while (!queue.isEmpty()) {
            for (String s : watchedVideos.get(queue.poll())) {
                map.compute(s, (k, v) -> v == null ? 1 : v + 1);
            }
        }
        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

        list.sort(comparator);

        List<String> ans = new ArrayList<>(list.size());
        for (Map.Entry<String, Integer> entry : list) ans.add(entry.getKey());
        return ans;
    }
}
