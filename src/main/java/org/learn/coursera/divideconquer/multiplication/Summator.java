package org.learn.coursera.divideconquer.multiplication;

import java.math.BigInteger;

public class Summator {

    public String add(final String x, final String y) {
        return new BigInteger(x).add(new BigInteger(y)).toString();
    }
}
