package org.learn.coursera.outline.week7.median;

import java.util.Random;

public class HeapSequentialMedianFinder implements SequentialMedianFinder {

    @Override
    public Integer insertAndFindCurrentMedian(Integer x) {
        return new Random(System.currentTimeMillis()).nextInt(10000);
    }
}
