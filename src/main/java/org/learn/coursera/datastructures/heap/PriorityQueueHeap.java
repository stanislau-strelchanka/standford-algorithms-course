package org.learn.coursera.datastructures.heap;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

//todo implement own heap
public class PriorityQueueHeap implements Heap {

    private final PriorityQueue<Integer> priorityQueue;

    private PriorityQueueHeap(PriorityQueue<Integer> priorityQueue) {
        this.priorityQueue = priorityQueue;
    }

    public static Heap minHeapInstance() {
        return new PriorityQueueHeap(new PriorityQueue<>());
    }

    public static Heap maxHeapInstance() {
        return new PriorityQueueHeap(new PriorityQueue<>(Comparator.reverseOrder()));
    }

    @Override
    public void insert(Integer x) {
        priorityQueue.add(x);
    }

    @Override
    public Integer extract() {
        return priorityQueue.poll();
    }

    @Override
    public Integer peek() {
        return priorityQueue.peek();
    }

    @Override
    public void heapify(List<Integer> numbers) {
        priorityQueue.addAll(numbers);
    }

    @Override
    public void delete(Integer x) {
        priorityQueue.remove(x);
    }

    @Override
    public Integer size() {
        return priorityQueue.size();
    }
}
