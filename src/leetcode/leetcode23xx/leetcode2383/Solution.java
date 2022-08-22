package leetcode.leetcode23xx.leetcode2383;

public class Solution {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int ans = 0;
        for (int e : energy) {
            if (initialEnergy <= e) {
                ans += e + 1 - initialEnergy;
                initialEnergy = 1;
            } else initialEnergy -= e;
        }
        for (int e : experience) {
            if (initialExperience <= e) {
                ans += e + 1 - initialExperience;
                initialExperience = 2 * e + 1;
            } else initialExperience += e;
        }
        return ans;
    }
}
