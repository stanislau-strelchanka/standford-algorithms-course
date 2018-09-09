package org.learn.coursera.divideconquer.week3.quicksort;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MedianOfThreePivotQuickSort extends QuickSort {
    @Override
    int choosePivotIndex(final List<Integer> numbers, final int startIndex, final int endIndex)  {
        final int midIndex = getMidIndex(numbers, startIndex, endIndex);
        final Integer a = numbers.get(startIndex);
        final Integer b = numbers.get(midIndex);
        final Integer c = numbers.get(endIndex);

        final Integer medianElement = Stream.of(a, b, c).sorted().collect(Collectors.toList()).get(1);
        return numbers.indexOf(medianElement);
    }

    private int getMidIndex(final List<Integer> numbers, final int startIndex, final int endIndex) {
        int i = endIndex + startIndex;
        int j = endIndex - startIndex % 2 == 0 ? 1 : 0;
        return i / 2 + j;
    }
}
