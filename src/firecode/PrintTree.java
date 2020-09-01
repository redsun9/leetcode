package firecode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PrintTree {
    public ArrayList<ArrayList<Integer>> printLevelByLevel(TreeNode root) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        List<TreeNode> current = new LinkedList<>();
        List<TreeNode> next = new LinkedList<>();
        current.add(root);

        while (!current.isEmpty()) {
            ArrayList<Integer> subAns = new ArrayList<>();
            for (TreeNode treeNode : current) {
                subAns.add(treeNode.data);
                if (treeNode.left != null) next.add(treeNode.left);
                if (treeNode.right != null) next.add(treeNode.right);
            }
            ans.add(subAns);
            current = next;
            next = new LinkedList<>();
        }
        return ans;
    }
}
