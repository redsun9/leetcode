package leetcode.leetcode19xx.leetcode1912;

import java.util.*;

public class MovieRentingSystem {
    private static final Comparator<ShopMovieEntry> comparator =
            Comparator.comparingInt((ShopMovieEntry s) -> s.price)
                    .thenComparingInt(s -> s.shop)
                    .thenComparingInt(s -> s.movie);
    private final Map<ShopMovieEntryId, ShopMovieEntry> entryMap;
    private final Map<Integer, SortedSet<ShopMovieEntry>> movieMap;
    private final SortedSet<ShopMovieEntry> rentedSet;

    public MovieRentingSystem(int n, int[][] entries) {
        entryMap = new HashMap<>(entries.length);
        rentedSet = new TreeSet<>(comparator);
        movieMap = new HashMap<>();
        for (int[] arr : entries) {
            ShopMovieEntryId entryId = new ShopMovieEntryId(arr[0], arr[1]);
            ShopMovieEntry entry = new ShopMovieEntry(arr[0], arr[1], arr[2]);
            entryMap.put(entryId, entry);
            movieMap.compute(arr[1], (k, v) -> {
                if (v == null) v = new TreeSet<>(comparator);
                v.add(entry);
                return v;
            });
        }
    }

    public List<Integer> search(int movie) {
        SortedSet<ShopMovieEntry> set = movieMap.get(movie);
        if (set == null) return Collections.emptyList();
        List<Integer> ans = new ArrayList<>(5);
        int counter = 0;
        for (ShopMovieEntry entry : set) {
            ans.add(entry.shop);
            if (++counter == 5) break;
        }
        return ans;
    }

    public void rent(int shop, int movie) {
        ShopMovieEntry entry = entryMap.get(new ShopMovieEntryId(shop, movie));
        movieMap.get(movie).remove(entry);
        rentedSet.add(entry);

    }

    public void drop(int shop, int movie) {
        ShopMovieEntry entry = entryMap.get(new ShopMovieEntryId(shop, movie));
        rentedSet.remove(entry);
        movieMap.get(movie).add(entry);
    }

    public List<List<Integer>> report() {
        List<List<Integer>> ans = new ArrayList<>(5);
        int counter = 0;
        for (ShopMovieEntry entry : rentedSet) {
            ans.add(List.of(entry.shop, entry.movie));
            if (++counter == 5) break;
        }
        return ans;
    }

    private static class ShopMovieEntryId {
        private final int shop, movie;

        public ShopMovieEntryId(int shop, int movie) {
            this.shop = shop;
            this.movie = movie;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ShopMovieEntryId showMovie = (ShopMovieEntryId) o;
            return shop == showMovie.shop && movie == showMovie.movie;
        }

        @Override
        public int hashCode() {
            return Objects.hash(shop, movie);
        }
    }

    private static class ShopMovieEntry {
        private final int shop, movie, price;

        public ShopMovieEntry(int shop, int movie, int price) {
            this.shop = shop;
            this.movie = movie;
            this.price = price;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ShopMovieEntry that = (ShopMovieEntry) o;
            return shop == that.shop && movie == that.movie && price == that.price;
        }

        @Override
        public int hashCode() {
            return Objects.hash(shop, movie, price);
        }
    }
}
