package org.learn.coursera.outline.week4.mincut;

import org.junit.jupiter.api.Test;
import org.learn.coursera.datastructures.graph.AdjacencyListGraph;
import org.learn.coursera.datastructures.graph.Graph;
import org.learn.coursera.outline.TestUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountMinCutTest {

    private CountMinCut countMinCut = new CountMinCut();

    private Graph createDummyGraph() {
        final Graph graph = new AdjacencyListGraph();
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
        Graph graph = TestUtils.readGraph("week4/kargerMinCut.txt");
        final int count = countMinCut.count(graph);
        // should be ~ 17
        System.out.println(count);
    }
}
