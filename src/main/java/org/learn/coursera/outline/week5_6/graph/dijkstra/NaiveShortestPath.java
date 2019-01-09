package org.learn.coursera.outline.week5_6.graph.dijkstra;

import org.learn.coursera.datastructures.graph.Graph;
import org.learn.coursera.datastructures.graph.impl.Edge;
import org.learn.coursera.datastructures.graph.impl.Vertex;

import java.util.*;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;

public class NaiveShortestPath implements ShortestPath {

    @Override
    public Integer find(Graph graph, Vertex source, Vertex dest) {
        return new ShortestPathFinder(graph, source, dest).find();
    }

    private static class ShortestPathFinder {

        private final Map<Vertex, Integer> shortestDistances;
        private final Set<Vertex> explored;

        private final Graph graph;
        private final Vertex dest;

        ShortestPathFinder(final Graph graph, final Vertex s, final Vertex dest) {
            shortestDistances = new HashMap<>();
            explored = new HashSet<>();

            shortestDistances.put(s, 0);
            explored.add(s);

            this.dest = dest;
            this.graph = graph;
        }

        Integer find() {
            calculateReachableShortestPathDistances();
            return getDestinationShortestPath();
        }

        private void calculateReachableShortestPathDistances() {
            while (exploreNextVertexToHop());
        }

        private boolean exploreNextVertexToHop() {
            final Entry<Vertex, Integer> nextVertexAndHopCost = nextVertexAndHopCost();

            boolean newVertexExplored = nextVertexAndHopCost.getKey() != null;
            if (newVertexExplored) {
                shortestDistances.put(nextVertexAndHopCost.getKey(), nextVertexAndHopCost.getValue());
                explored.add(nextVertexAndHopCost.getKey());
            }

            return newVertexExplored;
        }

        private Entry<Vertex, Integer> nextVertexAndHopCost() {
            int minHopCost = Integer.MAX_VALUE;
            Vertex nextVertexToHop = null;

            for (final Vertex v : explored) {
                final List<Vertex> outgoingVertices = graph.getOutgoingVertices(v);

                for (final Vertex w : outgoingVertices) {
                    if (!explored.contains(w)) {
                        int currentHopCost = graph.edgeHopCost(new Edge(v, w)) + shortestDistances.get(v);
                        if (minHopCost >= currentHopCost) {
                            nextVertexToHop = w;
                            minHopCost = currentHopCost;
                        }
                    }
                }
            }

            return new SimpleEntry<>(nextVertexToHop, minHopCost);
        }

        private Integer getDestinationShortestPath() {
            return shortestDistances.get(dest);
        }
    }

    //todo get full shortest path chain
    private static final class VertexChain {

        private final Vertex vertex;
        private final VertexChain previousVertex;

        public static VertexChain instance(final Vertex source) {
            return new VertexChain(source);
        }

        private VertexChain(final Vertex source) {
            this.vertex = source;
            this.previousVertex = null;
        }

        private VertexChain(final Vertex source, final VertexChain vertexChain) {
            this.vertex = source;
            this.previousVertex = vertexChain;
        }

        public VertexChain add(final Vertex vertex) {
            return new VertexChain(vertex, this);
        }
    }
}
