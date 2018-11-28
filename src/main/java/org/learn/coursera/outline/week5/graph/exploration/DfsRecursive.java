package org.learn.coursera.outline.week5.graph.exploration;

import org.learn.coursera.datastructures.graph.Graph;
import org.learn.coursera.datastructures.graph.impl.Vertex;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class DfsRecursive implements Explorator {

    @Override
    public List<Vertex> explore(final Graph graph, final Vertex vertex) {
        if (graph.doesVertexExist(vertex)) {
            return exploreInternal(graph, vertex);
        } else {
            throw new RuntimeException("No such vertex in a graph");
        }
    }

    private List<Vertex> exploreInternal(final Graph graph, final Vertex vertex) {
        return new InternalRecursiveDfs(graph).explore(vertex).getExploredVertices();
    }

    private static class InternalRecursiveDfs {
        private final Set<Vertex> exploredVertices;
        private final Graph graph;

        private InternalRecursiveDfs(final Graph graph) {
            this.exploredVertices = new LinkedHashSet<>();
            this.graph = graph;
        }

        public InternalRecursiveDfs explore(final Vertex v) {
            exploredVertices.add(v);
            for (final Vertex w : graph.getAdjacentVertices(v)) {
                if (!exploredVertices.contains(w)) {
                    explore(w);
                }
            }
            return this;
        }

        public List<Vertex> getExploredVertices() {
            return new ArrayList<>(exploredVertices);
        }
    }
}
