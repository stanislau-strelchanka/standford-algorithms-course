package org.learn.coursera.outline.week1.multiplication;

import java.math.BigInteger;

public class Subtractor {

    public String subtract(final String x, final String y) {
        return new BigInteger(x).subtract(new BigInteger(y)).toString();
    }
}
