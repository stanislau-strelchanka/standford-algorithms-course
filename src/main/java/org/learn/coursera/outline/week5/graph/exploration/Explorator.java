package org.learn.coursera.outline.week5.graph.exploration;

import org.learn.coursera.datastructures.graph.Graph;
import org.learn.coursera.datastructures.graph.Vertex;

import java.util.List;

public interface Explorator {

    List<Vertex> explore(final Graph graph, final Vertex vertex);
}
