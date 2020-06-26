package vtb;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution18 {
    public static List<Integer> firstNSmallest(List<Integer> arr, int n) {
        // Напишите ваш код здесь...
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                n + 1,
                Comparator.comparingInt((Integer x) -> -arr.get(x))
                        .thenComparingInt(x -> -x)
        );
        for (int i = 0; i < n; i++) pq.offer(i);
        for (int i = n; i < arr.size(); i++) {
            pq.offer(i);
            pq.poll();
        }
        ArrayList<Integer> indices = new ArrayList<>(pq);
        indices.sort(Comparator.naturalOrder());
        List<Integer> ans = new ArrayList<>(n);
        for (Integer index : indices) ans.add(arr.get(index));
        return ans;
    }
}
