package leetcode.leetcode11xx.leetcode1171;

import leetcode.tools.ListNode;

import java.util.HashMap;

public class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        HashMap<Integer, ListNode> map = new HashMap<>();
        ListNode root = new ListNode(0, head);
        map.put(0, root);
        int sum = 0;
        ListNode tmp = head;
        while (tmp != null) {
            sum += tmp.val;
            if (map.containsKey(sum)) {
                ListNode start = map.get(sum);
                ListNode next = start.next;
                int tmpSum = sum;
                while (next != tmp) {
                    tmpSum += next.val;
                    map.remove(tmpSum);
                    next = next.next;
                }
                start.next = tmp.next;
            } else {
                map.put(sum, tmp);
            }
            tmp = tmp.next;
        }
        return root.next;
    }
}
