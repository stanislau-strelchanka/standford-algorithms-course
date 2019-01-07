package org.learn.coursera.outline.week5_6.graph.dijkstra;

import org.learn.coursera.datastructures.graph.Graph;
import org.learn.coursera.datastructures.graph.impl.Vertex;

public interface ShortestPath {

    void find(final Graph graph, final Vertex source, final Vertex dest);
}
