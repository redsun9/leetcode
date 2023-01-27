package help_requests.trading_stats;

import java.util.*;

// O(log(n)) - adding, O(k) - getting top k
public class Trading2 {
    private final static Comparator<ListingNode> comparator = Comparator.comparingInt(ListingNode::getAmount).reversed()
            .thenComparing(ListingNode::getName);
    private final Map<String, ListingNode> map = new HashMap<>();
    private final SortedSet<ListingNode> set = new TreeSet<>(comparator);


    private void add(String name, int amount) {
        ListingNode node = map.get(name);
        if (node == null) {
            node = new ListingNode(name);
            node.amount = amount;
            map.put(name, node);
            set.add(node);
        } else {
            set.remove(node);
            node.amount += amount;
            set.add(node);
        }
    }

    public void add(Listing listing) {
        add(listing.name(), listing.amount());
    }

    public Listing[] getTop(int n) {
        n = Math.min(n, map.size());
        Listing[] top = new Listing[n];
        Iterator<ListingNode> iterator = set.iterator();
        for (int i = 0; i < n; i++) {
            ListingNode node = iterator.next();
            top[i] = new Listing(node.name, node.amount);
        }
        return top;
    }


    private static class ListingNode {
        final String name;
        int amount;

        private ListingNode(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public int getAmount() {
            return amount;
        }
    }
}
