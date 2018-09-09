package org.learn.coursera.divideconquer.week3.quicksort;

import org.junit.jupiter.api.Test;
import org.learn.coursera.divideconquer.TestUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuickSortTest {

    private QuickSort quickSort = new QuickSort();

    @Test
    public void test() {
        final List<Integer> numbers = Arrays.asList(3, 5, 2, 4, 1);
        final int index = quickSort.partition(numbers, 0, numbers.size() - 1);
        assertEquals(Arrays.asList(1, 2, 3, 4, 5), numbers);
        assertEquals(index, numbers.indexOf(3));
    }

    @Test
    public void test2() {
        final List<Integer> numbers = Arrays.asList(3, 8, 2, 5, 1, 4, 7, 6);
        final int index = quickSort.partition(numbers, 0, numbers.size() - 1);
        assertEquals(Arrays.asList(1, 2, 3, 5, 8, 4, 7, 6), numbers);
        assertEquals(index, numbers.indexOf(3));
    }

    @Test
    public void test3() {
        final List<Integer> numbers = Arrays.asList(3, 8, 2, 5, 1, 4, 7, 6);
        quickSort.sort(numbers);
        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8), numbers);
    }

    @Test
    public void test4() {
        final List<Integer> numbers = TestUtils.readFileLines("week3/integers.txt");
        final List<Integer> numbersSorted = numbers.stream().sorted().collect(Collectors.toList());
        quickSort.sort(numbers);
        assertEquals(numbersSorted, numbers);
    }

    @Test
    public void test5() {
        final List<Integer> numbers = Arrays.asList(3, 5, 2, 4, 1);
        final int totalComparisons = quickSort.sort(numbers);
        assertEquals(6, totalComparisons);
    }
}
