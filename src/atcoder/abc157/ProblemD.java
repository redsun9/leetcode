package atcoder.abc157;

import java.util.*;

public class ProblemD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        Collection<Integer>[] friendships = new ArrayList[n];
        Collection<Integer>[] blockships = new HashSet[n];
        for (int i = 0; i < n; i++) {
            friendships[i] = new ArrayList<>();
            blockships[i] = new HashSet<>();
        }
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt() - 1;
            int b = scanner.nextInt() - 1;
            friendships[a].add(b);
            friendships[b].add(a);
        }
        for (int i = 0; i < k; i++) {
            int a = scanner.nextInt() - 1;
            int b = scanner.nextInt() - 1;
            blockships[a].add(b);
            blockships[b].add(a);
        }
        int[] result = getNumberOfProposedFriends(friendships, blockships);
        StringBuilder sb = new StringBuilder();
        sb.append(result[0]);
        for (int i = 1; i < n; i++) {
            sb.append(" ").append(result[i]);
        }
        System.out.println(sb.toString());
    }

    public static int[] getNumberOfProposedFriends(Collection<Integer>[] friendships, Collection<Integer>[] blockships) {
        int n = friendships.length;
        int[] result = new int[n];
        boolean[] marked = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (marked[i]) continue;
            if (friendships[i].isEmpty()) {
                result[i] = 0;
                continue;
            }
            List<Integer> processingQueue = new ArrayList<>();
            processingQueue.add(i);
            HashSet<Integer> nodesOfConnectedComponent = new HashSet<>();
            nodesOfConnectedComponent.add(i);
            for (int j = 0; j < processingQueue.size(); j++) {
                Integer node = processingQueue.get(j);
                if (marked[node]) continue;
                marked[node] = true;
                if (nodesOfConnectedComponent.addAll(friendships[node])) {
                    processingQueue.addAll(friendships[node]);
                }
            }
            int size = nodesOfConnectedComponent.size() - 1;
            nodesOfConnectedComponent.forEach(node -> {
                Collection<Integer> blockship = blockships[node];
                result[node] = (int) (size - friendships[node].size() - blockship.stream().filter(nodesOfConnectedComponent::contains).count());
            });
        }
        return result;
    }
}
