package org.learn.coursera.outline.week5_6.graph.dijkstra;

import org.junit.jupiter.api.Test;
import org.learn.coursera.datastructures.graph.Graph;
import org.learn.coursera.datastructures.graph.impl.Vertex;
import org.learn.coursera.outline.TestUtils;

import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShortestPathTest {

    private ShortestPath shortestPath = (graph, tail, head) -> Collections.emptyList();

    private static final Integer INFINITE_HOP = Integer.MAX_VALUE;

    @Test
    public void test() {
        final Graph graph = TestUtils.readGraph("week5_6/graph/dijkstra/test.txt");

        final String hopDistances = getHopDistances(graph, "1", "1", "2", "3", "4", "5", "6", "7", "8");

        assertEquals("0,1,2,3,4,4,3,2", hopDistances);
    }

    private String getHopDistances(final Graph graph, final String sourceVertex, final String... destVertices) {
        return Stream.of(destVertices)
                .map(destVertex -> shortestPath.find(graph,
                    Vertex.getInstance(sourceVertex), Vertex.getInstance(destVertex)))
                .map(list -> list.isEmpty() ? INFINITE_HOP : list.get(list.size() - 1).getHopCost())
                .map(String::valueOf)
                .collect(Collectors.joining(","));
    }
}
