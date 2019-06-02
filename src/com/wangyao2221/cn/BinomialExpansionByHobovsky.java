package com.wangyao2221.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * https://www.codewars.com/kumite/5b5e27ed51f0b305f1000061?sel=5b5e27ed51f0b305f1000061
 * 别人的解法，参考
 */
public class BinomialExpansionByHobovsky {

    private static final Pattern re = Pattern.compile("\\((-?\\d*)([a-z])([\\+\\-]\\d+)\\)\\^(\\d+)");

    public static String expand(String expr) {

        Matcher m = re.matcher(expr);
        m.find();

        String sa = m.group(1);
        int a = ("".equals(sa) ? 1 : ("-".equals(sa) ? -1 : Integer.parseInt(sa)));

        String x = m.group(2);

        String sb = m.group(3);
        int b = "".equals(sb) ? 0 : Integer.parseInt(sb);

        String se = m.group(4);
        int exp = "".equals(se) ? 1 : Integer.parseInt(se);
        if (exp == 0)
            return "1";

        if (exp == 1)
            return sa + x + sb;

        if (b == 0) {
            long coeff = (long) Math.pow(a, exp);
            return (coeff == 1 ? "" : (coeff == -1 ? '-' : coeff)) + x + "^" + exp;
        }

        List<Long> binoms = new ArrayList<>();
        for (int i = 0; i <= exp; ++i)
            binoms.add(nk(exp, i));

        long coeff1 = (long) Math.pow(a, exp);
        StringBuilder terms = new StringBuilder();
        for (int i = exp; i >= 0; --i) {

            long coeff = coeff1 * binoms.get(i);

            if (i != exp && coeff > 0)
                terms.append('+');

            if (coeff < 0)
                terms.append('-');

            if ((coeff != 1 && coeff != -1) || i == 0)
                terms.append(coeff > 0 ? coeff : -coeff);

            if (i > 0)
                terms.append(x);

            if (i > 1)
                terms.append("^" + i);

            coeff1 = coeff1 / a * b;
        }

        return terms.toString();
    }

    private static final List<List<Long>> nka = new ArrayList<>();

    private static long nk(int n, int k) {

        if (n == 0 || k == 0)
            return 1;

        if (k == 1)
            return n;

        if (n - k < k)
            return nk(n, n - k);

        for (int i = nka.size(); i <= n; ++i)
            nka.add(new ArrayList<>());

        List<Long> ns = nka.get(n);
        for (int i = ns.size(); i <= k; ++i)
            ns.add(0L);

        if (ns.get(k) != 0)
            return ns.get(k);
        else {
            Long b = nk(n - 1, k - 1) + nk(n - 1, k);
            ns.set(k, b);
            return b;
        }
    }
}