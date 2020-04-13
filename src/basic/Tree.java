package basic;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Stack;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Tree<T> {
    int n;
    T[] values;
    Collection<Integer>[] neighbours;

    public Tree(T[] values, Collection<Integer>[] neighbours) {
        this.values = values;
        this.neighbours = neighbours;
        n = values.length;
    }


    public <V> V[] calculateFromChildren(BiFunction<T, Collection<V>, V> combiner, Function<T, V> leafFunction, Class<V[]> clazz) {
        V[] nodeValues = clazz.cast(Array.newInstance(clazz.getComponentType(), n));
        boolean[] seen = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        while (!stack.isEmpty()) {
            int node = stack.peek();
            if (seen[node]) {
                seen[node] = false;
                LinkedList<V> childValues = new LinkedList<>();
                for (int child : neighbours[node]) {
                    if (!seen[child]) childValues.add(nodeValues[child]);
                }
                if (childValues.isEmpty()) nodeValues[node] = leafFunction.apply(values[node]);
                else nodeValues[node] = combiner.apply(values[node], childValues);
                stack.pop();
            } else {
                seen[node] = true;
                for (int child : neighbours[node]) {
                    if (!seen[child]) stack.push(child);
                }
            }
        }
        return nodeValues;
    }
}
