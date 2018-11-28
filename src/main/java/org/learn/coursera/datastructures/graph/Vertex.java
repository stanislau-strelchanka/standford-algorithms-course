package org.learn.coursera.datastructures.graph;

import java.util.Objects;

public class Vertex {

    private String id;

    public static Vertex getInstance(final String vertex) {
        return new Vertex(vertex);
    }

    public Vertex() {

    }

    private Vertex(final String vertex) {
        this.id = vertex;
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Vertex vertex = (Vertex) o;
        return Objects.equals(id, vertex.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return id;
    }
}
