package org.learn.coursera.divideconquer.week4.mincut;

import org.junit.jupiter.api.Test;
import org.learn.coursera.datastructures.graph.Graph;
import org.learn.coursera.divideconquer.TestUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountMinCutTest {

    private CountMinCut countMinCut = new CountMinCut();

    private Graph createDummyGraph() {
        final Graph graph = new Graph();
        graph.createEdge("1", "2");
        graph.createEdge("1", "4");

        graph.createEdge("2", "1");
        graph.createEdge("2", "3");
        graph.createEdge("2", "4");

        graph.createEdge("3", "2");
        graph.createEdge("3", "4");

        graph.createEdge("4", "1");
        graph.createEdge("4", "2");
        graph.createEdge("4", "3");

        return graph;
    }

    @Test
    public void test() {
        final int count = countMinCut.count(createDummyGraph());

        assertEquals(2, count);
    }

    @Test
    public void test2() {
        final Graph graph = createDummyGraph();
        final Graph clone = graph.deepClone();

        assertEquals(graph.getEdges().size(), clone.getEdges().size());
        assertEquals(graph.getVertices().size(), clone.getVertices().size());
    }

    @Test
    public void testAssignment() {
        Graph graph = TestUtils.readGraph("week4/kargerMinCut.txt");
    }
}
