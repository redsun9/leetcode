package help_requests.secure_doors;

public class Solution2 {
    public static int secureWays(int n, int k) {
        int[] prevLocked = new int[k + 1], prevOpen = new int[k + 1], nextLocked = new int[k + 1], nextOpen = new int[k + 1], tmp;
        prevLocked[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                nextLocked[j] = prevLocked[j - 1] + prevOpen[j];
                nextOpen[j] = prevOpen[j] + prevLocked[j];
            }
            nextLocked[0] = prevOpen[0];
            nextOpen[0] = prevLocked[0] + prevOpen[0];

            tmp = prevLocked;
            prevLocked = nextLocked;
            nextLocked = tmp;

            tmp = prevOpen;
            prevOpen = nextOpen;
            nextOpen = tmp;
        }
        return prevLocked[k] + prevOpen[k];
    }
}
