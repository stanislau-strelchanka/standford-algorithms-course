package org.learn.coursera.outline.week8.twosum;

import java.util.List;
import java.util.Random;

public class TwoSumFinderImpl implements TwoSumFinder {

    @Override
    public Integer find(List<Integer> numbers, Integer sum) {
        return new Random().nextInt(2);
    }
}
