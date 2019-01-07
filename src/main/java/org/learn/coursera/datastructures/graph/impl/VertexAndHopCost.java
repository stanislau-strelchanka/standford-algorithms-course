package org.learn.coursera.datastructures.graph.impl;

public class VertexAndHopCost {

    private final Vertex vertex;

    private final Integer hopCost;

    public VertexAndHopCost(Vertex vertex) {
        this.vertex = vertex;
        this.hopCost = 1;
    }

    public VertexAndHopCost(final Vertex vertex, final Integer hopCost) {
        this.vertex = vertex;
        this.hopCost = hopCost;
    }

    public Vertex getVertex() {
        return vertex;
    }

    public Integer getHopCost() {
        return hopCost;
    }
}
