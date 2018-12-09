package org.learn.coursera.outline.week5.graph.scc;

import org.learn.coursera.datastructures.graph.Graph;
import org.learn.coursera.datastructures.graph.impl.ReversedGraph;
import org.learn.coursera.outline.week5.graph.sort.TopologicalSort;
import org.learn.coursera.datastructures.graph.impl.Vertex;

import java.util.*;
import java.util.stream.Collectors;

public class DirectedScc {

    private final TopologicalSort topoSort = new TopologicalSort();
    private final Set<Vertex> explored = new HashSet<>();

    public Map<Integer, List<Vertex>> find(final Graph graph) {
        final Map<Integer, List<Vertex>> result = new HashMap<>();
        final List<Vertex> properlyOrderedVertices = getProperlyOrderedVertices(graph);
        int currentScc = 1;
        for (final Vertex vertex : properlyOrderedVertices) {
            if (!isExplored(vertex)) {
                final List<Vertex> explored = explore(graph, vertex);
                result.put(currentScc++, explored);
            }
        }

        return result;
    }

    private List<Vertex> explore(final Graph graph, final Vertex vertex, final List<Vertex> vertices) {
        explored.add(vertex);
        for (Vertex outgoingVertex : graph.getOutgoingVertices(vertex)) {
            if (!isExplored(outgoingVertex)) {
                vertices.add(outgoingVertex);
                return explore(graph, outgoingVertex, vertices);
            }
        }

        return vertices;
    }

    private List<Vertex> explore(final Graph graph, final Vertex vertex) {
        final List<Vertex> vertices = new ArrayList<>();
        final Stack<Vertex> nextVertexToExplore = new Stack<>();

        nextVertexToExplore.push(vertex);

        while (!nextVertexToExplore.isEmpty()) {
            final Vertex v = nextVertexToExplore.pop();
            explored.add(v);
            vertices.add(v);

            for (final Vertex w : graph.getOutgoingVertices(v)) {
                if (!isExplored(w)) {
                    nextVertexToExplore.push(w);
                }
            }
        }

        return vertices;
    }

    private boolean isExplored(final Vertex vertex) {
        return explored.contains(vertex);
    }

    private List<Vertex> getProperlyOrderedVertices(final Graph graph) {
        final Graph reversedGraph = new ReversedGraph(graph);
        //todo check why starting index is not 0;
        final Map<Vertex, Integer> sortedVertices = topoSort.sort(reversedGraph);
        return sortedVertices.entrySet().stream()
                .sorted(Comparator.comparingInt(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
