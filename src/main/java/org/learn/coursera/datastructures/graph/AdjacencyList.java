package org.learn.coursera.datastructures.graph;

import java.util.ArrayList;
import java.util.List;

public class AdjacencyList {

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

    public static class Vertex {

        private String name;
        private List<Edge> adjacentEdges = new ArrayList<>();


        public List<Edge> getAdjacentEdges() {
            return adjacentEdges;
        }

        public void setAdjacentEdges(final List<Edge> adjacentEdges) {
            this.adjacentEdges = adjacentEdges;
        }

        public String getName() {
            return name;
        }

        public void setName(final String name) {
            this.name = name;
        }
    }

    public static class Edge {

        private Vertex input;
        private Vertex output;

        public Edge(final Vertex input, final Vertex output) {
            this.input = input;
            this.output = output;
        }

        public Vertex getInput() {
            return input;
        }

        public void setInput(final Vertex input) {
            this.input = input;
        }

        public Vertex getOutput() {
            return output;
        }

        public void setOutput(final Vertex output) {
            this.output = output;
        }
    }
}
