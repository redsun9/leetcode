package google.kickstart2021.roundF;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

@SuppressWarnings("ConstantConditions")
public class Festival {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTests = Integer.parseInt(scanner.nextLine());
        for (int testIndex = 1; testIndex <= numberOfTests; ++testIndex) {
            String[] parts = scanner.nextLine().split(" ");
            int d = Integer.parseInt(parts[0]);
            int n = Integer.parseInt(parts[1]);
            int k = Integer.parseInt(parts[2]);

            List<Triple> triples = new ArrayList<>(n);


            for (int i = 0; i < n; i++) {
                parts = scanner.nextLine().split(" ");
                Triple triple = new Triple(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2]), i);
                triples.add(triple);
            }

            System.out.println("Case #" + testIndex + ": " + solve(triples, k));
        }
    }

    static long solve(Collection<Triple> triples, int k) {
        PriorityQueue<Triple> startQueue = new PriorityQueue<>(Comparator.<Triple>comparingInt(x -> x.s).thenComparingInt(x -> x.index));
        PriorityQueue<Triple> endQueue = new PriorityQueue<>(Comparator.<Triple>comparingInt(x -> x.e).thenComparingInt(x -> x.index));
        TreeSet<Triple> availableQueue = new TreeSet<>(Comparator.<Triple>comparingInt(x -> -x.h).thenComparingInt(x -> x.index));
        TreeSet<Triple> topQueue = new TreeSet<>(Comparator.<Triple>comparingInt(x -> x.h).thenComparingInt(x -> x.index));

        startQueue.addAll(triples);
        endQueue.addAll(triples);

        long ans = 0;
        long currentSum = 0, currentK = 0;

        while (!startQueue.isEmpty()) {
            int day = endQueue.peek().e;
            while (!startQueue.isEmpty() && startQueue.peek().s <= day) availableQueue.add(startQueue.poll());

            while (!availableQueue.isEmpty() && currentK < k) {
                Triple triple = availableQueue.pollFirst();
                currentSum += triple.h;
                currentK++;
                topQueue.add(triple);
            }

            if (!availableQueue.isEmpty() && !topQueue.isEmpty()) {
                while (availableQueue.first().h > topQueue.first().h) {
                    Triple poll = topQueue.pollFirst();
                    currentSum -= poll.h;
                    availableQueue.add(poll);
                    poll = availableQueue.pollFirst();
                    currentSum += poll.h;
                    topQueue.add(poll);
                }
            }
            ans = Math.max(ans, currentSum);

            while (!endQueue.isEmpty() && endQueue.peek().e == day) {
                Triple poll = endQueue.poll();
                availableQueue.remove(poll);
                if (topQueue.remove(poll)) {
                    currentSum -= poll.h;
                    currentK--;
                }
            }
        }
        return ans;
    }


    static class Triple {
        final int h, s, e, index;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Triple triple = (Triple) o;
            return index == triple.index;
        }

        @Override
        public int hashCode() {
            return Objects.hash(index);
        }

        Triple(int h, int s, int e, int index) {
            this.h = h;
            this.s = s;
            this.e = e;
            this.index = index;
        }
    }

}
