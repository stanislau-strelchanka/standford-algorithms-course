package org.learn.coursera.outline.week5_6.graph.dijkstra;

import org.learn.coursera.datastructures.graph.Graph;
import org.learn.coursera.datastructures.graph.impl.Vertex;
import org.learn.coursera.datastructures.graph.impl.VertexAndHopCost;

import java.util.List;

public interface ShortestPath {

    Integer find(final Graph graph, final Vertex source, final Vertex dest);
}
