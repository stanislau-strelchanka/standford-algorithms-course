package org.learn.coursera.divideconquer.week2.inversions;

import java.util.List;

public class BruteForceInversionsCount implements InversionsCount {

    // not so dumb, O(n^2)
    public long count(final List<Integer> numbers) {
        long inversionsCount = 0;
        for (int i = 0; i < numbers.size() - 1; i++) {
            for (int j = i + 1; j < numbers.size(); j++) {
                if (numbers.get(i) > numbers.get(j)) {
                    inversionsCount++;
                }
            }
        }
        return inversionsCount;
    }
}
