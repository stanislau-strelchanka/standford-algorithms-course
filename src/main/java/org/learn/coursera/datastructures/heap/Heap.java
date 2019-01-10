package org.learn.coursera.datastructures.heap;

import java.util.List;

public interface Heap {

    // log(n)
    void insert(final Integer x);

    // log(n)
    Integer extract();

    // 1
    Integer peek();

    // log(n)
    void heapify(final List<Integer> numbers);

    // log(n)
    void delete(final Integer x);

    Integer size();
}
