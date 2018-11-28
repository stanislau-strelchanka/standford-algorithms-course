package org.learn.coursera.outline.week5.graph.exploration;

import org.learn.coursera.datastructures.graph.Graph;

import java.util.List;

public interface Explorator {

    List<String> explore(final Graph graph, final String vertex);
}
