package leetcode.leetcode5xx.leetcode558;

public class Solution {
    public Node intersect(Node quadTree1, Node quadTree2) {
        if (quadTree1.isLeaf && quadTree1.val) return quadTree1;
        if (quadTree2.isLeaf && quadTree2.val) return quadTree2;
        if (quadTree1.isLeaf) return quadTree2;
        if (quadTree2.isLeaf) return quadTree1;
        Node topLeft = intersect(quadTree1.topLeft, quadTree2.topLeft);
        Node topRight = intersect(quadTree1.topRight, quadTree2.topRight);
        Node bottomLeft = intersect(quadTree1.bottomLeft, quadTree2.bottomLeft);
        Node bottomRight = intersect(quadTree1.bottomRight, quadTree2.bottomRight);
        if (
                topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf
        ) {
            int count = 0;
            count += topLeft.val ? 1 : -1;
            count += topRight.val ? 1 : -1;
            count += bottomLeft.val ? 1 : -1;
            count += bottomRight.val ? 1 : -1;
            if (count == 4 || count == -4) return topLeft;
        }
        return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
    }
}
