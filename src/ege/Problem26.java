package ege;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Problem26 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int totalCost = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int c = scanner.nextInt();
            totalCost += c;
            if (c > 150) pq.offer(c);
        }
        int k = pq.size() / 2;
        int discounted = 0;
        int good = 0;
        while (k-- > 0) {
            good = pq.poll();
            discounted += good;
        }
        totalCost -= discounted / 5;
        System.out.println(totalCost + " " + good);
    }
}
