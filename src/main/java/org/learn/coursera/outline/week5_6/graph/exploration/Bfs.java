package org.learn.coursera.outline.week5_6.graph.exploration;

import org.learn.coursera.datastructures.graph.Graph;
import org.learn.coursera.datastructures.graph.impl.Vertex;

import java.util.*;

public class Bfs implements Explorator {

    @Override
    public List<Vertex> explore(final Graph graph, final Vertex vertex) {
        if (graph.doesVertexExist(vertex)) {
            return exploreInternal(graph, vertex);
        } else {
            throw new RuntimeException("No such vertex in a graph");
        }
    }

    private List<Vertex> exploreInternal(final Graph graph, final Vertex vertex) {
        final Queue<Vertex> queue = new ArrayDeque<>();
        final Set<Vertex> exploredVertices = new LinkedHashSet<>();

        exploredVertices.add(vertex);
        queue.add(vertex);

        while (!queue.isEmpty()) {
            final Vertex v = queue.poll();
            List<Vertex> outgoingVertices = graph.getOutgoingVertices(v);

            for (Vertex s : outgoingVertices) {
                if (!exploredVertices.contains(s)) {
                    exploredVertices.add(s);
                    queue.add(s);
                }
            }
        }

        return new ArrayList<>(exploredVertices);
    }
}
