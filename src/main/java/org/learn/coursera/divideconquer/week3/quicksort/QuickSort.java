package org.learn.coursera.divideconquer.week3.quicksort;

import java.util.List;

public class QuickSort {

    public void sort(final List<Integer> numbers) {
        sort(numbers, 0, numbers.size() - 1);
    }

    void sort(final List<Integer> numbers, final int startIndex, final int endIndex) {
        if (startIndex < endIndex) {
            final int pivotIndex = choosePivotIndex(numbers, startIndex, endIndex);
            swap(numbers, pivotIndex, startIndex);
            final int pivotFinalIndex = partition(numbers, startIndex, endIndex);
            sort(numbers, startIndex, pivotFinalIndex - 1);
            sort(numbers, pivotFinalIndex + 1, endIndex);
        }
    }

    int partition(final List<Integer> numbers, final int startIndex, final int endIndex) {
        final Integer pivot = numbers.get(startIndex);
        int i = startIndex + 1;

        for (int j = i; j <= endIndex; j++) {
            if (numbers.get(j) < pivot) {
                swap(numbers, j, i);
                i++;
            }
        }
        swap(numbers, startIndex, i - 1);
        return i - 1;
    }

    int choosePivotIndex(final List<Integer> numbers, final int startIndex, final int endIndex) {
        return startIndex;
    }

    void swap(final List<Integer> numbers, final int firstIndex, final int secondIndex) {
        final Integer first = numbers.get(firstIndex);
        numbers.set(firstIndex, numbers.get(secondIndex));
        numbers.set(secondIndex, first);
    }
}
