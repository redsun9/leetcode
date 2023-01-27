package help_requests.trading_stats;

import java.util.HashMap;
import java.util.Map;


//O(maxK) - adding, O(k) - getting top k
public class Trading3 {
    private final Map<String, Integer> map = new HashMap<>();
    private final int maxK;
    private final String[] max;
    private final int[] maxAmount;

    public Trading3(int maxK) {
        this.maxK = maxK;
        this.max = new String[maxK + 1];
        this.maxAmount = new int[maxK + 1];

    }

    private void add(String name, int amount) {
        int newVal = map.compute(name, (k, v) -> v == null ? amount : v + amount);
        int i = 0;
        while (i < maxK && max[i] != null && !name.equals(max[i])) i++;
        max[i] = name;
        maxAmount[i] = newVal;
        while (i > 0 && compare(max[i - 1], maxAmount[i - 1], max[i], maxAmount[i]) > 0) {
            swap(i - 1, i);
            i--;
        }
    }

    private void swap(int i, int j) {
        String temp = max[i];
        max[i] = max[j];
        max[j] = temp;
        int tempAmount = maxAmount[i];
        maxAmount[i] = maxAmount[j];
        maxAmount[j] = tempAmount;
    }

    private int compare(String s1, int amount1, String s2, int amount2) {
        if (amount1 != amount2) return amount2 - amount1;
        return s1.compareTo(s2);
    }

    public void add(Listing listing) {
        add(listing.name(), listing.amount());
    }

    public Listing[] getTop(int k) {
        if (k > maxK) throw new IllegalArgumentException("k > MAX_K");
        if (k <= 0) throw new IllegalArgumentException("k <= 0");
        Listing[] top = new Listing[k];
        for (int i = 0; i < k; i++) top[i] = new Listing(max[i], maxAmount[i]);
        return top;
    }
}
