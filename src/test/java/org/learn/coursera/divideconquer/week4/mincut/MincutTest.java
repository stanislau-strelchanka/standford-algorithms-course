package org.learn.coursera.divideconquer.week4.mincut;

import org.junit.jupiter.api.Test;
import org.learn.coursera.datastructures.graph.Graph;
import org.learn.coursera.divideconquer.TestUtils;

public class MincutTest {

    @Test
    public void test() {
        Graph graph = TestUtils.readGraph("week4/kargerMinCut.txt");
    }
}
