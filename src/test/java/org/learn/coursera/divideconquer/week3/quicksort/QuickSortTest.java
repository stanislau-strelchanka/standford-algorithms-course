package org.learn.coursera.divideconquer.week3.quicksort;

import org.junit.jupiter.api.Test;
import org.learn.coursera.divideconquer.TestUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuickSortTest {

    private QuickSort quickSort = new MedianOfThreePivotQuickSort();

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
        final int totalComparisons = new FirstElementPivotQuickSort().sort(numbers);
        assertEquals(6, totalComparisons);
    }

    @Test
    public void test6() {
        final List<Integer> numbers = Arrays.asList(3, 5, 2, 4, 1);
        final int totalComparisons = new LastElementPivotQuickSort().sort(numbers);
        assertEquals(8, totalComparisons);
    }

    @Test
    public void test7() {
        final List<Integer> numbers = Arrays.asList(3, 8, 2, 5, 1, 4, 7, 6);
        MedianOfThreePivotQuickSort quickSort = new MedianOfThreePivotQuickSort();
        int i = quickSort.choosePivotIndex(numbers, 0, numbers.size() - 1);
        assertEquals(3, i);

        i = quickSort.choosePivotIndex(numbers, 0, 2);
        assertEquals(0, i);

        i = quickSort.choosePivotIndex(numbers, 1, 5);
        assertEquals(3, i);

        i = quickSort.choosePivotIndex(numbers, 3, 7);
        assertEquals(3, i);
    }

    @Test
    public void testProgrammingAssignment() {
        final QuickSort firstPivotElemSort = new FirstElementPivotQuickSort();
        final QuickSort lastPivotElemSort = new LastElementPivotQuickSort();
        final QuickSort medianPivotElemSort = new MedianOfThreePivotQuickSort();

        final List<Integer> numbers = TestUtils.readFileLines("week3/integers.txt");

        assertEquals(162085, firstPivotElemSort.sort(new ArrayList<>(numbers)));
        assertEquals(164123, lastPivotElemSort.sort(new ArrayList<>(numbers)));
        assertEquals(138382, medianPivotElemSort.sort(new ArrayList<>(numbers)));
    }
}
