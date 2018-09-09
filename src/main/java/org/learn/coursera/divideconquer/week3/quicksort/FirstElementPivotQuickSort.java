package org.learn.coursera.divideconquer.week3.quicksort;

import java.util.List;

public class FirstElementPivotQuickSort extends QuickSort {
    @Override
    int choosePivotIndex(final List<Integer> numbers, final int startIndex, final int endIndex)  {
        return startIndex;
    }
}
