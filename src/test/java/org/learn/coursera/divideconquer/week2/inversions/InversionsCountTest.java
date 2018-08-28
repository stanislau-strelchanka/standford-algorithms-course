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
}
