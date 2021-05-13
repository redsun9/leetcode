package leetcode.leetcode18xx.leetcode1833;

public class Solution2 {
    public int maxIceCream(int[] costs, int coins) {
        int n = costs.length, tmp, node;
        for (int i = 1; i < n; i++) {
            node = i + 1;
            while (node != 1) {
                int parent = node >> 1;
                if (costs[node - 1] < costs[parent - 1]) {
                    tmp = costs[node - 1];
                    costs[node - 1] = costs[parent - 1];
                    costs[parent - 1] = tmp;
                    node = parent;
                } else break;
            }
        }
        int ans = 0;
        while (ans < n && coins >= costs[0]) {
            ans++;
            coins -= costs[0];
            tmp = 1;
            while (true) {
                int leftChild = (tmp << 1);
                int rightChild = (tmp << 1) + 1;
                if (rightChild <= n && costs[rightChild - 1] != 0) {
                    if (costs[rightChild - 1] < costs[leftChild - 1] || costs[leftChild - 1] == 0) {
                        costs[tmp - 1] = costs[rightChild - 1];
                        tmp = rightChild;
                    } else {
                        costs[tmp - 1] = costs[leftChild - 1];
                        tmp = leftChild;
                    }
                } else if (leftChild <= n && costs[leftChild - 1] != 0) {
                    costs[tmp - 1] = costs[leftChild - 1];
                    tmp = leftChild;
                } else {
                    costs[tmp - 1] = 0;
                    break;
                }
            }
        }
        return ans;
    }
}
