package help_requests.ege;

import java.util.Arrays;
import java.util.Scanner;

public class Problem27 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] nums = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                nums[i][j] = scanner.nextInt();
            }
        }
        int[] prev = {0, -1, -1, -1};
        int[] next = {-1, -1, -1, -1};

        for (int[] num : nums) {
            Arrays.fill(next, -1);

            for (int i = 0; i < 4; i++) {
                if (prev[i] >= 0) {
                    next[(i + num[0] + num[1]) % 4] = Math.max(next[(i + num[0] + num[1]) % 4], prev[i] + num[0] + num[1]);
                    next[(i + num[0] + num[2]) % 4] = Math.max(next[(i + num[0] + num[2]) % 4], prev[i] + num[0] + num[2]);
                    next[(i + num[1] + num[2]) % 4] = Math.max(next[(i + num[1] + num[2]) % 4], prev[i] + num[1] + num[2]);
                }
            }
            int[] tmp = prev;
            prev = next;
            next = tmp;
        }
        System.out.println(prev[0]);
    }
}
