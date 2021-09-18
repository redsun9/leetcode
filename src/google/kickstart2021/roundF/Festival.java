package google.kickstart2021.roundF;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Integer.parseInt;

@SuppressWarnings("ConstantConditions")
public class Festival {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTests = parseInt(scanner.nextLine());
        for (int testIndex = 1; testIndex <= numberOfTests; ++testIndex) {
            String[] parts = scanner.nextLine().split(" ");
            int d = parseInt(parts[0]);
            int n = parseInt(parts[1]);
            int k = parseInt(parts[2]);

            int[][] attrs = new int[n][];


            for (int i = 0; i < n; i++) {
                parts = scanner.nextLine().split(" ");
                attrs[i] = new int[]{parseInt(parts[0]), parseInt(parts[1]), parseInt(parts[2]), i};
            }

            System.out.println("Case #" + testIndex + ": " + solve(attrs, k));
        }
    }

    static long solve(int[][] attrs, int k) {
        PriorityQueue<int[]> startQueue = new PriorityQueue<>(Comparator.comparingInt(x -> x[1]));
        PriorityQueue<int[]> endQueue = new PriorityQueue<>(Comparator.comparingInt(x -> x[2]));
        TreeSet<int[]> availableQueue = new TreeSet<>(Comparator.<int[]>comparingInt(x -> -x[0]).thenComparingInt(x -> x[3]));
        TreeSet<int[]> topQueue = new TreeSet<>(Comparator.<int[]>comparingInt(x -> x[0]).thenComparingInt(x -> x[3]));

        Collections.addAll(startQueue, attrs);
        Collections.addAll(endQueue, attrs);

        long ans = 0;
        long currentSum = 0, currentK = 0;

        while (!startQueue.isEmpty()) {
            int day = endQueue.peek()[2];
            while (!startQueue.isEmpty() && startQueue.peek()[1] <= day) availableQueue.add(startQueue.poll());

            while (!availableQueue.isEmpty() && currentK < k) {
                int[] poll = availableQueue.pollFirst();
                currentSum += poll[0];
                currentK++;
                topQueue.add(poll);
            }

            if (!availableQueue.isEmpty() && !topQueue.isEmpty()) {
                while (availableQueue.first()[0] > topQueue.first()[0]) {
                    int[] poll = topQueue.pollFirst();
                    currentSum -= poll[0];
                    availableQueue.add(poll);
                    poll = availableQueue.pollFirst();
                    currentSum += poll[0];
                    topQueue.add(poll);
                }
            }
            ans = Math.max(ans, currentSum);

            while (!endQueue.isEmpty() && endQueue.peek()[2] == day) {
                int[] poll = endQueue.poll();
                availableQueue.remove(poll);
                if (topQueue.remove(poll)) {
                    currentSum -= poll[0];
                    currentK--;
                }
            }
        }
        return ans;
    }
}
