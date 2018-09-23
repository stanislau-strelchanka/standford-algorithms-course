package org.learn.coursera.divideconquer.week2.inversions;

import java.util.List;

public class DumbBruteForceInversionsCount implements InversionsCount {

    // ~ 20x times slower than divide and conquer approach, 100ms vs 17s
    // O( n^2 * log(n) )
    public long count(final List<Integer> numbers) {
        if (numbers.size() > 1) {
            final int splitIndex = numbers.size() / 2;
            final List<Integer> a = numbers.subList(0, splitIndex);
            final List<Integer> b = numbers.subList(splitIndex, numbers.size());
            long aCount = count(a);
            long bCount = count(b);

            long splitCount = 0;

            for (Integer aNumber : a) {
                for (Integer bNumber : b) {
                    if (aNumber > bNumber) {
                        splitCount++;
                    }
                }
            }
            return aCount + bCount + splitCount;
        } else {
            return 0;
        }
    }
}
