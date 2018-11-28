package org.learn.coursera.datastructures.graph.impl;

public class Edge {

    final Vertex[] verticesPair;

    public Edge(final Vertex vertex1, final Vertex vertex2) {
        verticesPair = new Vertex[]{vertex1, vertex2};
    }

    public Vertex getFirstVertex() {
        return verticesPair[0];
    }

    public Vertex getSecondVertex() {
        return verticesPair[1];
    }
}
