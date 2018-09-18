package org.learn.coursera.datastructures.graph;

public class Edge {

    final String[] verticesPair;

    public Edge(final String vertex1, final String vertex2) {
        verticesPair = new String[]{vertex1, vertex2};
    }

    public String getFirstVertex() {
        return verticesPair[0];
    }

    public String getSecondVertex() {
        return verticesPair[1];
    }
}
