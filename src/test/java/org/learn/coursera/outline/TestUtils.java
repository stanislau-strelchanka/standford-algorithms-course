package org.learn.coursera.outline;

import org.learn.coursera.datastructures.graph.Vertex;
import org.learn.coursera.datastructures.graph.impl.AdjacencyListGraph;
import org.learn.coursera.datastructures.graph.Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    public static Graph readGraph(final String filePath) {
        final Graph graph = new AdjacencyListGraph();

        try (final BufferedReader reader = new BufferedReader(new InputStreamReader(
                TestUtils.class.getClassLoader().getResourceAsStream(filePath),
                StandardCharsets.UTF_8))) {
            String line = "";
            while ((line = reader.readLine()) != null) {
                final List<Vertex> verticesAndEdges = Arrays.stream(line.split("\t"))
                        .map(Vertex::getInstance)
                        .collect(Collectors.toList());
                final Vertex source = verticesAndEdges.get(0);

                for (int i = 1; i < verticesAndEdges.size(); i++) {
                    graph.addEdge(source, verticesAndEdges.get(i));
                }
            }
        } catch (final Exception e) {


        }

        return graph;
    }
}
