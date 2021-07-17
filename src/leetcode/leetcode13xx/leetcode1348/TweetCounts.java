package leetcode.leetcode13xx.leetcode1348;

import java.util.*;

public class TweetCounts {
    private static final int MINUTE = 60;
    private static final int HOUR = 3600;
    private static final int DAY = 86400;

    private final Map<String, TreeMap<Integer, Integer>> map = new HashMap<>();

    private static int chunkForFreq(String freq) {
        return switch (freq) {
            case "minute" -> MINUTE;
            case "hour" -> HOUR;
            case "day" -> DAY;
            default -> throw new IllegalStateException("Unexpected value: " + freq);
        };
    }

    private static AbstractList<Integer> asList(int[] ans) {
        return new AbstractList<>() {
            @Override
            public Integer get(int index) {
                return ans[index];
            }

            @Override
            public int size() {
                return ans.length;
            }
        };
    }

    public void recordTweet(String tweetName, int time) {
        map.computeIfAbsent(tweetName, key -> new TreeMap<>()).compute(time, (k, v) -> v == null ? 1 : v + 1);
    }

    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
        int chunk = chunkForFreq(freq);
        int chunkNumber = (endTime - startTime) / chunk + 1;
        int[] arr = new int[chunkNumber];
        List<Integer> ans = asList(arr);

        TreeMap<Integer, Integer> countMap = map.get(tweetName);
        if (countMap == null) return ans;
        for (Map.Entry<Integer, Integer> entry : countMap.tailMap(startTime).entrySet()) {
            if (entry.getKey() > endTime) break;
            arr[(entry.getKey() - startTime) / chunk] += entry.getValue();
        }
        return ans;
    }
}
