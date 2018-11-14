package org.learn.coursera.outline;

import org.learn.coursera.datastructures.graph.AdjacencyListGraph;
import org.learn.coursera.datastructures.graph.UndirectedGraph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class TestUtils {

    public static List<Integer> readFileLines(final String filePath) {
        final List<Integer> lines = new ArrayList<>(100_000);
        try (final BufferedReader reader = new BufferedReader(new InputStreamReader(
                TestUtils.class.getClassLoader().getResourceAsStream(filePath),
                StandardCharsets.UTF_8))) {
            String line = "";
            while ((line = reader.readLine()) != null) {
                lines.add(Integer.valueOf(line));
            }
        } catch (final Exception e) {

        }
        return lines;
    }

    public static UndirectedGraph readGraph(final String filePath) {
        final UndirectedGraph graph = new AdjacencyListGraph();

        try (final BufferedReader reader = new BufferedReader(new InputStreamReader(
                TestUtils.class.getClassLoader().getResourceAsStream(filePath),
                StandardCharsets.UTF_8))) {
            String line = "";
            while ((line = reader.readLine()) != null) {
                final String[] verticesAndEdges = line.split("\t");
                final String source = verticesAndEdges[0];

                for (int i = 1; i < verticesAndEdges.length; i++) {
                    graph.addEdge(source, verticesAndEdges[i]);
                }
            }
        } catch (final Exception e) {


        }

        return graph;
    }
}
