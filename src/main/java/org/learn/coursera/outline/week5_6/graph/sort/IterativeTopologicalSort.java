package org.learn.coursera.outline.week5_6.graph.sort;

import org.learn.coursera.datastructures.graph.Graph;
import org.learn.coursera.datastructures.graph.impl.Vertex;

import java.util.*;

// doesn't work with directed scc
public class IterativeTopologicalSort implements TopologicalSort {

    public Map<Vertex, Integer> sort(Graph graph) {
        return new BfsTopoIterative(graph).sort().result();
    }

    public static class BfsTopoIterative {

        private final Graph graph;
        private final Set<Vertex> exploredVertices = new HashSet<>();
        private final Map<Vertex, Integer> vertexToOrder = new HashMap<>();
        private final Queue<Vertex> queue = new ArrayDeque<>();
        private int currentLabel;

        public BfsTopoIterative(final Graph graph) {
            currentLabel = 1;
            this.graph = graph;
        }

        public BfsTopoIterative sort() {
            for (Vertex vertex : graph.getAllVertices()) {
                if (!isExplored(vertex) && isSource(vertex)) {
                    exploreAndAssignValue(vertex);
                }
            }

            return this;
        }

        private void exploreAndAssignValue(final Vertex vertex) {
            markVertexExploredAndAssignOrder(vertex);

            while (!queue.isEmpty()) {
                final Vertex v = queue.poll();
                final List<Vertex> outgoingVertices = graph.getOutgoingVertices(v);

                for (final Vertex s : outgoingVertices) {
                    if (!isExplored(s)) {
                        markVertexExploredAndAssignOrder(s);
                    }
                }
            }

        }

        private void markVertexExploredAndAssignOrder(final Vertex s) {
            exploredVertices.add(s);
            queue.add(s);
            vertexToOrder.put(s, currentLabel++);
        }

        private boolean isSource(final Vertex vertex) {
            return graph.getIncomingVertices(vertex).isEmpty();
        }

        private boolean isExplored(final Vertex vertex) {
            return exploredVertices.contains(vertex);
        }

        public Map<Vertex, Integer> result() {
            return vertexToOrder;
        }
    }
}
