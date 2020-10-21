package leetcode.leetcode7xx.leetcode735;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> leftMoving = new ArrayList<>();
        Stack<Integer> rightMoving = new Stack<>();
        for (int asteroid : asteroids) {
            if (asteroid > 0) {
                rightMoving.push(asteroid);
            } else {
                boolean alive = true;
                while (alive && !rightMoving.isEmpty()) {
                    Integer peek = rightMoving.peek();
                    if (peek <= -asteroid) rightMoving.pop();
                    if (peek >= -asteroid) alive = false;
                }
                if (alive) leftMoving.add(asteroid);
            }
        }
        int[] ans = new int[leftMoving.size() + rightMoving.size()];
        int pos = 0;
        for (Integer asteroid : leftMoving) ans[pos++] = asteroid;
        for (int i = ans.length - 1; i >= pos; i--) ans[i] = rightMoving.pop();
        return ans;
    }
}
