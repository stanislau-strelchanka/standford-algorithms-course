package org.learn.coursera.datastructures.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Graph {

    private List<Vertex> vertices = new ArrayList<>();
    private List<Edge> edges = new ArrayList<>();

    public List<Vertex> getVertices() {
        return vertices;
    }

    public void setVertices(final List<Vertex> vertices) {
        this.vertices = vertices;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(final List<Edge> edges) {
        this.edges = edges;
    }

    public void createEdge(final String sourceName, final String destName) {
        Edge result = null;
        Vertex source = findOrCreateVertex(sourceName);
        Vertex dest = findOrCreateVertex(destName);
        final Edge edge = new Edge(source, dest);
        Optional<Edge> first = edges.stream()
                .filter(item -> item.containsVertex(edge.vertices[0]) && item.containsVertex(edge.vertices[1]))
                .findFirst();
        if (first.isPresent()) {
            result = first.get();
        } else {
            result = edge;
            edges.add(result);
        }

        source.getAdjacentEdges().add(result);
    }

    public Vertex findOrCreateVertex(final String name) {
        Vertex result = null;
        final Optional<Vertex> first = vertices.stream()
                .filter(item -> Objects.equals(item.getName(), name))
                .findFirst();
        if (first.isPresent()) {
            result = first.get();
        } else {
            result = new Vertex(name);
            vertices.add(result);
        }
        return result;
    }

    public static class Vertex {

        private final String name;
        private List<Edge> adjacentEdges = new ArrayList<>();

        public Vertex(final String name) {
            this.name = name;
        }

        public List<Edge> getAdjacentEdges() {
            return adjacentEdges;
        }

        public void setAdjacentEdges(final List<Edge> adjacentEdges) {
            this.adjacentEdges = adjacentEdges;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public static class Edge {

        private Vertex[] vertices = new Vertex[2];

        public Edge(final Vertex input, final Vertex output) {
            vertices[0] = input;
            vertices[1] = output;
        }

        public boolean containsVertex(final Vertex vertex) {
            return vertices[0].name.equals(vertex.name) || vertices[1].name.equals(vertex.name);
        }

        @Override
        public String toString() {
            return Stream.of(vertices).map(Vertex::getName).collect(Collectors.joining(","));
        }
    }
}
