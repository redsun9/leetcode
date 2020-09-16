package yandex;

public class LightWarrior {
    public int minimumNumberOfHits(int[] goblins, int p, int q) {
        if (goblins == null || goblins.length == 0) return 0;
        if (goblins.length == 1 && p == 0) return -1; // goblin can't be killed
        if (p == 0 && q == 0) return -1; // goblin can't be killed
        if (goblins.length == 1) return (goblins[0] + p - 1) / p; //goblin can only be hit directly

        if (q == 0) {
            int ans = 0;
            for (int goblin : goblins) ans += (goblin + p - 1) / p;
            return ans;
        }

        int max = 0;
        for (int goblin : goblins) max = Math.max(max, goblin);
        if (p == q) {
            return (max + p - 1) / p;
        } else if (p > q) {
            int lo = 1, hi = goblins.length * ((max + p - 1) / p);
            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;
                if (checkTarget(goblins, p, q, mid)) hi = mid;
                else lo = mid + 1;
            }
            return lo;
        } else {
            int lo = 1, hi = goblins.length * ((max + q - 1) / q);
            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;
                if (checkSplash(goblins, p, q, mid)) hi = mid;
                else lo = mid + 1;
            }
            return lo;
        }
    }

    //p>q
    private static boolean checkTarget(int[] goblins, int p, int q, int value) {
        //check if sum minimum needed target hits less or equal to value
        int d = p - q;
        int tmp = value;
        for (int goblin : goblins) {
            int a = goblin - value * q;
            if (a > 0) {
                tmp -= (a + d - 1) / d;
                if (tmp < 0) return false;
            }
        }
        return true;
    }

    //p<q
    private static boolean checkSplash(int[] goblins, int p, int q, int value) {
        //check if sum of maximum needed target hits greater or equal to value
        int d = q - p;
        int tmp = value;
        for (int goblin : goblins) {
            int a = value * q - goblin;
            if (a < 0) return false;
            tmp -= a / d;
        }
        return tmp <= 0;
    }
}
