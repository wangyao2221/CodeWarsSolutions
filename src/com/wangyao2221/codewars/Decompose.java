package com.wangyao2221.codewars;

// If no valid solution exists return null
public class Decompose {

    /**
     * 有错误
     * n = 50
     * Expected :1 3 5 8 49
     * Actual   :14 48
     *
     * @param n
     * @return
     */
    public String decomposeErr(long n) {
        // 第一层循环的遍历作为一组数据的最大值
        for (long i = n - 1; i > 1; i--) {
            long squareRem = n * n; // n^2
            StringBuilder stringBuilder = new StringBuilder();

            // 从这组的最大值开始遍历
            for (long j = i; j > 0; j--) {
                // 如果j^2 < squareRem，则表示j^2有可能是squareRem的一个加数
                if (j * j < squareRem) {
                    stringBuilder.insert(0, " " + j);
                    // 把j^2从squareRem减掉，以便找后续的加数
                    squareRem -= j * j;
                    System.out.print(j + " ");
                } else if (j * j == squareRem) { // 找到一组值
                    stringBuilder.insert(0, j);
                    System.out.print(j + " ");
                    return stringBuilder.toString();
                }
            }
            System.out.println();
        }

        return null;
    }

    public String decompose(long n) {
        String result = null;

        for (long i = n - 1; i > 1; i--) {
            long square = n * n;
            result = recurseDecompose(i, square);
            if (result != null) break;
        }

        return result;
    }

    public static String recurseDecompose(long i, long rem) {
        if (i * i == rem) {
            return i + "";
        } else if (i * i < rem) {
            rem = rem - i * i;

            for (long j = i - 1; j > 0; j--) {
                String tmp = recurseDecompose(j, rem);

                if (tmp != null) {
                    System.out.println(tmp + " " + i);
                    return tmp + " " + i;
                } else {
                    continue;
                }
            }
        } else {
            return null;
        }

        return null;
    }
}
