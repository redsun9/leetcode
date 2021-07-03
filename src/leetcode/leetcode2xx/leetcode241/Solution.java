package leetcode.leetcode2xx.leetcode241;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.function.IntBinaryOperator;

public class Solution {
    public static final int[] catalans = {1, 1, 2, 5, 14, 42, 132, 429, 1430, 4862, 16796, 58786};

    private static AbstractList<Integer> asList(int[] ans) {
        return new AbstractList<>() {
            @Override
            public Integer get(int index) {
                return ans[index];
            }

            @Override
            public int size() {
                return ans.length;
            }
        };
    }

    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> operands = new ArrayList<>();
        List<IntBinaryOperator> operators = new ArrayList<>();
        int length = expression.length();
        int curr = 0;
        for (int i = 0; i < length; i++) {
            char c = expression.charAt(i);
            if (c >= '0' && c <= '9') curr = curr * 10 + c - '0';
            else {
                operands.add(curr);
                curr = 0;
                IntBinaryOperator operator = switch (c) {
                    case '+' -> Integer::sum;
                    case '-' -> (x, y) -> x - y;
                    case '*' -> (x, y) -> x * y;
                    default -> null;
                };
                operators.add(operator);
            }
        }
        operands.add(curr);
        int n = operators.size();
        if (n == 0) return operands;
        int[][][] cache = new int[n + 1][n + 1][];
        for (int i = 0; i <= n; i++) cache[i][i] = new int[]{operands.get(i)};
        for (int d = 1; d <= n; d++) {
            for (int l = 0, r = d; r <= n; l++, r++) {
                int[] list = new int[catalans[d]];
                int pos = 0;
                for (int m = l; m < r; m++) {
                    IntBinaryOperator operator = operators.get(m);
                    for (int left : cache[l][m]) {
                        for (int right : cache[m + 1][r]) {
                            list[pos++] = operator.applyAsInt(left, right);
                        }
                    }
                }
                cache[l][r] = list;
            }
        }
        int[] ans = cache[0][n];
        return asList(ans);
    }
}
