package org.learn.coursera.outline.week5_6.graph.sort;

import org.learn.coursera.datastructures.graph.Graph;
import org.learn.coursera.datastructures.graph.impl.Vertex;

import java.util.Map;

public interface TopologicalSort {

    Map<Vertex, Integer> sort(Graph graph);
}
