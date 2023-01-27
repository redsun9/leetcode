package help_requests.trading_stats;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;


// O(1) - adding, O(n*log(k))) - getting top k sorted
public class Trading {
    private final Map<String, Integer> map = new HashMap<>();

    private void add(String name, int amount) {
        map.compute(name, (k, v) -> v == null ? amount : v + amount);
    }

    public void add(Listing listing) {
        add(listing.name(), listing.amount());
    }

    public Listing[] getTop(int k) {
        k = Math.min(k, map.size());
        Listing[] top = new Listing[k];
        PriorityQueue<Listing> queue = new PriorityQueue<>(k,
                Comparator.comparingInt(Listing::amount)
                        .thenComparing(Comparator.comparing(Listing::name).reversed())
        );
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            queue.add(new Listing(entry.getKey(), entry.getValue()));
            if (queue.size() > k) queue.poll();
        }
        for (int i = k - 1; i >= 0; i--) top[i] = queue.poll();
        return top;
    }
}
