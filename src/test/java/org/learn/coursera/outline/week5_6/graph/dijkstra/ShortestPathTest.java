package org.learn.coursera.outline.week5_6.graph.dijkstra;

import org.junit.jupiter.api.Test;
import org.learn.coursera.datastructures.graph.Graph;
import org.learn.coursera.datastructures.graph.impl.Vertex;
import org.learn.coursera.outline.TestUtils;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShortestPathTest {

    final ShortestPath shortestPath = new NaiveShortestPath();

    @Test
    public void testVerySimpleTestCase() {
        final Graph graph = TestUtils.readGraph("week5_6/graph/dijkstra/test_very_simple.txt");

        final String hopDistances = getHopDistances(graph, "s", "s", "v", "w", "t");

        assertEquals("0,1,3,6", hopDistances);
    }

    @Test
    public void testSimpleCase() {
        final Graph graph = TestUtils.readGraph("week5_6/graph/dijkstra/test.txt");

        final String hopDistances = getHopDistances(graph, "1", "1", "2", "3", "4", "5", "6", "7", "8");

        assertEquals("0,1,2,3,4,4,3,2", hopDistances);
    }

    @Test
    public void assignment() {
        final Graph graph = TestUtils.readGraph("week5_6/graph/dijkstra/dijkstra_assignment.txt");

        final String hopDistances = getHopDistances(graph, "1", "7", "37", "59", "82", "99", "115", "133", "165", "188", "197");

        assertEquals("2599,2610,2947,2052,2367,2399,2029,2442,2505,3068", hopDistances);
    }

    private String getHopDistances(final Graph graph, final String sourceVertex, final String... destVertices) {
        return Stream.of(destVertices)
                .map(destVertex -> shortestPath.find(graph,
                    Vertex.getInstance(sourceVertex), Vertex.getInstance(destVertex)))
                .map(String::valueOf)
                .collect(Collectors.joining(","));
    }
}
