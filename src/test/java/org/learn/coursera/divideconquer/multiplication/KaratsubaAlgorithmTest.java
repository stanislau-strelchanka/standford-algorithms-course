package org.learn.coursera.divideconquer.multiplication;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class KaratsubaAlgorithmTest {

    private final KaratsubaAlgorithm karatsubaAlgorithm = new KaratsubaAlgorithm();

    @Test
    public void test() {
        final String result = karatsubaAlgorithm.multiply("100", "100");
        assertEquals("100000", result);
    }
}
