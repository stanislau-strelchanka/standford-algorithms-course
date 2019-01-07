package org.learn.coursera.outline.week5_6.graph.sort;

import org.learn.coursera.datastructures.graph.Graph;
import org.learn.coursera.datastructures.graph.impl.Vertex;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RecursiveTopologicalSort implements TopologicalSort{

    public Map<Vertex, Integer> sort(Graph graph) {
        return new DfsTopoRecursive(graph).sort().result();
    }

    public static class DfsTopoRecursive {

        private final Graph graph;
        private int currentLabel;
        private Set<Vertex> exploredVertices = new HashSet<>();
        private Map<Vertex, Integer> vertexToOrder = new HashMap<>();

        public DfsTopoRecursive(final Graph graph) {
            currentLabel = graph.order();
            this.graph = graph;
        }
        
        public DfsTopoRecursive sort() {
            for (Vertex vertex : graph.getAllVertices()) {
                if (!isExplored(vertex)) {
                    exploreAndAssignValue(vertex);
                }
            }
            
            return this;
        }

        private void exploreAndAssignValue(final Vertex vertex) {
            exploredVertices.add(vertex);
            for (final Vertex outgoingVertex : graph.getOutgoingVertices(vertex)) {
                if (!isExplored(outgoingVertex)) {
                    exploreAndAssignValue(outgoingVertex);
                }
            }

            vertexToOrder.put(vertex, currentLabel--);
        }

        private boolean isExplored(final Vertex vertex) {
            return exploredVertices.contains(vertex);
        }
        
        public Map<Vertex, Integer> result() {
            return vertexToOrder;
        }
    }
}
