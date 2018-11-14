package org.learn.coursera.outline.week3.quicksort;

import java.util.List;

public class LastElementPivotQuickSort extends QuickSort {
    @Override
    int choosePivotIndex(final List<Integer> numbers, final int startIndex, final int endIndex)  {
        return endIndex;
    }
}
