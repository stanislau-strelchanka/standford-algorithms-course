package org.learn.coursera.outline.week5.graph.exploration;

import org.learn.coursera.datastructures.graph.UndirectedGraph;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Dfs {

    public List<String> explore(final UndirectedGraph graph, final String vertex) {
        if (graph.doesVertexExist(vertex)) {
            return exploreInternal(graph, vertex);
        } else {
            throw new RuntimeException("No such vertex in a graph");
        }
    }

    private List<String> exploreInternal(final UndirectedGraph graph, final String s) {
        final Stack<String> nextVertexToExplore = new Stack<>();
        final Set<String> exploredVertices = new LinkedHashSet<>();

        nextVertexToExplore.push(s);

        while (!nextVertexToExplore.isEmpty()) {
            final String v = nextVertexToExplore.pop();
            exploredVertices.add(v);
            for (final String w : graph.getAdjacentVertices(v)) {
                if (!exploredVertices.contains(w)) {
                    nextVertexToExplore.push(w);
                }
            }
        }

        return new ArrayList<>(exploredVertices);
    }
}
