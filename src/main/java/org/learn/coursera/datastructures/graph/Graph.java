package org.learn.coursera.datastructures.graph;

import org.learn.coursera.datastructures.graph.impl.Vertex;

import java.util.List;

public interface Graph {

    boolean doesEdgeExist(final Vertex vertexA, final Vertex vertexB);

    boolean doesVertexExist(final Vertex vertex);

    List<Vertex> getOutgoingVertices(final Vertex vertex);

    List<Vertex> getIncomingVertices(final Vertex vertex);

    List<Vertex> getAllVertices();

    void addEdge(final Vertex vertexA, final Vertex vertexB);

    void addEdge(final String vertexA, final String vertexB);

    /**
     * @return number of edges
     */
    int size();

    /**
     * @return number of vertices
     */
    int order();
}
