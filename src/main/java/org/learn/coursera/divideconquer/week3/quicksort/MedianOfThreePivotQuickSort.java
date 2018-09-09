package org.learn.coursera.divideconquer.week3.quicksort;

import java.util.List;

public class MedianOfThreePivotQuickSort extends QuickSort {
    @Override
    int choosePivotIndex(final List<Integer> numbers, final int startIndex, final int endIndex)  {
        final int midIndex = getMidIndex(numbers, startIndex, endIndex);
        int min = Math.min(numbers.get(startIndex), numbers.get(endIndex));
        min = Math.min(numbers.get(midIndex), min);
        return numbers.indexOf(min);
    }

    private int getMidIndex(final List<Integer> numbers, final int startIndex, final int endIndex) {
        int i = endIndex + startIndex;
        int j = endIndex - startIndex % 2 == 0 ? 1 : 0;
        return i / 2 + j;
    }
}
