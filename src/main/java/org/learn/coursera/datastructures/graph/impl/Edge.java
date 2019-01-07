package org.learn.coursera.datastructures.graph.impl;

import java.util.Objects;

public class Edge {

    private final Vertex tail;

    private final Vertex head;

    public Edge(final Vertex tail, final Vertex head) {
        this.tail = tail;
        this.head = head;
    }

    public Vertex getTail() {
        return tail;
    }

    public Vertex getHead() {
        return head;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return Objects.equals(tail, edge.tail) &&
                Objects.equals(head, edge.head);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tail, head);
    }
}
