package leetcode.leetcode1xx.leetcode120;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

// Space complexity - O(1)
public class Solution2 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        for (int h = n - 2; h >= 0; h--) {
            ListIterator<Integer> curr = triangle.get(h).listIterator();
            Iterator<Integer> prev = triangle.get(h + 1).iterator();
            Integer left = prev.next();
            for (int i = 0; i <= h; i++) {
                Integer right = prev.next();
                curr.set(curr.next() + Math.min(left, right));
                left = right;
            }
        }
        Integer ans = triangle.get(0).get(0);

        //repair
        for (int h = 0; h <= n - 2; h++) {
            ListIterator<Integer> curr = triangle.get(h).listIterator();
            Iterator<Integer> prev = triangle.get(h + 1).iterator();
            Integer left = prev.next();
            for (int i = 0; i <= h; i++) {
                Integer right = prev.next();
                curr.set(curr.next() - Math.min(left, right));
                left = right;
            }
        }
        return ans;
    }
}
