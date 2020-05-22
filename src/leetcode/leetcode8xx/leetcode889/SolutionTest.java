package leetcode.leetcode8xx.leetcode889;

import leetcode.tools.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class SolutionTest {

    @Test
    void test1() {
        int[] pre = {1};
        int[] post = {1};
        TreeNode root = new Solution().constructFromPrePost(pre, post);
        assertNotNull(root);
        assertEquals(1, root.val);
    }

    @Test
    void test2() {
        int[] pre = {1, 2};
        int[] post = {2, 1};
        TreeNode root = new Solution().constructFromPrePost(pre, post);
        assertNotNull(root);
        assertEquals(1, root.val);
    }

    @Test
    void test3() {
        int[] pre = {1, 2, 4, 5, 3};
        int[] post = {4, 5, 2, 3, 1};
        TreeNode root = new Solution().constructFromPrePost(pre, post);
        assertNotNull(root);
        assertEquals(1, root.val);
    }

    @Test
    void test4() {
        int[] pre = {1, 2, 4, 5, 3, 6, 7};
        int[] post = {4, 5, 2, 6, 7, 3, 1};
        TreeNode root = new Solution().constructFromPrePost(pre, post);
        assertNotNull(root);
        assertEquals(1, root.val);

        assertNotNull(root.left);
        assertEquals(2, root.left.val);
        assertNotNull(root.right);
        assertEquals(3, root.right.val);

        assertNotNull(root.left.left);
        assertEquals(4, root.left.left.val);
        assertNotNull(root.left.right);
        assertEquals(5, root.left.right.val);
        assertNotNull(root.right.left);
        assertEquals(6, root.right.left.val);
        assertNotNull(root.right.right);
        assertEquals(7, root.right.right.val);
    }
}