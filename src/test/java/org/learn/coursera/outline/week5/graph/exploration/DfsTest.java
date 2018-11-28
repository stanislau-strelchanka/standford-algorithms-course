package org.learn.coursera.outline.week5.graph.exploration;

import org.junit.jupiter.api.Test;
import org.learn.coursera.datastructures.graph.AdjacencyListGraph;
import org.learn.coursera.datastructures.graph.UndirectedGraph;
import org.learn.coursera.outline.TestUtils;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DfsTest {

    private Explorator explorator = new Dfs();

    @Test
    public void test() {
        UndirectedGraph graph = TestUtils.readGraph("week5/graph/exploration/test.txt");

        final List<String> exploredVertices = explorator.explore(graph, "s");
        System.out.println(exploredVertices);
        assertTrue(exploredVertices.containsAll(Arrays.asList("s", "b", "d", "c", "e", "a")));
    }

    @Test
    public void test2() {
        UndirectedGraph graph = TestUtils.readGraph("week5/graph/exploration/test2.txt");

        final List<String> exploredFromA = explorator.explore(graph, "a");
        final List<String> exploredFromB = explorator.explore(graph, "b");
        final List<String> exploredFromS = explorator.explore(graph, "s");

        assertTrue(exploredFromA.containsAll(Arrays.asList("a", "b", "s")));
        assertTrue(exploredFromB.containsAll(Arrays.asList("a", "b", "s")));
        assertTrue(exploredFromS.containsAll(Arrays.asList("a", "b", "s")));

        final List<String> exploredFromC = explorator.explore(graph, "c");
        final List<String> exploredFromD = explorator.explore(graph, "d");
        final List<String> exploredFromE = explorator.explore(graph, "e");

        assertTrue(exploredFromC.containsAll(Arrays.asList("c", "d", "e")));
        assertTrue(exploredFromD.containsAll(Arrays.asList("c", "d", "e")));
        assertTrue(exploredFromE.containsAll(Arrays.asList("c", "d", "e")));
    }
}
