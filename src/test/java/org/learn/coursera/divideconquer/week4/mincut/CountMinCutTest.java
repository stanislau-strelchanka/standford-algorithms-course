package org.learn.coursera.divideconquer.week4.mincut;

import org.junit.jupiter.api.Test;
import org.learn.coursera.datastructures.graph.Graph;
import org.learn.coursera.divideconquer.TestUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountMinCutTest {

    private CountMinCut countMinCut = new CountMinCut();

    @Test
    public void test() {
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

        final int count = countMinCut.count(graph);

        assertEquals(2, count);
    }

    @Test
    public void test2() {
        Graph graph = TestUtils.readGraph("week4/kargerMinCut.txt");
    }
}
