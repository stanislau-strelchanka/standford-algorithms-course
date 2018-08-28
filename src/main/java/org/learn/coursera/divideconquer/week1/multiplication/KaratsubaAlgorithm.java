package org.learn.coursera.divideconquer.week1.multiplication;

public class KaratsubaAlgorithm {

    private final Summator summator = new Summator();
    private final Subtractor subtractor = new Subtractor();

    public String multiply(String x, String y) {
        if (x.length() > 1 || y.length() > 1) {
            final int requiredLength = getRequiredLength(x.length(), y.length());
            x = padZeros(x, requiredLength);
            y = padZeros(y, requiredLength);

            final String[] aAndB = split(x);
            final String[] cAndD = split(y);
            String ac, bd, product = "";

            ac = multiply(aAndB[0], cAndD[0]);
            bd = multiply(aAndB[1], cAndD[1]);
            product = multiply(summator.add(aAndB[0], aAndB[1]),
                    summator.add(cAndD[0], cAndD[1]));

            product = subtractor.subtract(product, ac);
            product = subtractor.subtract(product, bd);

            String result = multiplyTenPowerOf(ac, requiredLength);
            result = summator.add(result, bd);
            result = summator.add(result, multiplyTenPowerOf(product, requiredLength / 2));

            return result;
        } else {
            return String.valueOf(Integer.valueOf(x) * Integer.valueOf(y));
        }
    }

    // should be the power of 2
    private int getRequiredLength(final int i, final int j) {
        int requiredLength = Math.max(i, j);
        while ((requiredLength & (requiredLength - 1)) != 0) {
            requiredLength++;
        }

        return requiredLength;
    }

    private String padZeros(final String number, final int requiredLength) {
        return new String(new char[requiredLength- number.length()]).replace("\0", "0") + number;
    }

    private String multiplyTenPowerOf(final String number, final int power) {
        return number + new String(new char[power]).replace("\0", "0");
    }

    private String[] split(final String number) {
        final String[] result;
        if (number.length() > 1) {
            final int midPoint = number.length() / 2;
            final String a = number.substring(0, midPoint);
            final String b = number.substring(midPoint);
            result = new String[]{a, b};
        } else {
            result = new String[]{number};
        }
        return result;
    }
}
