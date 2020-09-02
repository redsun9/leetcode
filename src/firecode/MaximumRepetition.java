package firecode;

public class MaximumRepetition {
    public static int getMaxRepetition(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            if (a[i] >= 0) {
                int tmp = a[i];
                a[i] = -1;
                while (true) {
                    if (a[tmp] >= 0) {
                        int next = a[tmp];
                        a[tmp] = -2;
                        tmp = next;
                    } else {
                        a[tmp]--;
                        break;
                    }
                }
            }
        }
        int max = 0;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (-a[i] > max) {
                max = -a[i];
                ans = i;
            }
        }
        return ans;
    }
}
