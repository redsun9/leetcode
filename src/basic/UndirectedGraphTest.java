package basic;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UndirectedGraphTest {

    @Test
    void testBcc() {
        UndirectedGraph g = new UndirectedGraph(12);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 4);
        g.addEdge(1, 5);
        g.addEdge(0, 6);
        g.addEdge(5, 6);
        g.addEdge(5, 7);
        g.addEdge(5, 8);
        g.addEdge(7, 8);
        g.addEdge(8, 9);
        g.addEdge(10, 11);
        Set<Set<Integer>> actual = g.bcc().stream().map(HashSet::new).collect(Collectors.toSet());
        Set<Set<Integer>> expected = Set.of(
                Set.of(1, 2, 3, 4),
                Set.of(8, 9),
                Set.of(8, 5, 7),
                Set.of(6, 0, 5, 1),
                Set.of(10, 11)
        );
        assertEquals(expected, actual);

    }
}