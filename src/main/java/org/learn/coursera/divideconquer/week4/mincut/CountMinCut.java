package org.learn.coursera.divideconquer.week4.mincut;

import org.learn.coursera.datastructures.graph.AdjacencyListGraph;
import org.learn.coursera.datastructures.graph.Edge;
import org.learn.coursera.datastructures.graph.UndirectedGraph;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CountMinCut {

    public int count(final UndirectedGraph originalGraph) {
        UndirectedGraph cutGraph = copyGraph(originalGraph);
        while (cutGraph.order() > 2) {
            final Edge edge = nextRandomEdge(cutGraph);
            final String vertexToDelete = edge.getFirstVertex();
            final String vertexToShrink = edge.getSecondVertex();

            final UndirectedGraph currentGraph = new AdjacencyListGraph();

            final List<String> allVertices = new ArrayList<>(cutGraph.getAllVertices());
            allVertices.remove(vertexToDelete);

            for (final String vertex : allVertices) {
                for (final String adjacentVertex : cutGraph.getAdjacentVertices(vertex)) {
                    if (adjacentVertex.equals(vertexToDelete) && !vertex.equals(vertexToShrink)) {
                        currentGraph.addEdge(vertex, vertexToShrink);
                    } else {
                        currentGraph.addEdge(vertex, adjacentVertex);
                    }
                }
            }

            cutGraph = currentGraph;
        }

        final String vertex = cutGraph.getAllVertices().get(0);
        return cutGraph.getAdjacentVertices(vertex).size();
    }

    private UndirectedGraph copyGraph(final UndirectedGraph graph) {
        final UndirectedGraph clone = new AdjacencyListGraph();

        for (final String vertex : graph.getAllVertices()) {
            final List<String> adjacentVertices = graph.getAdjacentVertices(vertex);
            for (final String adjacentVertex : adjacentVertices) {
                clone.addEdge(vertex, adjacentVertex);
            }
        }

        return clone;
    }

    private Edge nextRandomEdge(final UndirectedGraph graph) {
        final int i = new Random(System.currentTimeMillis()).nextInt(graph.order());
        final String vertexOne = graph.getAllVertices().get(i);
        final List<String> adjacentVertices = graph.getAdjacentVertices(vertexOne);
        final String vertexTwo = adjacentVertices.get(new Random(System.currentTimeMillis())
                .nextInt(adjacentVertices.size()));

        return new Edge(vertexOne, vertexTwo);
    }

}
