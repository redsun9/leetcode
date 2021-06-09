package leetcode.leetcode18xx.leetcode1882;

import java.util.Comparator;
import java.util.PriorityQueue;

@SuppressWarnings("ConstantConditions")
public class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        PriorityQueue<int[]> availableServers = new PriorityQueue<>(
                Comparator.comparingInt((int[] x) -> x[1]).thenComparingInt(x -> x[0])
        );
        PriorityQueue<int[]> processingTasks = new PriorityQueue<>(Comparator.comparingInt(x -> x[2]));
        for (int i = 0; i < servers.length; i++) {
            availableServers.offer(new int[]{i, servers[i], 0});
        }
        int numberOfTasks = tasks.length;
        int[] ans = new int[numberOfTasks];
        int time = 0;
        for (int i = 0; i < numberOfTasks; i++) {
            time = Math.max(time, i);
            while (!processingTasks.isEmpty() && processingTasks.peek()[2] <= time)
                availableServers.offer(processingTasks.poll());
            if (availableServers.isEmpty()) {
                time = processingTasks.peek()[2];
                while (!processingTasks.isEmpty() && processingTasks.peek()[2] <= time)
                    availableServers.offer(processingTasks.poll());
            }
            int[] availableServer = availableServers.poll();
            ans[i] = availableServer[0];
            availableServer[2] = time + tasks[i];
            processingTasks.offer(availableServer);
        }
        return ans;
    }
}
