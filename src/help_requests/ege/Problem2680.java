package help_requests.ege;

import java.util.Scanner;

public class Problem2680 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int ans = 0;
        int prevLenA = 0, prevLenB = 0, curLenA, curLenB;
        int prevA = 0, prevB = 0, currA, currB;
        for (int i = 0; i < n; i++) {
            currA = scanner.nextInt();
            currB = scanner.nextInt();
            curLenA = 1;
            curLenB = 1;
            if (currA == prevB) curLenA = prevLenA + 1;
            if (currA == prevA) curLenA = Math.max(curLenA, prevLenB + 1);

            if (currB == prevB) curLenB = prevLenA + 1;
            if (currB == prevA) curLenB = Math.max(curLenB, prevLenB + 1);

            prevLenA = curLenA;
            prevLenB = curLenB;
            prevA = currA;
            prevB = currB;

            ans = Math.max(ans, prevLenA);
            ans = Math.max(ans, prevLenB);
        }
        System.out.println(ans);
    }
}
