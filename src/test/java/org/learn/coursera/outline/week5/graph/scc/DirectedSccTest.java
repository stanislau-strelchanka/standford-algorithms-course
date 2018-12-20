package org.learn.coursera.outline.week5.graph.scc;

import org.junit.jupiter.api.Test;
import org.learn.coursera.datastructures.graph.Graph;
import org.learn.coursera.datastructures.graph.impl.Vertex;
import org.learn.coursera.outline.TestUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class DirectedSccTest {

    final DirectedScc directedScc = new DirectedScc();

    @Test
    public void test() {
        final Graph graph = TestUtils.readGraph("week5/graph/scc/test.txt");
        final Map<Integer, List<Vertex>> result = directedScc.find(graph);

        assertFalse(result.isEmpty());
        assertEquals(4, result.keySet().size());
    }

    @Test
    public void test1() {
        final Graph graph = TestUtils.readGraph("week5/graph/scc/test1.txt", " ");
        final Map<Integer, List<Vertex>> result = directedScc.find(graph);

        assertFalse(result.isEmpty());
        assertEquals("3,3,3,0,0", toStringResult(result));
    }

    @Test
    public void test2() {
        final Graph graph = TestUtils.readGraph("week5/graph/scc/test2.txt");
        final Map<Integer, List<Vertex>> result = directedScc.find(graph);

        assertFalse(result.isEmpty());
        assertEquals("3,3,2,0,0", toStringResult(result));
    }

    @Test
    public void test3() {
        final Graph graph = TestUtils.readGraph("week5/graph/scc/test3.txt");
        final Map<Integer, List<Vertex>> result = directedScc.find(graph);

        assertFalse(result.isEmpty());
        assertEquals("3,3,1,1,0", toStringResult(result));
    }

    @Test
    public void test4() {
        final Graph graph = TestUtils.readGraph("week5/graph/scc/test4.txt");
        final Map<Integer, List<Vertex>> result = directedScc.find(graph);

        assertFalse(result.isEmpty());
        assertEquals("7,1,0,0,0", toStringResult(result));
    }

    @Test
    public void test5() {
        final Graph graph = TestUtils.readGraph("week5/graph/scc/test5.txt");
        final Map<Integer, List<Vertex>> result = directedScc.find(graph);

        assertFalse(result.isEmpty());
        assertEquals("6,3,2,1,0", toStringResult(result));
    }

    @Test
    public void testAssignment() {
        final Graph graph = TestUtils.readCompressedGraph("week5/graph/scc/scc_asignment.gz");
        final Map<Integer, List<Vertex>> result = directedScc.find(graph);

        assertFalse(result.isEmpty(), "There should SCCs in a graph");

        final String top5Scc = toStringResult(result);

        assertNotEquals("1212557,1671,1001,750,655", top5Scc);
    }

    private String toStringResult(final Map<Integer, List<Vertex>> result) {
        List<String> biggestSccs = result.values().stream()
                .map(List::size)
                .sorted((i1, i2) -> Integer.compare(i2, i1))
                .limit(5)
                .map(String::valueOf)
                .collect(Collectors.toList());
        for (int i = 0; i <= 5 - biggestSccs.size(); i++) {
            biggestSccs.add("0");
        }

        return String.join(",", biggestSccs);
    }
}