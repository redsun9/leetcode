package leetcode.leetcode1xx.leetcode138;

public class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node tmp = head;
        //a->a'->b->b'
        while (tmp != null) {
            Node node = new Node(tmp.val);
            node.next = tmp.next;
            tmp.next = node;
            tmp = node.next;
        }
        tmp = head;
        Node ans = tmp.next;
        // a.random = b, a->a'->...->b->b'
        while (tmp != null) {
            if (tmp.random != null) {
                tmp.next.random = tmp.random.next;
            }
            tmp = tmp.next.next;
        }

        //a->a'->b->b' => a->b,  a'->b'
        tmp = head;
        while (tmp != null) {
            Node b = tmp.next.next;
            tmp.next.next = b != null ? b.next : null;
            tmp.next = b;
            tmp = b;
        }
        return ans;
    }
}
