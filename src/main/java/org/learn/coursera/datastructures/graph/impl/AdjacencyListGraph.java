package org.learn.coursera.datastructures.graph.impl;

import org.learn.coursera.datastructures.graph.Graph;

import java.util.*;

public class AdjacencyListGraph implements Graph {

    private final Map<Vertex, List<Vertex>> outgoingVertices = new HashMap<>();
    private final Map<Vertex, List<Vertex>> incomingVertices = new HashMap<>();
    private final HashSet<Vertex> vertices = new HashSet<>();

    @Override
    public void addEdge(final Vertex vertexA, final Vertex vertexB) {
        outgoingVertices.computeIfAbsent(vertexA, key -> new ArrayList<>())
                .add(vertexB);
        incomingVertices.computeIfAbsent(vertexB, key -> new ArrayList<>())
                .add(vertexA);

        vertices.add(vertexA);
        vertices.add(vertexB);
    }

    @Override
    public void addEdge(final String vertexA, final String vertexB) {
        addEdge(Vertex.getInstance(vertexA), Vertex.getInstance(vertexB));
    }

    @Override
    public List<Vertex> getOutgoingVertices(final Vertex vertex) {
        return outgoingVertices.getOrDefault(vertex, Collections.emptyList());
    }

    @Override
    public List<Vertex> getIncomingVertices(Vertex vertex) {
        return incomingVertices.getOrDefault(vertex, Collections.emptyList());
    }

    @Override
    public List<Vertex> getAllVertices() {
        return new ArrayList<>(outgoingVertices.keySet());
    }

    @Override
    public boolean doesEdgeExist(final Vertex vertexA, final Vertex vertexB) {
        return getOutgoingVertices(vertexA).contains(vertexB);
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
        return vertices.size();
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder();
        for (final Vertex vertex : getAllVertices()) {
            for (final Vertex adjacentVertex : getOutgoingVertices(vertex)) {
                stringBuilder.append(String.format("Edge (%s, %s)", vertex, adjacentVertex) + "\n");
            }
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }
}
