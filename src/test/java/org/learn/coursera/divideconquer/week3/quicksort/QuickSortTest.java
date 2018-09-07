package org.learn.coursera.divideconquer.week3.quicksort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuickSortTest {

    private QuickSort quickSort = new QuickSort();

    @Test
    public void test() {
        final List<Integer> numbers = Arrays.asList(3, 5, 2, 4, 1);
        quickSort.partition(numbers, 0, numbers.size());
        assertEquals(Arrays.asList(2, 1, 3, 4, 5), numbers);
    }
}
