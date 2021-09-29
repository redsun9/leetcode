package basic.utils;

import basic.utils.TreeTools.BstDecreasingIterator;
import basic.utils.TreeTools.BstIncreasingIterator;
import leetcode.tools.LeetcodeUtils;
import leetcode.tools.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TreeToolsTest {

    @Test
    void testBstIncreasingIterator() {
        Integer[] arr = {4, 2, 6, 1, 3, 5, 7};
        TreeNode tree = LeetcodeUtils.initializeTree(arr);
        for (int i = 0; i <= 8; i++) {
            List<Integer> expected = new ArrayList<>();
            for (int j = Math.max(i, 1); j < 8; j++) expected.add(j);

            BstIncreasingIterator iterator = new BstIncreasingIterator(tree, i);
            List<Integer> actual = new ArrayList<>();
            while (!iterator.isEmpty()) {
                actual.add(iterator.peek());
                iterator.pop();
            }
            assertEquals(expected, actual);
        }
    }

    @Test
    void testBstDecreasingIterator() {
        Integer[] arr = {4, 2, 6, 1, 3, 5, 7};
        TreeNode tree = LeetcodeUtils.initializeTree(arr);
        for (int i = 0; i <= 8; i++) {
            List<Integer> expected = new ArrayList<>();
            for (int j = Math.min(i, 7); j >= 1; j--) expected.add(j);
            BstDecreasingIterator iterator = new BstDecreasingIterator(tree, i);
            List<Integer> actual = new ArrayList<>();
            while (!iterator.isEmpty()) {
                actual.add(iterator.peek());
                iterator.pop();
            }
            assertEquals(expected, actual);
        }
    }
}