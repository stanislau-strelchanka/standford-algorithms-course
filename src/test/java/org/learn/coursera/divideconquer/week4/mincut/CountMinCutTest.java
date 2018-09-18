package org.learn.coursera.divideconquer.week4.mincut;

import org.junit.jupiter.api.Test;
import org.learn.coursera.datastructures.graph.AdjacencyListGraph;
import org.learn.coursera.datastructures.graph.UndirectedGraph;
import org.learn.coursera.divideconquer.TestUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountMinCutTest {

    private CountMinCut countMinCut = new CountMinCut();

    private UndirectedGraph createDummyGraph() {
        final UndirectedGraph graph = new AdjacencyListGraph();
        graph.addEdge("1", "2");
        graph.addEdge("1", "4");

        graph.addEdge("2", "1");
        graph.addEdge("2", "3");
        graph.addEdge("2", "4");

        graph.addEdge("3", "2");
        graph.addEdge("3", "4");

        graph.addEdge("4", "1");
        graph.addEdge("4", "2");
        graph.addEdge("4", "3");

        return graph;
    }

    @Test
    public void test() {
        final int count = countMinCut.count(createDummyGraph());

        assertEquals(2, count);
    }

    @Test
    public void testAssignment() {
        UndirectedGraph graph = TestUtils.readGraph("week4/kargerMinCut.txt");
        System.out.println(graph);
    }
}
