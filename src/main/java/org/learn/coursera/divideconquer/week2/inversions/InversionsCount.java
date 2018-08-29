package org.learn.coursera.divideconquer.week2.inversions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InversionsCount {

    public int count(final List<Integer> numbers) {
        return 0;
    }

    ListAndNumberOfInversions mergeAndCountInversions(final List<Integer> a, final List<Integer> b) {
        final int resultingListSize = a.size() + b.size();
        final List<Integer> resultingList = new ArrayList<>(resultingListSize);
        int resultingInversionsCount = 0;

        int aIndex = 0, bIndex = 0;
        for (int i = 0; i < resultingListSize; i++) {
            Integer aNumber = a.get(Math.min(aIndex, a.size() - 1));
            Integer bNumber = b.get(Math.min(bIndex, b.size() - 1));

            if (aNumber < bNumber && aIndex < a.size()) {
                resultingList.add(aNumber);
                aIndex++;
            } else {
                if (aIndex < a.size()) {
                    resultingInversionsCount += b.size() - bIndex;
                }
                resultingList.add(bNumber);
                bIndex++;
            }
        }
        return new ListAndNumberOfInversions(resultingList, resultingInversionsCount);
    }

    public static class ListAndNumberOfInversions {

        private final List<Integer> numbers;
        private final int numberOfInversions;

        public ListAndNumberOfInversions(final List<Integer> numbers, final int numberOfInversions) {
            this.numbers = numbers;
            this.numberOfInversions = numberOfInversions;
        }

        public List<Integer> getNumbers() {
            return numbers;
        }

        public int getNumberOfInversions() {
            return numberOfInversions;
        }
    }
}
