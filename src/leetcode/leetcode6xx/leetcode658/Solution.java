package leetcode.leetcode6xx.leetcode658;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        if (n == k) return Arrays.stream(arr).boxed().collect(Collectors.toList());
        int lo = 0;
        int hi = n - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo + 1) / 2;
            if (arr[mid] < x) lo = mid;
            else hi = mid - 1;
        }
        int left = lo != hi ? hi : (arr[lo] < x ? lo : lo - 1); //the right most which is lower
        lo = 0;
        hi = n - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] > x) hi = mid;
            else lo = mid + 1;
        }
        int right = lo != hi ? lo : (arr[lo] > x ? lo : lo + 1); //the left most which is higher

        if (right - left > k) return Collections.nCopies(k, x);
        LinkedList<Integer> ans = new LinkedList<>(Collections.nCopies(right - left - 1, x));
        k -= (right - left - 1);

        while (k > 0) {
            if (left >= 0 && right < n) {
                if (arr[right] - x < x - arr[left]) {
                    ans.addLast(arr[right++]);
                } else {
                    ans.addFirst(arr[left--]);
                }
                k--;
            } else if (left >= 0) {
                while (k-- > 0) ans.addFirst(arr[left--]);
                break;
            } else {
                while (k-- > 0) ans.addLast(arr[right++]);
                break;
            }
        }
        return ans;
    }
}
