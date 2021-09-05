package leetcode.leetcode19xx.leetcode1993;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

// O(1) - lock
// O(1) - unlock
// O(n) - upgrade

@SuppressWarnings("unchecked")
public class LockingTree {
    private final int[] lockedBy;
    private final int[] parent;
    private final List<Integer>[] adj;
    private final int n;

    public LockingTree(int[] parent) {
        this.parent = parent;
        this.n = parent.length;
        this.lockedBy = new int[n];
        this.adj = new List[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int i = 1; i < n; i++) adj[parent[i]].add(i);
    }

    public boolean lock(int num, int user) {
        if (lockedBy[num] != 0) return false;
        lockedBy[num] = user;
        return true;
    }

    public boolean unlock(int num, int user) {
        if (lockedBy[num] != user) return false;
        lockedBy[num] = 0;
        return true;
    }

    public boolean upgrade(int num, int user) {
        int tmp = num;
        while (tmp != -1) {
            if (lockedBy[tmp] != 0) return false;
            tmp = parent[tmp];
        }

        boolean hasLockedChild = false;
        Queue<Integer> queue = new ArrayDeque<>(adj[num]);

        while (!queue.isEmpty()) {
            tmp = queue.poll();
            if (lockedBy[tmp] != 0) {
                lockedBy[tmp] = 0;
                hasLockedChild = true;
            }
            queue.addAll(adj[tmp]);
        }

        if (hasLockedChild) lockedBy[num] = user;
        return hasLockedChild;
    }
}
