package codeforces.contest1305;

import java.util.Scanner;

public class ProblemG {
    private static final int N = 1 << 18;
    private static final int[] p = new int[N];
    private static final int[] cnt = new int[N];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long ans = 0;
        int maxMask = 0;
        int u, v, i, j, sum, tmp, res;
        for (i = 0; i < n; i++) {
            u = scanner.nextInt();
            cnt[u]++;
            ans -= u;
            maxMask |= u;
            p[u] = -1;
        }
        cnt[0]++;
        p[0] = -1;

        for (sum = maxMask; sum >= 0; sum--) {
            for (u = sum; u > 0; u = (u - 1) & sum) {
                v = sum ^ u;
                if (cnt[u] > 0 && cnt[v] > 0) {
                    i = trace(u);
                    j = trace(v);
                    if (i != j) {
                        if (p[i] > p[j]) {
                            tmp = i;
                            i = j;
                            j = tmp;
                        }
                        res = (p[i] == -1 ? cnt[i] : 1) + (p[j] == -1 ? cnt[j] : 1) - 1;
                        p[i] += p[j];
                        p[j] = i;
                        ans += sum * res;
                    }
                }
            }
        }
        System.out.println(ans);
    }


    private static int trace(int i) {
        if (p[i] < 0) return i;
        else {
            p[i] = trace(p[i]);
            return p[i];
        }
    }
}
