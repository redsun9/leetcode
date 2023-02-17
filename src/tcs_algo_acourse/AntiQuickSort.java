package tcs_algo_acourse;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class AntiQuickSort {
    private static final boolean DEBUG = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] ans = generate(n);
        for (int i = 0; i < n; i++) {
            System.out.print(ans[i]);
            System.out.print(' ');
        }
        System.out.println();
//        printWorstCase();
//        debug();
//        checkTest();
    }


    private static int[] generate(int n) {
        if (n == 0) return new int[0];
        if (n == 1) return new int[]{1};
        if (n == 2) return new int[]{1, 2};
        Deque<Integer> firstHalf = new ArrayDeque<>();
        Deque<Integer> secondHalf = new ArrayDeque<>();
        firstHalf.addLast(1);
        secondHalf.addLast(2);
        for (int i = 3; i <= n; i++) {
            if ((i & 1) == 0) secondHalf.addLast(firstHalf.pollLast());
            else secondHalf.addLast(secondHalf.pollFirst());
            firstHalf.addLast(i);
        }
        int[] ans = new int[n];
        int pos = 0;
        while (!firstHalf.isEmpty()) ans[pos++] = firstHalf.pollFirst();
        while (!secondHalf.isEmpty()) ans[pos++] = secondHalf.pollFirst();
        return ans;
    }

    private static void checkTest() {
        int[] expected = {0, 0, 3, 6, 12, 19, 27, 36, 46, 57, 69, 82, 96};
        for (int i = 0; i < expected.length; i++) {
            int[] arr = generate(i);
            System.out.println("i = " + i + ", arr = " + Arrays.toString(arr));
            System.out.println(expected[i] == qsort(arr, 0, i - 1));
        }
    }

    private static long qsort(int[] a, int l, int r) {
        if (r <= l) return 0;
        if (DEBUG) System.out.println("start, a = " + Arrays.toString(a) + ", l = " + l + ", r = " + r);
        int q = a[(l + r) / 2];
        int i = l;
        int j = r;
        long ans = 0;
        while (i <= j) {
            while (true) {
                ans++;
                if (a[i] < q) ++i;
                else break;
            }

            while (true) {
                ans++;
                if (q < a[j]) --j;
                else break;
            }

            if (i <= j) {
                swap(a, i, j);
                ++i;
                --j;
            }
        }

        ans += qsort(a, l, j);
        ans += qsort(a, i, r);
        return ans;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    //0, [1]
    //3, [1, 2]
    //6, [1, 3, 2]
    //12, [1, 4, 2, 3]
    //19, [1, 4, 5, 3, 2]
    //27, [1, 4, 6, 3, 2, 5]
    //36, [1, 4, 6, 7, 2, 5, 3]
    //46, [1, 4, 6, 8, 2, 5, 3, 7]
    //57, [1, 4, 6, 8, 9, 5, 3, 7, 2]
    //69, [1, 4, 6, 8, 10, 5, 3, 7, 2, 9]
    //82, [1, 4, 6, 8, 10, 11, 3, 7, 2, 9, 5]
    //96, [1, 4, 6, 8, 10, 12, 3, 7, 2, 9, 5, 11]
    private static void printWorstCase() {
        int maxN = 12;
        int[] arr = new int[maxN];
        for (int i = 0; i < maxN; i++) arr[i] = i + 1;

        for (int n = 1; n <= maxN; n++) {
            Result ans = dfs(arr, 1, n);
            System.out.println(ans);
        }

    }

    private static void debug() {
        int[] arr = {1, 4, 6, 8, 10, 12, 13, 7, 2, 9, 5, 11, 3};
        qsort(arr, 0, arr.length - 1);
    }

    private static Result dfs(int[] arr, int i, int n) {
        if (i == n) return new Result(qsort(Arrays.copyOf(arr, n), 0, n - 1), Arrays.copyOf(arr, n));
        Result ans = new Result(0, null);
        for (int j = i; j < n; j++) {
            swap(arr, i, j);
            Result tmp = dfs(arr, i + 1, n);
            if (tmp.numberOfComparisons > ans.numberOfComparisons) ans = tmp;
            swap(arr, i, j);
        }
        return ans;
    }

    private record Result(long numberOfComparisons, int[] arr) {
        @Override
        public String toString() {
            return numberOfComparisons + ", " + Arrays.toString(arr);
        }
    }
}
