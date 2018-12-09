package org.learn.coursera.outline.week5.graph.sort;

import org.junit.jupiter.api.Test;
import org.learn.coursera.datastructures.graph.Graph;
import org.learn.coursera.datastructures.graph.impl.Vertex;
import org.learn.coursera.outline.TestUtils;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TopologicalSortTest {

    private final TopologicalSort topoSort = new TopologicalSort();

    @Test
    public void test() {
        Graph graph = TestUtils.readGraph("week5/graph/sort/test.txt");
        Map<Vertex, Integer> result = topoSort.sort(graph);

        assertEquals(result.get(Vertex.getInstance("s")), Integer.valueOf(1));
        assertEquals(result.get(Vertex.getInstance("w")), Integer.valueOf(2));
        assertEquals(result.get(Vertex.getInstance("v")), Integer.valueOf(3));
        assertEquals(result.get(Vertex.getInstance("t")), Integer.valueOf(4));
    }
}
