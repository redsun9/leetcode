package other;

import java.util.*;

public class Order {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = Integer.parseInt(scanner.nextLine());
        for (int t = 0; t < x; t++) {
            String[] split = scanner.nextLine().split(" ");
            int n = Integer.parseInt(split[0]);
            int k = Integer.parseInt(split[1]);
            int f = Integer.parseInt(split[2]);
            HashMap<String, Integer> ingredientMap = new HashMap<>();
            List<String> ingredientNames = new ArrayList<>();
            HashMap<Integer, Long> needed = new HashMap<>();
            HashMap<Integer, Long> ingredientUsed = new HashMap<>();

            for (int i = 0; i < n; i++) {
                String[] s = scanner.nextLine().split(" ");
                int ingredientId = getIdForIngredient(s[0], ingredientMap, ingredientNames);
                needed.put(ingredientId, needed.getOrDefault(ingredientId, 0L) + Long.parseLong(s[1]));
            }
            HashMap<Integer, List<Ingredient>> cookbook = new HashMap<>();
            for (int i = 0; i < k; i++) {
                String[] s = scanner.nextLine().split(" ");
                int dishId = getIdForIngredient(s[0], ingredientMap, ingredientNames);
                int numberOfParts = Integer.parseInt(s[1]);
                List<Ingredient> ingredients = new ArrayList<>(numberOfParts);
                for (int j = 0; j < numberOfParts; j++) {
                    String[] s2 = scanner.nextLine().split(" ");
                    int ingredientId = getIdForIngredient(s2[0], ingredientMap, ingredientNames);
                    ingredients.add(new Ingredient(ingredientId, Long.parseLong(s2[1])));
                    ingredientUsed.put(ingredientId, ingredientUsed.getOrDefault(ingredientId, 0L) + 1);
                }
                cookbook.put(dishId, ingredients);
            }
            HashMap<Integer, Long> reserved = new HashMap<>();
            for (int i = 0; i < f; i++) {
                String[] s = scanner.nextLine().split(" ");
                int ingredientId = getIdForIngredient(s[0], ingredientMap, ingredientNames);
                reserved.put(ingredientId, reserved.getOrDefault(ingredientId, 0L) + Long.parseLong(s[1]));
            }

            SortedMap<String, Long> ans = new TreeMap<>();

            //делаем обход с корней (у них нет предков)
            Queue<Integer> queue = new ArrayDeque<>(ingredientNames.size());
            for (int i = 0; i < ingredientNames.size(); i++) {
                if (!ingredientUsed.containsKey(i)) queue.add(i);
            }
            while (!queue.isEmpty()) {
                Integer poll = queue.poll();
                if (needed.containsKey(poll)) {
                    long stillNeeded = needed.get(poll) - reserved.getOrDefault(poll, 0L);
                    if (stillNeeded > 0) {
                        if (cookbook.containsKey(poll)) {
                            for (Ingredient ingredient : cookbook.get(poll)) {
                                needed.put(
                                        ingredient.ingredientId, needed.getOrDefault(ingredient.ingredientId, 0L)
                                                + stillNeeded * ingredient.ingredientAmount
                                );
                            }
                        } else {
                            ans.put(ingredientNames.get(poll), stillNeeded);
                        }
                    }
                }
                if (cookbook.containsKey(poll)) {
                    for (Ingredient ingredient : cookbook.get(poll)) {
                        if (ingredientUsed.compute(
                                ingredient.ingredientId,
                                (key, oldValue) -> oldValue == 1 ? null : oldValue - 1
                        ) == null) queue.add(ingredient.ingredientId);
                    }
                }
            }
            ans.forEach((name, amount) -> System.out.println(name + " " + amount));
        }
    }

    private static int getIdForIngredient(String name, Map<String, Integer> ingredientMap, List<String> ingredientNames) {
        if (ingredientMap.containsKey(name)) {
            return ingredientMap.get(name);
        } else {
            int ingredientId = ingredientNames.size();
            ingredientNames.add(name);
            ingredientMap.put(name, ingredientId);
            return ingredientId;
        }
    }

    private static final class Ingredient {
        int ingredientId;
        long ingredientAmount;

        public Ingredient(int ingredientId, long ingredientAmount) {
            this.ingredientId = ingredientId;
            this.ingredientAmount = ingredientAmount;
        }
    }
}
