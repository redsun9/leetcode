package leetcode.leetcode22xx.leetcode2251;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] persons) {
        int m = persons.length;
        int n = flowers.length;

        int[][] personQueue = new int[m][2];
        for (int i = 0; i < m; i++) {
            personQueue[i][0] = persons[i];
            personQueue[i][1] = i;
        }
        Arrays.sort(personQueue, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<int[]> wq = new PriorityQueue<>(Comparator.comparingInt(x -> x[0]));
        PriorityQueue<int[]> bq = new PriorityQueue<>(Comparator.comparingInt(x -> x[1]));

        for (int i = 0; i < n; i++) {
            int[] flower = flowers[i];
            wq.add(new int[]{flower[0], flower[1], i});
        }

        int[] ans = new int[m];
        for (int[] person : personQueue) {
            int personTime = person[0];
            int personId = person[1];
            while (!wq.isEmpty() && wq.peek()[0] <= personTime) bq.add(wq.poll());
            while (!bq.isEmpty() && bq.peek()[1] < personTime) bq.poll();
            ans[personId] = bq.size();
        }
        return ans;
    }
}
