package codeforces.contest1324;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ProblemD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            ;
        }
        for (int i = 0; i < n; i++) {
            a[i] -= scanner.nextInt();
        }
        System.out.println(solution(a));
    }

    public static long solution(int[] a) {
        int n = a.length;
        Random random = new Random();
        for (int i = n - 1; i > 0; i--) {
            int pos = random.nextInt(i + 1);
            int temp = a[pos];
            a[pos] = a[i];
            a[i] = temp;
        }
        Arrays.sort(a);
        if (a[0] + a[1] > 0) {
            return ((long) n) * ((long) (n - 1)) / 2;
        }
        ;
        if (a[n - 1] + a[n - 2] <= 0) {
            return 0;
        }
        int left = -1;
        int right = n - 1;
        int tmp = Arrays.binarySearch(a, 1);
        if (tmp < 0) tmp = -tmp - 1;
        while (tmp != 0 && a[tmp - 1] > 0) tmp--;
        long counter = tmp - n;
        int leftElement;
        int rightElement = a[right];
        while (true) {
            while (true) {
                left++;
                if (left == n) return counter / 2;
                leftElement = a[left];
                if (leftElement + rightElement > 0) break;
                counter += n - 1 - right;
            }
            while (true) {
                right--;
                if (right < 0) {
                    counter += ((long) (n - left)) * (long) n;
                    return counter / 2;
                }
                rightElement = a[right];
                if (leftElement + rightElement <= 0) break;
                ;
            }
            counter += n - 1 - right;
        }
    }
}
