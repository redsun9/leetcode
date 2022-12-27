package leetcode.leetcode25xx.leetcode2512;

import java.util.*;

@SuppressWarnings("DataFlowIssue")
public class Solution {
    public List<Integer> topStudents(String[] positiveFeedback, String[] negativeFeedback, String[] report, int[] studentId, int k) {
        Set<String> pSet = new HashSet<>(Arrays.asList(positiveFeedback));
        Set<String> nSet = new HashSet<>(Arrays.asList(negativeFeedback));
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt((int[] x) -> x[0]).thenComparingInt(x -> -x[1]));
        int n = report.length;
        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{f(report[i], pSet, nSet), studentId[i]});
            if (i >= k) pq.poll();
        }
        Integer[] ans = new Integer[k];
        for (int i = k - 1; i >= 0; i--) ans[i] = pq.poll()[1];
        return Arrays.asList(ans);

    }

    private static int f(String report, Set<String> pSet, Set<String> nSet) {
        int ans = 0, startPos = 0, n = report.length();
        while (true) {
            int spacePos = report.indexOf(' ', startPos);
            String word = report.substring(startPos, spacePos > 0 ? spacePos : n);
            if (pSet.contains(word)) ans += 3;
            else if (nSet.contains(word)) ans -= 1;

            if (spacePos < 0) break;
            startPos = spacePos + 1;
        }
        return ans;
    }
}
