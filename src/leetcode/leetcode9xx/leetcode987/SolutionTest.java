package leetcode.leetcode9xx.leetcode987;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void verticalTraversal() {
        TreeNode[] treeNodes = new TreeNode[7];
        for (int i = 6; i >= 0; i--) {
            treeNodes[i] = new TreeNode(i + 1);
            if (i * 2 + 1 < 7) treeNodes[i].left = treeNodes[i * 2 + 1];
            if (i * 2 + 2 < 7) treeNodes[i].right = treeNodes[i * 2 + 2];
        }
        Solution solution = new Solution();
        assertEquals(
                Arrays.asList(
                        Collections.singletonList(4),
                        Collections.singletonList(2),
                        Arrays.asList(1, 5, 6),
                        Collections.singletonList(3),
                        Collections.singletonList(7)
                ),
                solution.verticalTraversal(treeNodes[0])
        );
    }


    @Test
    void testPerf() {
        Random random = new Random(0);
        int n = 20;
        int N = (1 << n) - 1;
        TreeNode[] treeNodes = new TreeNode[N];
        for (int i = N - 1; i >= 0; i--) {
            treeNodes[i] = new TreeNode(random.nextInt(1001));
            if (i * 2 + 1 < N) treeNodes[i].left = treeNodes[i * 2 + 1];
            if (i * 2 + 2 < N) treeNodes[i].right = treeNodes[i * 2 + 2];
        }
        Solution solution = new Solution();
        solution.verticalTraversal(treeNodes[0]);
    }
}