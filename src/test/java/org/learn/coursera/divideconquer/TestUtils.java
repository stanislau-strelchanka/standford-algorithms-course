package org.learn.coursera.divideconquer;

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
}
