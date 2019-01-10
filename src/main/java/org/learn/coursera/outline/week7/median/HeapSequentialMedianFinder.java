package org.learn.coursera.outline.week7.median;

import org.learn.coursera.datastructures.heap.Heap;
import org.learn.coursera.datastructures.heap.PriorityQueueHeap;

public class HeapSequentialMedianFinder implements SequentialMedianFinder {

    private final Heap lowHeap = PriorityQueueHeap.maxHeapInstance();
    private final Heap highHeap = PriorityQueueHeap.minHeapInstance();

    @Override
    public Integer insertAndFindCurrentMedian(final Integer x) {
        insert(x);
        return currentMedian();
    }

    private void insert(final Integer x) {
        final Integer maxFromLow = lowHeap.peek();

        if(maxFromLow == null || x <= maxFromLow) {
            lowHeap.insert(x);
        } else {
            highHeap.insert(x);
        }

        rebalanceHeaps();
    }

    private void rebalanceHeaps() {
        final Integer lowHeapSize = lowHeap.size();
        final Integer highHeapSize = highHeap.size();

        if(lowHeapSize > highHeapSize && Math.abs(lowHeapSize - highHeapSize) == 2) {
            final Integer lowHeapMax = lowHeap.extract();
            highHeap.insert(lowHeapMax);
        } else if (highHeapSize > lowHeapSize) {
            final Integer highHeapMin = highHeap.extract();
            lowHeap.insert(highHeapMin);
        }
    }

    private Integer currentMedian() {
        return lowHeap.peek();
    }
}
