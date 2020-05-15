package leetcode.leetcode3xx.leetcode382;

import leetcode.tools.ListNode;

import java.util.Random;

public class Solution {
    private ListNode head;
    private Random random;

    public Solution(ListNode head) {
        this.head = head;
        this.random = new Random();
    }

    public int getRandom() {
        int current = head.val;
        int counter = 1;
        ListNode tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
            counter++;
            if (random.nextInt(counter) == 0) current = tmp.val;
        }
        return current;
    }
}
