package leetcode.leetcode23;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, Comparator.comparingInt(x -> x.val));
        for (ListNode list : lists) {
            if (list != null) queue.offer(list);
        }
        if (queue.isEmpty()) return null;
        ListNode result = queue.poll();
        //noinspection ConstantConditions
        if (result.next != null) {
            queue.offer(result.next);
        }
        ListNode tmp = result;
        while (!queue.isEmpty()) {
            ListNode next = queue.poll();
            tmp.next = next;
            if (next.next != null) {
                queue.offer(next.next);
            }
            tmp = tmp.next;
        }
        return result;
    }
}
