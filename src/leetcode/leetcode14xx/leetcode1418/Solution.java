package leetcode.leetcode14xx.leetcode1418;

import java.util.*;

public class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {
        TreeSet<String> tableNames = new TreeSet<>(Comparator.comparingInt(Integer::parseInt));
        TreeSet<String> foodItems = new TreeSet<>();
        HashMap<TableDishPair, Integer> counter = new HashMap<>();
        for (List<String> order : orders) {
            TableDishPair key = new TableDishPair(order.get(1), order.get(2));
            counter.put(key, counter.getOrDefault(key, 0) + 1);
            tableNames.add(order.get(1));
            foodItems.add(order.get(2));
        }
        List<List<String>> ans = new ArrayList<>(tableNames.size() + 1);
        List<String> top = new ArrayList<>(foodItems.size() + 1);
        top.add("Table");
        top.addAll(foodItems);
        ans.add(top);
        for (String tableName : tableNames) {
            List<String> row = new ArrayList<>(foodItems.size() + 1);
            row.add(tableName);
            for (String foodItem : foodItems) {
                row.add(counter.getOrDefault(new TableDishPair(tableName, foodItem), 0).toString());
            }
            ans.add(row);
        }
        return ans;
    }

    private static class TableDishPair {
        String table;
        String foodItem;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TableDishPair that = (TableDishPair) o;
            return table.equals(that.table) &&
                    foodItem.equals(that.foodItem);
        }

        @Override
        public int hashCode() {
            return Objects.hash(table, foodItem);
        }

        public TableDishPair(String table, String foodItem) {
            this.table = table;
            this.foodItem = foodItem;
        }
    }
}
