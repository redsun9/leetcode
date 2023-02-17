package tcs_algo_acourse;

import java.util.Scanner;

public class BubbleSortIterations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int maxPosOfZero = n - 1;
        boolean[] zeros = new boolean[n];
        System.out.print("1 ");
        for (int i = 1, posOfLastZeroAfterSort = n - 2; i < n; i++, posOfLastZeroAfterSort--) {
            zeros[scanner.nextInt() - 1] = true;
            while (zeros[maxPosOfZero]) maxPosOfZero--;
            System.out.print(maxPosOfZero - posOfLastZeroAfterSort + 1);
            System.out.print(' ');
        }
        System.out.println("1 ");
    }
}
