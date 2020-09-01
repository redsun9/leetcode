package firecode;

public class PathNumber {
    public int countPaths(int m, int n) {
        long ans = 1;
        int a = m + n - 1;
        int b = Math.min(m, n) - 1;
        for (int i = 1; i <= b; i++) {
            ans = ans * (a - i) / i;
        }
        return (int) ans;
    }
}
