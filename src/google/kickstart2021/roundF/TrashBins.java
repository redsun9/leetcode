package google.kickstart2021.roundF;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class TrashBins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTests = Integer.parseInt(scanner.nextLine());
        for (int testIndex = 1; testIndex <= numberOfTests; ++testIndex) {
            int n = Integer.parseInt(scanner.nextLine());
            String s = scanner.nextLine();
            long ans = 0;
            int previous = -1;
            Queue<Integer> queue = new ArrayDeque<>(n);
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '1') {
                    if (previous == -1) {
                        while (!queue.isEmpty()) ans += i - queue.poll();
                    } else {
                        while (!queue.isEmpty()) {
                            int p = queue.poll();
                            ans += Math.min(i - p, p - previous);
                        }
                    }
                    previous = i;
                } else {
                    queue.offer(i);
                }
            }
            while (!queue.isEmpty()) ans += queue.poll() - previous;
            System.out.println("Case #" + testIndex + ": " + ans);
        }
    }
}
