package org.learn.coursera.outline.week5.graph.scc;

import org.junit.jupiter.api.Test;
import org.learn.coursera.datastructures.graph.Graph;
import org.learn.coursera.outline.TestUtils;
import sun.security.provider.certpath.Vertex;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class DirectedSccTest {

    final DirectedScc directedScc = new DirectedScc();

    @Test
    public void test() {
        final Graph graph = TestUtils.readCompressedGraph("week5/graph/scc/scc_asignment.gz");
        final Map<Integer, List<Vertex>> result = directedScc.find(graph);

        assertFalse(result.isEmpty(), "There should SCCs in a graph");
    }
}