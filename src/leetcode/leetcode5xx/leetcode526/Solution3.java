package leetcode.leetcode5xx.leetcode526;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class Solution3 {
    public long countArrangement(int n) {
        Integer[][] factors = new Integer[n][];
        for (int i = 1; i <= n; i++) {
            List<Integer> arr = new ArrayList<>();
            for (int j = 1; j <= n; j++) {
                if (i % j == 0 || j % i == 0) arr.add(j - 1);
            }
            factors[i - 1] = arr.toArray(new Integer[0]);
        }
        Arrays.sort(factors, Comparator.comparingInt(x -> x.length));
        MyCounter counter = new MyCounter(n, 0, 0, factors, new ConcurrentHashMap<>());
        ForkJoinPool fjp = new ForkJoinPool();
        return fjp.invoke(counter);
    }

    private static class MyCounter extends RecursiveTask<Long> {
        private final int n;
        private final int pos;
        private final long key;
        private final Integer[][] factors;
        private final Map<Long, Long> cache;

        public MyCounter(final int n, final int pos, final long key, final Integer[][] factors, final Map<Long, Long> cache) {
            this.n = n;
            this.pos = pos;
            this.key = key;
            this.factors = factors;
            this.cache = cache;
        }

        @Override
        protected Long compute() {
            if (pos == n) return 1L;
            if (cache.containsKey(key)) return cache.get(key);
            long ans = 0;
            List<MyCounter> subTasks = new LinkedList<>();
            for (Integer factor : factors[pos]) {
                if ((key & (1L << factor)) == 0) {
                    MyCounter task = new MyCounter(n, pos + 1, key | 1L << factor, factors, cache);
                    task.fork();
                    subTasks.add(task);
                }
            }
            for (MyCounter subTask : subTasks) ans += subTask.join();
            cache.put(key, ans);
            return ans;
        }
    }
}
