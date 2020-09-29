package leetcode.leetcode6xx.leetcode677;

import java.util.Stack;

public class MapSum {
    MapSum[] children;
    int value;
    int sum;

    public MapSum() {
    }

    public void insert(String key, int val) {
        MapSum tmp = this;
        Stack<MapSum> stack = new Stack<>();
        for (int i = 0; i < key.length(); i++) {
            stack.push(tmp);
            int c = key.charAt(i) - 'a';
            if (tmp.children == null) tmp.children = new MapSum[26];
            if (tmp.children[c] == null) tmp.children[c] = new MapSum();
            tmp = tmp.children[c];
        }
        int d = val - tmp.value;
        tmp.value = val;
        tmp.sum += d;
        while (!stack.isEmpty()) {
            tmp = stack.pop();
            tmp.sum += d;
        }
    }

    public int sum(String prefix) {
        MapSum tmp = this;
        for (int i = 0; i < prefix.length(); i++) {
            int c = prefix.charAt(i) - 'a';
            if (tmp.children == null || tmp.children[c] == null) return 0;
            tmp = tmp.children[c];
        }
        return tmp.sum;
    }
}
