package org.learn.coursera.outline.week5.graph.exploration;

import org.junit.jupiter.api.Test;
import org.learn.coursera.datastructures.graph.Graph;
import org.learn.coursera.datastructures.graph.impl.Vertex;
import org.learn.coursera.outline.TestUtils;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DfsTest {

    private Explorator explorator = new Dfs();

    @Test
    public void test() {
        final Graph graph = TestUtils.readGraph("week5/graph/exploration/test.txt");

        final List<Vertex> exploredVertices = explorator.explore(graph, Vertex.getInstance("s"));
        System.out.println(exploredVertices);

        assertEquals(new HashSet<>(exploredVertices), new HashSet<>(toVertices("s", "b", "d", "c", "e", "a")));
    }

    @Test
    public void test2() {
        Graph graph = TestUtils.readGraph("week5/graph/exploration/test2.txt");

        final List<Vertex> exploredFromA = explorator.explore(graph, Vertex.getInstance("a"));
        final List<Vertex> exploredFromB = explorator.explore(graph, Vertex.getInstance("b"));
        final List<Vertex> exploredFromS = explorator.explore(graph, Vertex.getInstance("s"));

        assertTrue(exploredFromA.containsAll(toVertices("a", "b", "s")));
        assertTrue(exploredFromB.containsAll(toVertices("a", "b", "s")));
        assertTrue(exploredFromS.containsAll(toVertices("a", "b", "s")));

        final List<Vertex> exploredFromC = explorator.explore(graph, Vertex.getInstance("c"));
        final List<Vertex> exploredFromD = explorator.explore(graph, Vertex.getInstance("d"));
        final List<Vertex> exploredFromE = explorator.explore(graph, Vertex.getInstance("e"));

        assertTrue(exploredFromC.containsAll(toVertices("c", "d", "e")));
        assertTrue(exploredFromD.containsAll(toVertices("c", "d", "e")));
        assertTrue(exploredFromE.containsAll(toVertices("c", "d", "e")));
    }

    private List<Vertex> toVertices(final String... vertices) {
        return Stream.of(vertices).map(Vertex::getInstance).collect(Collectors.toList());
    }
}
