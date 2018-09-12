package org.learn.coursera.divideconquer.week4.mincut;

import org.junit.jupiter.api.Test;
import org.learn.coursera.datastructures.graph.AdjacencyList;
import org.learn.coursera.divideconquer.TestUtils;

public class MincutTest {

    @Test
    public void test() {
        AdjacencyList adjacencyList = TestUtils.readGraph("week4/kargerMinCut.txt");
    }
}
