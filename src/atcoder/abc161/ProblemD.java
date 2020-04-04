package atcoder.abc161;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class ProblemD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        Queue<Long> queue = new ArrayDeque<>();
        for (int i = 1; i < 10; i++) {
            queue.add((long) i);
        }
        while (true) {
            Long poll = queue.poll();
            k--;
            if (k == 0) {
                System.out.println(poll);
                return;
            } else {
                Long d = poll % 10;
                if (d > 0) {
                    queue.add(poll * 10 + d - 1);
                }
                queue.add(poll * 10 + d);
                if (d < 9) {
                    queue.add(poll * 10 + d + 1);
                }
            }
        }
    }
}
