package org.learn.coursera.outline.week5.graph.exploration;

import org.learn.coursera.datastructures.graph.UndirectedGraph;

import java.util.List;

public interface Explorator {

    List<String> explore(final UndirectedGraph graph, final String vertex);
}
