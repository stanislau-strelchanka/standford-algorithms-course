package org.learn.coursera.outline.week5.graph.scc;

import org.junit.jupiter.api.Test;
import org.learn.coursera.datastructures.graph.Graph;
import org.learn.coursera.datastructures.graph.impl.Vertex;
import org.learn.coursera.outline.TestUtils;

import java.util.List;
import java.util.Map;

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
    public void testAssignment() {
        final Graph graph = TestUtils.readCompressedGraph("week5/graph/scc/scc_asignment.gz");
        final Map<Integer, List<Vertex>> result = directedScc.find(graph);

        assertFalse(result.isEmpty(), "There should SCCs in a graph");
        System.out.println(result.keySet().size());
    }
}