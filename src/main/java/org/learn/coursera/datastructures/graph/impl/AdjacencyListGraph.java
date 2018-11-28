package org.learn.coursera.datastructures.graph.impl;

import org.learn.coursera.datastructures.graph.Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdjacencyListGraph implements Graph {

    private final Map<Vertex, List<Vertex>> adjacencyMap = new HashMap<>();

    @Override
    public void addEdge(final Vertex vertexA, final Vertex vertexB) {
        adjacencyMap.computeIfAbsent(vertexA, key -> new ArrayList<>())
                .add(vertexB);
    }

    @Override
    public void addEdge(final String vertexA, final String vertexB) {
        addEdge(Vertex.getInstance(vertexA), Vertex.getInstance(vertexB));
    }

    @Override
    public List<Vertex> getAdjacentVertices(final Vertex vertex) {
        return adjacencyMap.getOrDefault(vertex, Collections.emptyList());
    }

    @Override
    public List<Vertex> getAllVertices() {
        return new ArrayList<>(adjacencyMap.keySet());
    }

    @Override
    public boolean doesEdgeExist(final Vertex vertexA, final Vertex vertexB) {
        return getAdjacentVertices(vertexA).contains(vertexB);
    }

    @Override
    public boolean doesVertexExist(final Vertex vertex) {
        return getAllVertices().contains(vertex);
    }

    @Override
    public int size() {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public int order() {
        return adjacencyMap.keySet().size();
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder();
        for (final Vertex vertex : getAllVertices()) {
            for (final Vertex adjacentVertex : getAdjacentVertices(vertex)) {
                stringBuilder.append(String.format("Edge (%s, %s)", vertex, adjacentVertex) + "\n");
            }
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }
}
