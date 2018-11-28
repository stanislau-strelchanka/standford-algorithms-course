package org.learn.coursera.outline.week4.mincut;

import org.learn.coursera.datastructures.graph.AdjacencyListGraph;
import org.learn.coursera.datastructures.graph.Edge;
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
            final String vertexToDelete = edge.getFirstVertex();
            final String vertexToShrink = edge.getSecondVertex();

            final Graph currentGraph = new AdjacencyListGraph();

            final List<String> allVertices = new ArrayList<>(cutGraph.getAllVertices());
            allVertices.remove(vertexToDelete);

            for (final String vertex : allVertices) {
                for (final String adjacentVertex : cutGraph.getAdjacentVertices(vertex)) {
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

        final String vertex = cutGraph.getAllVertices().get(0);
        return cutGraph.getAdjacentVertices(vertex).size();
    }

    private Graph copyGraph(final Graph graph) {
        final Graph clone = new AdjacencyListGraph();

        for (final String vertex : graph.getAllVertices()) {
            final List<String> adjacentVertices = graph.getAdjacentVertices(vertex);
            for (final String adjacentVertex : adjacentVertices) {
                clone.addEdge(vertex, adjacentVertex);
            }
        }

        return clone;
    }

    private Edge nextRandomEdge(final Graph graph) {
        //todo need one random call
        final int i = new Random(System.currentTimeMillis()).nextInt(graph.order());
        final String vertexOne = graph.getAllVertices().get(i);
        final List<String> adjacentVertices = graph.getAdjacentVertices(vertexOne);
        final String vertexTwo = adjacentVertices.get(new Random(System.currentTimeMillis())
                .nextInt(adjacentVertices.size()));

        return new Edge(vertexOne, vertexTwo);
    }
}
