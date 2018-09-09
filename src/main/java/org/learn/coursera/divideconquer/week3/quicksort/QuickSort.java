package org.learn.coursera.divideconquer.week3.quicksort;

import java.util.List;

public abstract class QuickSort {

    public int sort(final List<Integer> numbers) {
        return  sort(numbers, 0, numbers.size() - 1);
    }

    int sort(final List<Integer> numbers, final int startIndex, final int endIndex) {
        if (startIndex < endIndex) {
            int comparisonsMade = countComparisons(startIndex, endIndex);

            final int pivotIndex = choosePivotIndex(numbers, startIndex, endIndex);
            swap(numbers, pivotIndex, startIndex);
            final int pivotFinalIndex = partition(numbers, startIndex, endIndex);
            comparisonsMade += sort(numbers, startIndex, pivotFinalIndex - 1);
            comparisonsMade += sort(numbers, pivotFinalIndex + 1, endIndex);
            return comparisonsMade;
        } else {
            return 0;
        }
    }

    int countComparisons(final int startIndex, final int endIndex) {
        return endIndex - startIndex;
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

    abstract int choosePivotIndex(final List<Integer> numbers, final int startIndex, final int endIndex);

    void swap(final List<Integer> numbers, final int firstIndex, final int secondIndex) {
        final Integer first = numbers.get(firstIndex);
        numbers.set(firstIndex, numbers.get(secondIndex));
        numbers.set(secondIndex, first);
    }
}
