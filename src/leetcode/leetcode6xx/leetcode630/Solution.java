package leetcode.leetcode6xx.leetcode630;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, Comparator.comparingInt(x -> x[1]));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int time = 0;
        for (int[] course : courses) {
            time += course[0];
            pq.add(course[0]);
            if (time > course[1]) time -= pq.poll();
        }
        return pq.size();
    }
}