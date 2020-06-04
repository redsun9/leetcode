package leetcode.leetcode14xx.leetcode1429;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class FirstUnique {
    private LinkedHashSet<Integer> unique = new LinkedHashSet<>();
    private HashSet<Integer> nonUnique = new HashSet<>();

    public FirstUnique(int[] nums) {
        for (int num : nums) add(num);

    }

    public int showFirstUnique() {
        if (unique.isEmpty()) return -1;
        else return unique.iterator().next();
    }

    public void add(int value) {
        if (!nonUnique.contains(value))
            if (unique.contains(value)) {
                unique.remove(value);
                nonUnique.add(value);
            } else unique.add(value);
    }
}
