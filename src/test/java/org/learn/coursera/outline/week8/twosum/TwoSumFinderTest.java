package org.learn.coursera.outline.week8.twosum;

import org.junit.jupiter.api.Test;
import org.learn.coursera.outline.TestUtils;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TwoSumFinderTest {

    TwoSumFinder twoSumFinder;

    @Test
    public void testSimpleTestCase() {
        List<Long> numbers = TestUtils.readLongFileLines("week8/twosum/simple-2sum-test.txt");

        final int result = getDistinct2SumsOfInterval(numbers, 3, 10);

        assertEquals(8, result);
    }

    @Test
    public void testAssignment() {
        List<Long> numbers = TestUtils.readLongFileLines("week8/twosum/2sum-assignment.txt");

        final int result = getDistinct2SumsOfInterval(numbers, -10_000, 10_000);

        assertEquals(666, result);
    }

    public Integer getDistinct2SumsOfInterval(final List<Long> numbers, final long startInterval, final long endInterval) {
        Integer result = 0;
        twoSumFinder = new TwoSumFinderImpl(numbers);
        for (long i = startInterval; i <= endInterval; i++) {
            result += twoSumFinder.find(i);
        }

        return result;
    }
}
