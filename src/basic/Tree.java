package basic;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Tree<T> {
    int n;
    T[] values;
    Tree<T>[] nodes;
    Collection<Integer>[] neighbours;

    public T val;
    public int index;
    public List<Tree<T>> children;

    public Tree() {
    }

    public Tree(T[] values, Collection<Integer>[] neighbours) {
        this.values = values;
        this.neighbours = neighbours;
        n = values.length;
        nodes = new Tree[n];
        for (int i = 0; i < n; i++) {
            Tree<T> node = new Tree<>();
            node.val = values[i];
            node.index = i;
            nodes[i] = node;
        }
        for (int i = 0; i < n; i++) {
            Tree<T> node = nodes[i];
            node.n = n;
            node.values = values;
            node.nodes = nodes;
            node.neighbours = neighbours;
            node.children = new LinkedList<>();
            for (Integer neighbour : neighbours[i]) {
                node.children.add(nodes[neighbour]);
            }
        }
    }


    public <V> V[] calculateFromChildren(BiFunction<Tree<T>, Collection<V>, V> combiner, Function<T, V> leafFunction, Class<V[]> clazz) {
        V[] nodeValues = clazz.cast(Array.newInstance(clazz.getComponentType(), n));
        boolean[] seen = new boolean[n];
        Stack<Tree<T>> stack = new Stack<>();
        stack.push(this);
        while (!stack.isEmpty()) {
            Tree<T> node = stack.peek();
            if (seen[node.index]) {
                seen[node.index] = false;
                LinkedList<V> childValues = new LinkedList<>();
                for (Tree<T> child : children) {
                    if (!seen[child.index]) childValues.add(nodeValues[child.index]);
                }
                if (childValues.isEmpty()) nodeValues[node.index] = leafFunction.apply(node.val);
                else nodeValues[node.index] = combiner.apply(node, childValues);
                stack.pop();
            } else {
                seen[node.index] = true;
                for (Tree<T> child : children) {
                    if (!seen[child.index]) stack.push(child);
                }
            }
        }
        return nodeValues;
    }
}
