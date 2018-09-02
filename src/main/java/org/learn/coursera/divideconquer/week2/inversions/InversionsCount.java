package org.learn.coursera.divideconquer.week2.inversions;

import java.util.ArrayList;
import java.util.List;

public class InversionsCount {

    public long count(final List<Integer> numbers) {
        ListAndNumberOfInversions listAndNumberOfInversions = sortAndCountInversions(numbers);
        return listAndNumberOfInversions.getNumberOfInversions();
    }

    ListAndNumberOfInversions sortAndCountInversions(final List<Integer> numbers) {
        if (numbers.size() > 1) {
            final int splitIndex = numbers.size() / 2;
            final List<Integer> a = numbers.subList(0, splitIndex);
            final List<Integer> b = numbers.subList(splitIndex, numbers.size());
            ListAndNumberOfInversions listAndNumberOfInversionsa = sortAndCountInversions(a);
            final long aInversions = listAndNumberOfInversionsa.getNumberOfInversions();
            ListAndNumberOfInversions listAndNumberOfInversionsb = sortAndCountInversions(b);
            final long bInversions = listAndNumberOfInversionsb.getNumberOfInversions();

            final ListAndNumberOfInversions listAndNumberOfInversions = mergeAndCountInversions(
                    listAndNumberOfInversionsa.getNumbers(),
                    listAndNumberOfInversionsb.getNumbers());

            return new ListAndNumberOfInversions(listAndNumberOfInversions.getNumbers(),
                    listAndNumberOfInversions.getNumberOfInversions()
                            + aInversions
                            + bInversions);
        } else {
            return new ListAndNumberOfInversions(numbers, 0);
        }
    }

    ListAndNumberOfInversions mergeAndCountInversions(final List<Integer> a, final List<Integer> b) {
        final int resultingListSize = a.size() + b.size();
        final List<Integer> resultingList = new ArrayList<>(resultingListSize);
        long resultingInversionsCount = 0;

        int aIndex = 0, bIndex = 0;
        for (int i = 0; i < resultingListSize; i++) {
            Integer aNumber = a.get(Math.min(aIndex, a.size() - 1));
            Integer bNumber = b.get(Math.min(bIndex, b.size() - 1));

            if ((aNumber < bNumber && aIndex < a.size()) || bIndex == b.size()) {
                resultingList.add(aNumber);
                aIndex++;
            } else if(bIndex < b.size()){
                resultingInversionsCount += a.size() - aIndex;
                resultingList.add(bNumber);
                bIndex++;
            }
        }
        return new ListAndNumberOfInversions(resultingList, resultingInversionsCount);
    }

    public static class ListAndNumberOfInversions {

        private final List<Integer> numbers;
        private final long numberOfInversions;

        public ListAndNumberOfInversions(final List<Integer> numbers, final long numberOfInversions) {
            this.numbers = numbers;
            this.numberOfInversions = numberOfInversions;
        }

        public List<Integer> getNumbers() {
            return numbers;
        }

        public long getNumberOfInversions() {
            return numberOfInversions;
        }
    }
}
