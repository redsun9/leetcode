package leetcode.leetcode16xx.leetcode1604;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        int n = keyName.length;
        List<Integer> list = IntStream.range(0, n).boxed()
                .sorted(Comparator.comparing(ind -> keyTime[ind]))
                .collect(Collectors.toList());
        HashMap<String, int[]> lastTimeMap = new HashMap<>();
        HashSet<String> alerts = new HashSet<>();
        for (Integer ind : list) {
            String user = keyName[ind];
            String s = keyTime[ind];
            int time = ((s.charAt(0) - '0') * 10 + s.charAt(1) - '0') * 60 + (s.charAt(3) - '0') * 10 + s.charAt(4) - '0';
            int[] lastTime = lastTimeMap.get(user);
            if (lastTime == null) {
                lastTime = new int[]{-61, time};
            } else {
                if (time - lastTime[0] <= 60) alerts.add(user);
                lastTime[0] = lastTime[1];
                lastTime[1] = time;
            }
            lastTimeMap.put(user, lastTime);
        }
        return alerts.stream().sorted().collect(Collectors.toList());
    }
}
