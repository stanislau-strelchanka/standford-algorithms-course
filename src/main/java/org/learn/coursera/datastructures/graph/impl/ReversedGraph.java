package org.learn.coursera.datastructures.graph.impl;

import org.learn.coursera.datastructures.graph.Graph;

import java.util.List;

public class ReversedGraph implements Graph {

    private final Graph originalGraph;

    public ReversedGraph(Graph originalGraph) {
        this.originalGraph = originalGraph;
    }

    @Override
    public void addEdge(Vertex vertexA, Vertex vertexB) {
        throw new RuntimeException("Not supported");
    }

    @Override
    public void addEdge(String vertexA, String vertexB) {
        addEdge(Vertex.getInstance(vertexA), Vertex.getInstance(vertexB));
    }

    @Override
    public int size() {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public boolean doesEdgeExist(Vertex vertexA, Vertex vertexB) {
        return originalGraph.getOutgoingVertices(vertexA).contains(vertexB);
    }

    @Override
    public List<Vertex> getOutgoingVertices(Vertex vertex) {
        return originalGraph.getIncomingVertices(vertex);
    }

    @Override
    public List<Vertex> getIncomingVertices(Vertex vertex) {
        return originalGraph.getOutgoingVertices(vertex);
    }

    @Override
    public boolean doesVertexExist(Vertex vertex) {
        return originalGraph.doesVertexExist(vertex);
    }

    @Override
    public List<Vertex> getAllVertices() {
        return originalGraph.getAllVertices();
    }

    @Override
    public int order() {
        return originalGraph.order();
    }

    @Override
    public String toString() {
        return originalGraph.toString();
    }
}
