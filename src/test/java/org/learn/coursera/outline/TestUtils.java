package org.learn.coursera.outline;

import org.junit.platform.commons.util.StringUtils;
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
        return getGraphFromStream(is);
    }

    public static Graph readCompressedGraph(final String filePath) {
        final InputStream is = getCompressedFileStream(filePath);
        return getGraphFromStream(is);
    }

    private static Graph getGraphFromStream(final InputStream is) {
        final Graph graph = new AdjacencyListGraph();
        try (final BufferedReader reader = new BufferedReader(new InputStreamReader(
                is,
                StandardCharsets.UTF_8))) {
            String line = "";
            while ((line = reader.readLine()) != null) {
                addEdgeToGraph(graph, line);
            }
        } catch (final Exception e) {
            throw new RuntimeException(e);
        }

        return graph;
    }

    private static void addEdgeToGraph(final Graph graph, final String line) {
        final List<String> edgesAndHopCost = Arrays.stream(line.split("\\s+"))
                .collect(Collectors.toList());
        final Vertex source = Vertex.getInstance(edgesAndHopCost.get(0));

        for (int i = 1; i < edgesAndHopCost.size(); i++) {
            final String[] tailAndCost = edgesAndHopCost.get(i).split(",");
            graph.addEdge(source, Vertex.getInstance(tailAndCost[0]), extractCost(tailAndCost[1]));
        }
    }

    private static int extractCost(final String cost) {
        return cost == null || cost.isEmpty() ? 0 : Integer.valueOf(cost);
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
