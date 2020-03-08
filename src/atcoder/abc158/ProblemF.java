package atcoder.abc158;

import basic.IntegerUtils;
import basic.tuples.Pair;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ProblemF {
    private static final int m = 998_244_353;
    private static int[] distanceSet;
    private static int[] nActivated;
    private static int[] nStalled;
    private static int nextPow2;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Pair<Integer, Integer>[] robots = new Pair[n];
        for (int i = 0; i < n; i++) {
            robots[i] = new Pair<>(scanner.nextInt(), scanner.nextInt());
        }
        Arrays.sort(robots, Comparator.comparing(Pair::getA));
        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = robots[i].getA();
        }
        nActivated = new int[n];
        nStalled = new int[n];
        nActivated[n - 1] = 1;
        nStalled[n - 1] = 1;
        nextPow2 = IntegerUtils.nextPow2(n);
        distanceSet = new int[nextPow2 * 2 - 1];
        updateDistances(n - 1, n - 1);
        for (int i = n - 2; i >= 0; i--) {
            if (robots[i].getB() == 1) {
                nActivated[i] = (nActivated[i + 1] + nStalled[i + 1]) % m;
                nStalled[i] = (nActivated[i + 1] + nStalled[i + 1]) % m;
                updateDistances(i, i);
                continue;
            }
            int index = Arrays.binarySearch(x, i, n, x[i] + robots[i].getB() - 1);
            if (index > 0) { //
                int indexOfLastActivated = getDistance(i + 1, index + 1);
                nActivated[i] = nActivated[indexOfLastActivated] % m;
                nStalled[i] = (nActivated[i + 1] + nStalled[i + 1]) % m;
                updateDistances(i, indexOfLastActivated);
            } else {
                index = -(index + 1) - 1;
                if (index == i) {
                    nActivated[i] = (nActivated[i + 1] + nStalled[i + 1]) % m;
                    nStalled[i] = (nActivated[i + 1] + nStalled[i + 1]) % m;
                    updateDistances(i, i);
                } else {
                    int indexOfLastActivated = getDistance(i, index + 1);
                    nActivated[i] = nActivated[indexOfLastActivated] % m;
                    nStalled[i] = (nActivated[i + 1] + nStalled[i + 1]) % m;
                    updateDistances(i, indexOfLastActivated);
                }
            }
        }
        System.out.println((nActivated[0] + nStalled[0]) % m);
    }

    private static int getDistance(int l, int r) {
        return getDistance(0, 0, nextPow2, l, r);
    }

    private static int getDistance(int v, int l, int r, int ql, int qr) {
        if (l >= qr || r <= ql) {
            return Integer.MIN_VALUE;
        }
        if (ql <= l && r <= qr) {
            return distanceSet[v];
        }
        int mid = (l + r) / 2;
        return Math.max(
                getDistance(v * 2 + 1, l, mid, ql, qr),
                getDistance(v * 2 + 2, mid, r, ql, qr)
        );
    }

    private static void updateDistances(int i, int value) {
        i = nextPow2 - 1 + i;
        distanceSet[i] = Math.max(distanceSet[i], value);
        i = (i - 1) >> 1;
        while (i >= 0) {
            distanceSet[i] = Math.max(distanceSet[i * 2 + 1], distanceSet[i * 2 + 2]);
            i = (i - 1) >> 1;
        }
    }
}
