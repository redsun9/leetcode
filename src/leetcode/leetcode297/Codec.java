package leetcode.leetcode297;

import java.util.Iterator;
import java.util.LinkedList;

public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.substring(1);
    }

    private void serialize(TreeNode root, StringBuilder sb) {
        if (root != null) {
            sb.append(',').append(root.val);
            serialize(root.left, sb);
            serialize(root.right, sb);
        } else {
            sb.append(',').append("null");
        }
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<Integer> integers = new LinkedList<>();
        int curPos = 0;
        while (true) {
            int pos = data.indexOf(',', curPos);
            if (pos > 0) {
                integers.add(parse(data.substring(curPos, pos)));
                curPos = pos + 1;
            } else break;
        }
        integers.add(parse(data.substring(curPos)));
        Iterator<Integer> iterator = integers.iterator();
        return deserialize(iterator);
    }

    public TreeNode deserialize(Iterator<Integer> iterator) {
        if (iterator.hasNext()) {
            Integer next = iterator.next();
            if (next != null) {
                TreeNode ans = new TreeNode(next);
                ans.left = deserialize(iterator);
                ans.right = deserialize(iterator);
                return ans;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    private static Integer parse(String str) {
        if (str.equals("null")) return null;
        else return Integer.parseInt(str);
    }
}
