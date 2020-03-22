package atcoder.agc043;

import java.util.Scanner;

public class ProblemB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        if (n == 1) {
            System.out.println(scanner.nextInt());
            return;
        }
        char[] chars = scanner.nextLine().toCharArray();
        int[] a = new int[n - 1];
        for (int i = 1; i < n; i++) {
            a[i - 1] = Math.abs(chars[i] - chars[i - 1]);
        }
        if (n == 2) {
            System.out.println(a[0]);
            return;
        }
        ;
        System.out.println(solution(a));
    }

    public static int solution(int[] a) {
        int n = a.length;
        if (!findParity(a)) return 1;
        for (int i = 0; i < n; i++) {
            if (a[i] == 1) return 0;
            a[i] /= 2;
        }
        if (findParity(a)) return 0;
        else return 2;
    }

    //true - четнео, афдыу - нечетно
    private static boolean findParity(int[] a) {
        int n = a.length;
        int ans = a[0] ^ a[n - 1];
        int pow = 0;
        for (int i = 1; i < n - 1; i++) {
            if ((i & 1) == 0) {
                int c = 0;
                int t = i;
                while ((t & 1) == 0) {
                    t >>= 1;
                    c++;
                }
                pow -= c;
            }
            if (((n - i) & 1) == 0) {
                int c = 0;
                int t = n - i;
                while ((t & 1) == 0) {
                    t >>= 1;
                    c++;
                }
                pow += c;
            }
            if (pow == 0) {
                ans = ans ^ a[i];
            }
        }
        return (ans & 1) == 0;
    }
}
