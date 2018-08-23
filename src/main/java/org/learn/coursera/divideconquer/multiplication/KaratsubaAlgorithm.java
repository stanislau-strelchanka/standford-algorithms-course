package org.learn.coursera.divideconquer.multiplication;

public class KaratsubaAlgorithm {

    private final Summator summator = new Summator();
    private final Substructor substructor = new Substructor();

    public String multiply(final String x, final String y) {
        return x + y;
    }

    private String[] split(final String x) {
        final String[] result;
        if (x.length() > 1) {
            final int midPoint = x.length() / 2;
            final String a = x.substring(0, midPoint);
            final String b = x.substring(midPoint);
            result = new String[]{a, b};
        } else {
            result = new String[]{x};
        }
        return result;
    }

    public static void main(String[] args) {
        KaratsubaAlgorithm algorithm = new KaratsubaAlgorithm();

        String[] split = algorithm.split("1");
        for (String s : split) {
            System.out.println(s);
        }
    }
}
