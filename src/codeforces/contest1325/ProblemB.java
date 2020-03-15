package codeforces.contest1325;

import java.util.HashSet;
import java.util.Scanner;

public class ProblemB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        HashSet<Integer> hashSet = new HashSet<>(30000);
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            for (int j = 0; j < n; j++) {
                hashSet.add(scanner.nextInt());
            }
            System.out.println(hashSet.size());
            hashSet.clear();
        }
    }
}
