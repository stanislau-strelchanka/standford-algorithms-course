package org.learn.coursera.divideconquer.week4.mincut;

import org.learn.coursera.datastructures.graph.Graph;

import java.util.List;
import java.util.Random;

public class CountMinCut {

    public int count(final Graph originalGraph) {
        final List<Graph.Edge> edges = originalGraph.deepClone().getEdges();

        Graph graph = null;
        do {
            final int edgeIndex = nextRandomEdgeIndex(edges.size());

            final Graph.Edge edgeToShrink = edges.remove(edgeIndex);
            final String vertexToShrink = edgeToShrink.getVertices()[0].getName();
            final String vertexToDelete = edgeToShrink.getVertices()[1].getName();

            graph = new Graph();
            for (final Graph.Edge edge : edges) {
                final String sourceName = edge.getVertices()[0].getName();
                final String destName = edge.getVertices()[1].getName();

                if (sourceName.equals(vertexToDelete) && !vertexToShrink.equals(destName)) {
                    graph.createEdge(vertexToShrink, destName);
                } else if (destName.equals(vertexToDelete) && !vertexToShrink.equals(sourceName)) {
                    graph.createEdge(vertexToShrink, sourceName);
                } else {
                    graph.createEdge(sourceName, destName);
                }
            }
        } while (graph.getVertices().size() > 2);


        return graph.getEdges().size();
    }

    private int nextRandomEdgeIndex(final int totalEdges) {
        return new Random(System.currentTimeMillis()).nextInt(totalEdges);
    }
}
