package leetcode.leetcode20xx.leetcode2079;

public class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        int current = capacity, n = plants.length, ans = n;
        for (int i = 0; i < n; i++) {
            int plant = plants[i];
            if (current < plant) {
                ans += i * 2;
                current = capacity;
            }
            current -= plant;
        }
        return ans;
    }
}
