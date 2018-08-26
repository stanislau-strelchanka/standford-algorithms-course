package org.learn.coursera.divideconquer.multiplication;

import java.math.BigInteger;

public class Subtractor {

    public String subtract(final String x, final String y) {
        return new BigInteger(x).subtract(new BigInteger(y)).toString();
    }
}
