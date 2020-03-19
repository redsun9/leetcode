package basic;

public class Knapsack {
    private static int maxBag(
            int[][] goods, int[] costs,
            int[] supply, final int i
    ) {
        if (i >= goods.length) return 0;
        int max = Integer.MAX_VALUE;
        for (int j = 0; j < supply.length; j++) {
            if (goods[i][j] != 0) max = Math.min(max, supply[j] / goods[i][j]);
        }
        if (i == goods.length - 1) return costs[i] * max;
        int k = 0;
        int res = 0;
        while (true) {
            res = Math.max(res, costs[i] * k + maxBag(goods, costs, supply, i + 1));
            if (k == max) {
                if (k != 0) {
                    for (int j = 0; j < supply.length; j++) {
                        supply[j] += goods[i][j] * k;
                    }
                }
                break;
            } else {
                k++;
                for (int j = 0; j < supply.length; j++) {
                    supply[j] -= goods[i][j];
                }
            }
        }
        return res;
    }
}
