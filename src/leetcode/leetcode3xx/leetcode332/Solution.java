package leetcode.leetcode3xx.leetcode332;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {
    private static final String startVal = "JFK";

    public List<String> findItinerary(List<List<String>> tickets) {

        Map<String, List<List<String>>> map = tickets.stream().collect(Collectors.groupingBy(x -> x.get(0)));
        map.values().forEach(list -> list.sort(Comparator.comparing((List<String> x) -> x.get(1))));
        Map<String, boolean[]> used = map.entrySet().stream().collect(Collectors.toMap(
                Map.Entry::getKey,
                x -> new boolean[x.getValue().size()]
        ));
        LinkedList<String> ans = new LinkedList<>();
        ans.add(startVal);
        dfs(map, used, startVal, 0, tickets.size(), ans);
        return ans;
    }

    private static boolean dfs(
            Map<String, List<List<String>>> map, Map<String, boolean[]> used,
            String curVal, int curPos, int totalTickets, LinkedList<String> ans
    ) {
        if (curPos == totalTickets) return true;
        List<List<String>> curTickets = map.get(curVal);
        if (curTickets == null) return false;
        boolean[] curUsed = used.get(curVal);
        for (int i = 0; i < curUsed.length; i++) {
            if (!curUsed[i]) {
                curUsed[i] = true;
                String nextVal = curTickets.get(i).get(1);
                ans.addLast(nextVal);
                if (dfs(map, used, nextVal, curPos + 1, totalTickets, ans)) return true;
                ans.removeLast();
                curUsed[i] = false;
            }
        }
        return false;
    }
}
