package yandex.cup2021.algo.qual.problemD;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@SuppressWarnings("DuplicatedCode")
public class Solver {
    public static void main(String[] args) {
        List<Integer> ans = new ArrayList<>();
        for (int s = 0; s <= 30; s++) {
            long[] f = new long[1 << s];
            int minVal = 1 << s;
            for (int n = 1, m = 1 << s; m > 0; n <<= 1, m >>>= 1) {
                HashSet<Long> set = new HashSet<>();
                for (int i = 0; i < minVal; i++) f[i] = i + 1;
                int n1 = n, m1 = m;
                while (n1 != 1 || m1 != 1) {
                    if (n1 >= m1) {
                        for (int i1 = 0, i2 = n1 - 1; i1 < i2; i1++, i2--) {
                            for (int j = 0, p1 = i1 * m, p2 = i2 * m; j < m1; j++, p1++, p2++) {
                                f[p1] += f[p2];
                                if (f[p1] > minVal) set.add(f[p1]);
                            }
                        }
                        n1 >>>= 1;
                    } else {
                        for (int i = 0; i < n1; i++) {
                            for (int p1 = i * m, p2 = p1 + m1 - 1; p1 < p2; p1++, p2--) {
                                f[p1] += f[p2];
                                if (f[p1] > minVal) set.add(f[p1]);
                            }
                        }
                        m1 >>>= 1;
                    }
                }
                ans.add(set.size());
            }
        }
        System.out.println(ans);
    }
}
