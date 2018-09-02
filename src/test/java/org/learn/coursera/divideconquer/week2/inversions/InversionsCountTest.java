package org.learn.coursera.divideconquer.week2.inversions;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InversionsCountTest {

    private InversionsCount inversionsCount = new InversionsCount();

    @Test
    public void test() {
        final int numberOfInversions = inversionsCount.count(Arrays.asList(1, 5, 2, 4));
        assertEquals(2, numberOfInversions);
    }

    @Test
    public void test2() {
        final int numberOfInversions = inversionsCount.count(Arrays.asList(1, 5, 3, 6, 4, 2));
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
}
