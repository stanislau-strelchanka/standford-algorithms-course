package org.learn.coursera.datastructures.graph;

import java.util.List;

public interface Graph {

    boolean doesEdgeExist(final String vertexA, final String vertexB);

    boolean doesVertexExist(final String vertex);

    List<String> getAdjacentVertices(final String vertex);

    List<String> getAllVertices();

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
