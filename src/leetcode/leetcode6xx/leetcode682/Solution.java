package leetcode.leetcode6xx.leetcode682;

import java.util.ArrayList;

public class Solution {
    public int calPoints(String[] ops) {
        ArrayList<Integer> points = new ArrayList<>();
        for (String s : ops) {
            switch (s) {
                case "+" -> points.add(points.get(points.size() - 1) + points.get(points.size() - 2));
                case "D" -> points.add(points.get(points.size() - 1) * 2);
                case "C" -> points.remove(points.size() - 1);
                default -> points.add(Integer.parseInt(s));
            }
        }
        int ans = 0;
        for (Integer point : points) {
            ans += point;
        }
        return ans;
    }
}
