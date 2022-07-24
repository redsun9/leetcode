package leetcode.leetcode23xx.leetcode2353;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class FoodRatings {
    private final Map<String, Food> map = new HashMap<>();
    private final Map<String, TreeSet<Food>> sets = new HashMap<>();

    public FoodRatings(String[] foodNames, String[] foodCuisines, int[] foodRatings) {
        int n = foodNames.length;
        for (int i = 0; i < n; i++) {
            Food food = new Food(foodNames[i], foodCuisines[i], foodRatings[i]);
            map.put(food.name, food);
            sets.computeIfAbsent(food.cuisine, key -> new TreeSet<>(
                    Comparator.<Food>comparingInt(x -> -x.rating).thenComparing(x -> x.name)
            )).add(food);
        }

    }

    public void changeRating(String foodName, int newRating) {
        Food food = map.get(foodName);
        TreeSet<Food> cuisineTreeSet = sets.get(food.cuisine);
        cuisineTreeSet.remove(food);
        food.rating = newRating;
        cuisineTreeSet.add(food);
    }

    public String highestRated(String cuisine) {
        return sets.get(cuisine).first().name;
    }

    private static class Food {
        String name;
        String cuisine;
        int rating;

        public Food(String name, String cuisine, int rating) {
            this.name = name;
            this.cuisine = cuisine;
            this.rating = rating;
        }
    }
}
