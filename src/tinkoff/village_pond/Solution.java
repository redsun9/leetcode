package tinkoff.village_pond;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int n = scanner.nextInt();
        int firstVillage = scanner.nextInt();
        if (n == 1) System.out.println(0);
        int prevVillage = firstVillage, nextVillage;

        int ans = 0;
        for (int i = 1; i < n; i++) {
            nextVillage = scanner.nextInt();
            ans = Math.max(ans, nextVillage - prevVillage);
            prevVillage = nextVillage;
        }

        ans = Math.max(ans, firstVillage + k - prevVillage);
        System.out.println(k - ans);
    }
}
