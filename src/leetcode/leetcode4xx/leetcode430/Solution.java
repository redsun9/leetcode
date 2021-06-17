package leetcode.leetcode4xx.leetcode430;

public class Solution {
    public Node flatten(Node head) {
        Node node = head;
        while (node != null) {
            if (node.child != null) {
                Node tmp = node.child;
                while (tmp.next != null) tmp = tmp.next;
                tmp.next = node.next;
                if (node.next != null) node.next.prev = tmp;
                node.next = node.child;
                node.child.prev = node;
                node.child = null;
            }
            node = node.next;
        }
        return head;
    }
}
