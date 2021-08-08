package leetcode.leetcode9xx.leetcode955;

/*
    We are given an array A of N lowercase letter strings, all of the same length.
    Now, we may choose any set of deletion indices, and for each string, we delete all the characters in those indices.
    For example, if we have an array A = ["abcdef","uvwxyz"] and deletion indices {0, 2, 3}, then the final array after deletions is ["bef", "vyz"]

    Suppose we chose a set of deletion indices D such that after deletions, each resulting strings in A is in non-decreasing sorted order.
    Return the minimum possible value of D.length.
 */

public class Solution {
    public int minDeletionSize(String[] a) {
        int n = a.length;
        if (a.length <= 1) return 0;
        int m = a[0].length();
        Node head = null;
        for (int i = n - 1; i >= 0; i--) head = new Node(i, head);
        int ans = 0;
        int pos = 0;
        while (head.next != null && pos < m) {
            boolean shouldDelete = false;
            Node toDeleteStart = null;
            Node toDeleteEnd = null;
            Node tmp = head;
            while (tmp.next != null) {
                int idx = tmp.next.idx;
                char c1 = a[idx - 1].charAt(pos);
                char c2 = a[idx].charAt(pos);
                if (c1 > c2) {
                    shouldDelete = true;
                    break;
                }
                if (c1 < c2) {
                    // add indices to delete list
                    Node next = tmp.next.next;
                    tmp.next.next = toDeleteStart;
                    toDeleteStart = tmp.next;
                    tmp.next = next;
                    if (toDeleteEnd == null) toDeleteEnd = toDeleteStart;
                } else {
                    tmp = tmp.next;
                }
            }
            if (shouldDelete) {
                ans++;
                if (toDeleteStart != null) {
                    // return back deleted indices
                    toDeleteEnd.next = head.next;
                    head.next = toDeleteStart;
                }
            }
            pos++;
        }
        return ans;
    }

    private static class Node {
        int idx;
        Node next;

        public Node(int idx, Node next) {
            this.idx = idx;
            this.next = next;
        }
    }
}
