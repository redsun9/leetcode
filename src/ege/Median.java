package ege;

import java.util.*;

public class Median {
    private static double EPS = 1e-6;

    public static List<Double> solve(double[] arr) {
        int n = arr.length;
        if (n == 0 || n == 1) throw new IllegalArgumentException("All x are solutions");

        Arrays.sort(arr);
        double sum = 0;
        for (double num : arr) sum += num;

        List<Double> ans = new ArrayList<>();

        if (n % 2 == 1) {
            // first case: average = (a[n/2-1]+a[n/2])/2
            double x1 = (arr[n / 2 - 1] + arr[n / 2]) / 2 * (n + 1) - sum;
            if (x1 - arr[n / 2 - 1] < EPS) ans.add(x1);

            // second case: average = (a[n/2+1]+a[n/2])/2
            double x2 = (arr[n / 2 + 1] + arr[n / 2]) / 2 * (n + 1) - sum;
            if (arr[n / 2 - 1] - x2 < EPS) ans.add(x2);

            //third case: average = (a[n/2]+x)/2
            double x3 = (2 * sum - (n + 1) * arr[n / 2]) / (n - 1);
            if (arr[n / 2 - 1] - x3 < EPS && x3 - arr[n / 2 + 1] < EPS) ans.add(x3);
        } else {
            //first case: average = a[n/2-1]
            double x1 = (n + 1) * arr[n / 2 - 1] - sum;
            if (x1 - arr[n / 2 - 1] < EPS) ans.add(x1);

            //second case: average = a[n/2]
            double x2 = (n + 1) * arr[n / 2] - sum;
            if (arr[n / 2] - x2 < EPS) ans.add(x2);

            //third case: average = x
            double x3 = sum / n;
            if (arr[n / 2 - 1] - x3 < EPS && x3 - arr[n / 2] < EPS) ans.add(x3);
        }

        ans.sort(Comparator.naturalOrder());
        double prev = Double.NEGATIVE_INFINITY, curr;
        ListIterator<Double> iterator = ans.listIterator();
        while (iterator.hasNext()) {
            curr = iterator.next();
            if (Math.abs(prev - curr) < EPS) iterator.remove();
            else prev = curr;
        }

        return ans;
    }
}
