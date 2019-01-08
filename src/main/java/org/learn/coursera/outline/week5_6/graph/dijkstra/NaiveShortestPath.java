package org.learn.coursera.outline.week5_6.graph.dijkstra;

import org.learn.coursera.datastructures.graph.Graph;
import org.learn.coursera.datastructures.graph.impl.Edge;
import org.learn.coursera.datastructures.graph.impl.Vertex;

import java.util.*;

public class NaiveShortestPath implements ShortestPath {

    @Override
    public Integer find(Graph graph, Vertex source, Vertex dest) {
        return new Internal(graph, source, dest).find();
    }

    private static class Internal {

        private final Map<Vertex, Integer> dist;
        private final Set<Vertex> explored;

        private final Graph graph;
        private final Vertex dest;

        Internal(final Graph graph, final Vertex source, final Vertex dest) {
            dist = new HashMap<>();
            explored = new HashSet<>();

            dist.put(source, 0);
            explored.add(source);

            this.dest = dest;
            this.graph = graph;
        }

        Integer find() {
            //todo exit in case nothing could be found
            boolean flag = true;

            while (!dist.containsKey(dest)) {
                int minHopCost = Integer.MAX_VALUE;
                Vertex nextVertexToHop = null;

                for (final Vertex v : explored) {
                    final List<Vertex> outgoingVertices = graph.getOutgoingVertices(v);

                    for (final Vertex w : outgoingVertices) {
                        if (!explored.contains(w)) {
                            int currentHopCost = graph.edgeHopCost(new Edge(v, w)) + dist.get(v);
                            if (minHopCost >= currentHopCost) {
                                nextVertexToHop = w;
                                minHopCost = currentHopCost;
                            }
                        }
                    }
                }

                dist.put(nextVertexToHop, minHopCost);
                explored.add(nextVertexToHop);

            }

            return dist.get(dest);
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
