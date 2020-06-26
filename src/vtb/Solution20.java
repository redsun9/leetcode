package vtb;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class Solution20 {
    public static int getMinSize(List<Integer> arr) {
        // Напишите ваш код здесь...
        HashMap<Integer, Integer> count = new HashMap<>();
        for (Integer a : arr) count.merge(a, 1, Integer::sum);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.addAll(count.values());
        int n = (arr.size()) / 2;
        int ans = 0;
        while (n > 0) {
            n -= pq.poll();
            ans++;
        }
        return ans;
    }
}
