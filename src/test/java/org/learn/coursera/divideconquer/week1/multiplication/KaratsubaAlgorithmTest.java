package org.learn.coursera.divideconquer.week1.multiplication;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class KaratsubaAlgorithmTest {

    private final KaratsubaAlgorithm karatsubaAlgorithm = new KaratsubaAlgorithm();

    @Test
    public void test() {
        final String result = karatsubaAlgorithm.multiply("3141592653589793238462643383279502884197169399375105820974944592",
                "2718281828459045235360287471352662497757247093699959574966967627");
        assertEquals(new BigInteger("3141592653589793238462643383279502884197169399375105820974944592")
                .multiply(new BigInteger("2718281828459045235360287471352662497757247093699959574966967627")).toString(), result);
    }
}
