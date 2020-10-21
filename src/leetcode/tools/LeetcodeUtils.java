package leetcode.tools;

import java.util.*;

import static basic.utils.ArrayTools.generateRandomSortedArray;

@SuppressWarnings("ConstantConditions")
public class LeetcodeUtils {
    public static TreeNode initializeTree(Integer[] values) {
        if (values.length == 0) return null;
        TreeNode rootNode = new TreeNode(values[0]);
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(rootNode);
        int i = 1;
        int n = values.length;
        while (i < n) {
            TreeNode node = queue.poll();
            if (values[i] != null) {
                TreeNode leftNode = new TreeNode(values[i]);
                node.left = leftNode;
                queue.add(leftNode);
            }
            i++;
            if (i < n && values[i] != null) {
                TreeNode rightNode = new TreeNode(values[i]);
                node.right = rightNode;
                queue.add(rightNode);
            }
            i++;
        }
        return rootNode;
    }

    public static ListNode initializeList(int[] values) {
        ListNode node = null;
        for (int i = values.length - 1; i >= 0; i--) {
            node = new ListNode(values[i], node);
        }
        return node;
    }

    public static List<Integer> getInOrderValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.empty()) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.pop();
            ans.add(root.val);
            root = root.right;
        }
        return ans;
    }

    public static List<Integer> getPostOrderValues(TreeNode root) {
        LinkedList<Integer> ans = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) {
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                if (node.left != null)
                    stack.add(node.left);
                if (node.right != null)
                    stack.add(node.right);
                ans.addFirst(node.val);
            }
        }
        return ans;
    }

    public static TreeNode generateBalancedTree(int minValue, int maxValue, int length, Random random) {
        return dfsBalanced(generateRandomSortedArray(minValue, maxValue, length, random), 0, length);
    }

    private static TreeNode dfsBalanced(int[] nums, int lo, int hi) {
        if (lo >= hi) return null;
        int mid = (lo + hi) / 2;
        return new TreeNode(nums[mid], dfsBalanced(nums, lo, mid), dfsBalanced(nums, mid + 1, hi));
    }

    public static TreeNode generateDegenerateTree(int minValue, int maxValue, int length, Random random) {
        return dfsDegenerated(generateRandomSortedArray(minValue, maxValue, length, random), random);
    }

    private static TreeNode dfsDegenerated(int[] nums, Random random) {
        int n = nums.length;
        if (n == 0) return null;
        TreeNode ans = new TreeNode(nums[nums.length - 1] + 1);
        int lo = 0, hi = n - 1;
        TreeNode parent = ans;
        while (lo <= hi) {
            TreeNode child;
            if (random.nextBoolean()) {
                child = new TreeNode(nums[hi--]);
            } else {
                child = new TreeNode(nums[lo++]);
            }
            if (child.val > parent.val) parent.right = child;
            else parent.left = child;
            parent = child;
        }
        return ans.left;
    }

    public static TreeNode generateRandomTree(int minValue, int maxValue, int length, Random random) {
        return dfsRandom(generateRandomSortedArray(minValue, maxValue, length, random), 0, length, random);
    }

    private static TreeNode dfsRandom(int[] nums, int lo, int hi, Random random) {
        if (lo >= hi) return null;
        int mid = lo + random.nextInt(hi - lo);
        return new TreeNode(nums[mid], dfsBalanced(nums, lo, mid), dfsBalanced(nums, mid + 1, hi));
    }
}
