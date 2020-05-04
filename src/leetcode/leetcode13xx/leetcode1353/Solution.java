package leetcode.leetcode13xx.leetcode1353;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int maxEvents(int[][] events) {
        int n = events.length;
        if (n <= 1) return n;
        //сортируем события по дате начала
        Arrays.sort(events, Comparator.comparingInt((int[] arr) -> arr[0]));

        //куча с концами событий. будем из нее брать наиболее срочное.
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int i = 0, day = 0, ans = 0;

        while (!queue.isEmpty() || i < n) {
            //если нет срочных событий, то перемещаемся до ближайшего
            if (queue.isEmpty()) day = events[i][0];

            //заносим все события, которые можно сейчас сделать
            while (i < n && events[i][0] <= day) queue.offer(events[i++][1]);

            //берем самое критичное
            queue.poll();
            day++;
            ans++;

            //удаляем все, которые просрочены
            while (!queue.isEmpty() && queue.peek() < day) queue.poll();
        }
        return ans;
    }
}
