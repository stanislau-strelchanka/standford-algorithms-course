package org.learn.coursera.outline;

import org.learn.coursera.datastructures.graph.impl.Vertex;
import org.learn.coursera.datastructures.graph.impl.AdjacencyListGraph;
import org.learn.coursera.datastructures.graph.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.zip.GZIPInputStream;

public class TestUtils {

    private final static String DEFAULT_SEPARATOR = "\t";

    public static List<Integer> readFileLines(final String filePath) {
        final List<Integer> lines = new ArrayList<>(100_000);
        try (final BufferedReader reader = new BufferedReader(new InputStreamReader(
                getFileStream(filePath),
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
        final InputStream is = getFileStream(filePath);
        return getGraphFromStream(is, DEFAULT_SEPARATOR);
    }

    public static Graph readCompressedGraph(final String filePath) {
        final InputStream is = getCompressedFileStream(filePath);
        return getGraphFromStream(is, " ");
    }

    private static Graph getGraphFromStream(final InputStream is, final String separator) {
        final Graph graph = new AdjacencyListGraph();
        try (final BufferedReader reader = new BufferedReader(new InputStreamReader(
                is,
                StandardCharsets.UTF_8))) {
            String line = "";
            while ((line = reader.readLine()) != null) {
                final List<Vertex> verticesAndEdges = Arrays.stream(line.split(separator))
                        .map(Vertex::getInstance)
                        .collect(Collectors.toList());
                final Vertex source = verticesAndEdges.get(0);

                for (int i = 1; i < verticesAndEdges.size(); i++) {
                    graph.addEdge(source, verticesAndEdges.get(i));
                }
            }
        } catch (final Exception e) {
            throw new RuntimeException(e);
        }

        return graph;
    }

    private static InputStream getFileStream(String filePath) {
        return TestUtils.class.getClassLoader().getResourceAsStream(filePath);
    }

    private static InputStream getCompressedFileStream(String filePath) {
        try {
            return new GZIPInputStream(getFileStream(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
