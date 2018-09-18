package org.learn.coursera.datastructures.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdjacencyListGraph implements UndirectedGraph {

    private final Map<String, List<String>> adjacencyMap = new HashMap<>();

    @Override
    public void addEdge(final String vertexA, final String vertexB) {
        adjacencyMap.computeIfAbsent(vertexA, key -> new ArrayList<>())
                .add(vertexB);
    }

    @Override
    public List<String> getAdjacentVertices(final String vertex) {
        return adjacencyMap.getOrDefault(vertex, Collections.emptyList());
    }

    @Override
    public List<String> getAllVertices() {
        return new ArrayList<>(adjacencyMap.keySet());
    }

    @Override
    public boolean doesEdgeExist(final String vertexA, final String vertexB) {
        return getAdjacentVertices(vertexA).contains(vertexB);
    }

    @Override
    public boolean doesVertexExist(final String vertex) {
        return adjacencyMap.containsKey(vertex);
    }

    @Override
    public int countEdges() {
        int totalEdges = 0;
        for (final List<String> value : adjacencyMap.values()) {
            totalEdges += value.size();
        }
        return totalEdges;
    }

    @Override
    public int countVertices() {
        return adjacencyMap.keySet().size();
    }
}
