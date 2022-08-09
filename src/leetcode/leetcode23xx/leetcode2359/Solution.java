package leetcode.leetcode23xx.leetcode2359;

public class Solution {
    //if path starting from node is looped, then returns [length before loop]
    //else return [length before null]
    private static int findDistanceBeforeLoop(int[] edges, int node) {
        int fast = node, slow = node, length = 0;
        do {
            if (fast == -1) return length;
            if (edges[fast] == -1) return length + 1;
            fast = edges[edges[fast]];
            slow = edges[slow];
            length += 2;
        } while (fast != slow);

        fast = node;
        length = 0;
        while (fast != slow) {
            fast = edges[fast];
            slow = edges[slow];
            length++;
        }
        return length;
    }

    private static int findDistanceBetweenNodes(int[] edges, int start, int end) {
        if (start == end) return 0;
        int length = 0, node = start;
        do {
            node = edges[node];
            length++;
        } while (node != start && node != end);
        if (node == start) return -1;
        else return length;
    }

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int loop1 = findDistanceBeforeLoop(edges, node1);
        int loop2 = findDistanceBeforeLoop(edges, node2);

        int l1 = loop1, l2 = loop2;
        while (l1 > l2) {
            node1 = edges[node1];
            l1--;
        }
        while (l2 > l1) {
            node2 = edges[node2];
            l2--;
        }
        while (node1 != node2 && l1 != 0) {
            node1 = edges[node1];
            node2 = edges[node2];
            l1--;
        }

        if (node1 == node2) return node1;
        if (node1 == -1 || node2 == -1) return -1;

        // node1 and node2 are some points in the loop
        l1 = findDistanceBetweenNodes(edges, node1, node2);
        if (l1 == -1) return -1;
        l2 = findDistanceBetweenNodes(edges, node2, node1);
        if (loop1 + l1 < loop2 + l2) return node2;
        if (loop2 + l2 < loop1 + l1) return node1;
        else return Math.min(node1, node2);
    }
}
