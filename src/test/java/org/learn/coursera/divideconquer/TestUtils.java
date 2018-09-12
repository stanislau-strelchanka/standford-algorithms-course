package org.learn.coursera.divideconquer;

import org.learn.coursera.datastructures.graph.AdjacencyList;

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

    public static AdjacencyList readGraph(final String filePath) {
        final AdjacencyList graph = new AdjacencyList();

        try (final BufferedReader reader = new BufferedReader(new InputStreamReader(
                TestUtils.class.getClassLoader().getResourceAsStream(filePath),
                StandardCharsets.UTF_8))) {
            String line = "";
            while ((line = reader.readLine()) != null) {
                final String[] verticesAndEdges = line.split("\t");
                final String vertexName = verticesAndEdges[0];
                final AdjacencyList.Vertex vertex = graph.findOrCreateVertex(vertexName);

                for (int i = 1; i < verticesAndEdges.length; i++) {
                    final String adjacentVertexName = verticesAndEdges[i].trim();
                    final AdjacencyList.Vertex adjacentVertex = graph.findOrCreateVertex(adjacentVertexName);
                    graph.createEdge(vertex, adjacentVertex);
                }
            }
        } catch (final Exception e) {


        }

        return graph;
    }
}
