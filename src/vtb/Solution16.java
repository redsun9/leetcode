package vtb;

import java.util.List;

/*
Binary Subarrays With Sum
 */
public class Solution16 {
    public static int numSubarrays(List<Integer> a, int s) {
        // Напишите ваш код здесь...
        int psum = 0;
        int res = 0;
        int[] count = new int[a.size() + 1];
        count[0] = 1;
        for (int i : a) {
            psum += i;
            if (psum >= s)
                res += count[psum - s];
            count[psum]++;
        }
        return res;
    }
}
