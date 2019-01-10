package org.learn.coursera.outline.week7.median;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.learn.coursera.outline.TestUtils;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SequentialMedianFinderTest {

    private SequentialMedianFinder medianFinder;

    @BeforeEach
    public void init() {
        medianFinder = new HeapSequentialMedianFinder();
    }

    @Test
    public void testSimpleTestCase() {
        final List<Integer> integers = TestUtils.readFileLines("week7/median/simple_median_test.txt");

        final Integer sequentialMediansSum = findSequentialMediansSum(integers);
        assertEquals(9335, sequentialMediansSum % 10_000);
    }

    @Test
    public void assignment() {
        final List<Integer> integers = TestUtils.readFileLines("week7/median/median_assignment.txt");

        final Integer sequentialMediansSum = findSequentialMediansSum(integers);
        assertEquals(1213, sequentialMediansSum % 10_000);
    }

    private Integer findSequentialMediansSum(List<Integer> integers) {
        int medianSum = 0;
        for (Integer integer : integers) {
            medianSum += medianFinder.insertAndFindCurrentMedian(integer);
        }
        return medianSum;
    }
}
