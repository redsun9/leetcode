package leetcode.leetcode2xx.leetcode202;

import java.util.Set;

public class Solution3 {
    private static final Set<Integer> set = Set.of(
            1, 7, 10, 13, 19, 23, 28, 31, 32, 44, 49, 68, 70, 79, 82, 86, 91, 94, 97,
            100, 103, 109, 129, 130, 133, 139, 167, 176, 188, 190, 192, 193, 203, 208,
            219, 226, 230, 236, 239, 262, 263, 280, 291, 293, 301, 302, 310, 313, 319,
            320, 326, 329, 331, 338, 356, 362, 365, 367, 368, 376, 379, 383, 386, 391,
            392, 397, 404, 409, 440, 446, 464, 469, 478, 487, 490, 496, 536, 556, 563,
            565, 566, 608, 617, 622, 623, 632, 635, 637, 638, 644, 649, 653, 655, 656,
            665, 671, 673, 680, 683, 694, 700, 709, 716);

    public boolean isHappy(int n) {
        return set.contains(sum(n));
    }

    private static int sum(int n) {
        int ans = 0;
        while (n != 0) {
            ans += (n % 10) * (n % 10);
            n /= 10;
        }
        return ans;
    }
}
