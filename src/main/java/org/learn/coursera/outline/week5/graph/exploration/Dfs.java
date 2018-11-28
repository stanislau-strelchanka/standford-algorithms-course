package org.learn.coursera.outline.week5.graph.exploration;

import org.learn.coursera.datastructures.graph.Graph;
import org.learn.coursera.datastructures.graph.Vertex;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Dfs implements Explorator {

    public List<Vertex> explore(final Graph graph, final Vertex vertex) {
        if (graph.doesVertexExist(vertex)) {
            return exploreInternal(graph, vertex);
        } else {
            throw new RuntimeException("No such vertex in a graph");
        }
    }

    private List<Vertex> exploreInternal(final Graph graph, Vertex s) {
        final Stack<Vertex> nextVertexToExplore = new Stack<>();
        final Set<Vertex> exploredVertices = new LinkedHashSet<>();

        nextVertexToExplore.push(s);

        while (!nextVertexToExplore.isEmpty()) {
            final Vertex v = nextVertexToExplore.pop();
            exploredVertices.add(v);
            for (final Vertex w : graph.getAdjacentVertices(v)) {
                if (!exploredVertices.contains(w)) {
                    nextVertexToExplore.push(w);
                }
            }
        }

        return new ArrayList<>(exploredVertices);
    }
}
