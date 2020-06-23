package sbercraft;

import java.util.Comparator;
import java.util.List;

public class Solution5 {
    public static int getNumberOfBoats(List<Integer> dwarfs, int limit) {
        // Напишите ваш код здесь...
        dwarfs.sort(Comparator.naturalOrder());
        int ans = dwarfs.size();
        int i = 0, j = dwarfs.size() - 1;
        while (i < j) {
            if (dwarfs.get(i++) + dwarfs.get(j) <= limit) ans--;
            j--;
        }
        return ans;
    }
}
