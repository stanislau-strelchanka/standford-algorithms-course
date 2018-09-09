package org.learn.coursera.divideconquer.week2.inversions;

import org.junit.jupiter.api.Test;
import org.learn.coursera.divideconquer.TestUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InversionsCountTest {

    private InversionsCount inversionsCount = new InversionsCount();

    @Test
    public void test() {
        final long numberOfInversions = inversionsCount.count(Arrays.asList(1, 5, 2, 4));
        assertEquals(2, numberOfInversions);
    }

    @Test
    public void test2() {
        final long numberOfInversions = inversionsCount.count(Arrays.asList(1, 5, 3, 6, 4, 2));
        assertEquals(7, numberOfInversions);
    }

    @Test
    public void testMerge() {
        final InversionsCount.ListAndNumberOfInversions listAndNumberOfInversions = inversionsCount.mergeAndCountInversions(
                Arrays.asList(1, 3, 5),
                Arrays.asList(2, 4, 6));

        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6), listAndNumberOfInversions.getNumbers());
        assertEquals(3, listAndNumberOfInversions.getNumberOfInversions());
    }

    @Test
    public void testProgrammingAssignment() throws IOException {
        final List<Integer> numbers = TestUtils.readFileLines("week2/integers.txt");
        final long count = inversionsCount.count(numbers);
        System.out.println(count);
        assertEquals(2407905288L, count);
    }
}
