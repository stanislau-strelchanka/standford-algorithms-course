package org.learn.coursera.outline.week4.mincut;

import org.learn.coursera.datastructures.graph.impl.Vertex;
import org.learn.coursera.datastructures.graph.impl.AdjacencyListGraph;
import org.learn.coursera.datastructures.graph.impl.Edge;
import org.learn.coursera.datastructures.graph.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CountMinCut {

    public int count(final Graph originalGraph) {
        final int tries = (int)Math.pow(originalGraph.order(), 1);

        int count = Integer.MAX_VALUE;

        for (int i = 0; i < tries; i++) {
            int currentCount = countSingleTime(originalGraph);
            if (count > currentCount) {
                count = currentCount;
            }
        }

        return count;
    }

    private int countSingleTime(final Graph originalGraph) {
        Graph cutGraph = copyGraph(originalGraph);
        while (cutGraph.order() > 2) {
            final Edge edge = nextRandomEdge(cutGraph);
            final Vertex vertexToDelete = edge.getFirstVertex();
            final Vertex vertexToShrink = edge.getSecondVertex();

            final Graph currentGraph = new AdjacencyListGraph();

            final List<Vertex> allVertices = new ArrayList<>(cutGraph.getAllVertices());
            allVertices.remove(vertexToDelete);

            for (final Vertex vertex : allVertices) {
                for (final Vertex adjacentVertex : cutGraph.getOutgoingVertices(vertex)) {
                    if (adjacentVertex.equals(vertexToDelete) && !vertex.equals(vertexToShrink)) {
                        currentGraph.addEdge(vertex, vertexToShrink);
                        currentGraph.addEdge(vertexToShrink, vertex);
                    } else if(!adjacentVertex.equals(vertexToDelete) && !vertex.equals(adjacentVertex)){
                        currentGraph.addEdge(vertex, adjacentVertex);
                    }
                }
            }

            cutGraph = currentGraph;
        }

        final Vertex vertex = cutGraph.getAllVertices().get(0);
        return cutGraph.getOutgoingVertices(vertex).size();
    }

    private Graph copyGraph(final Graph graph) {
        final Graph clone = new AdjacencyListGraph();

        for (final Vertex vertex : graph.getAllVertices()) {
            final List<Vertex> adjacentVertices = graph.getOutgoingVertices(vertex);
            for (final Vertex adjacentVertex : adjacentVertices) {
                clone.addEdge(vertex, adjacentVertex);
            }
        }

        return clone;
    }

    private Edge nextRandomEdge(final Graph graph) {
        //todo need one random call
        final int i = new Random(System.currentTimeMillis()).nextInt(graph.order());
        final Vertex vertexOne = graph.getAllVertices().get(i);
        final List<Vertex> adjacentVertices = graph.getOutgoingVertices(vertexOne);
        final Vertex vertexTwo = adjacentVertices.get(new Random(System.currentTimeMillis())
                .nextInt(adjacentVertices.size()));

        return new Edge(vertexOne, vertexTwo);
    }
}
