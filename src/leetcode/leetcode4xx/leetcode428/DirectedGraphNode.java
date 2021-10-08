package leetcode.leetcode4xx.leetcode428;

import java.util.ArrayList;

public class DirectedGraphNode {
    int label;
    ArrayList<DirectedGraphNode> neighbors;

    DirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<>();
    }

}
