package com.wangyao2221.cn;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BinomialExpansion {

    public static String expand(String expr) {
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println(expr);
        int powerIndex = expr.indexOf("^");
        int power = Integer.parseInt(expr.substring(powerIndex + 1, expr.length()));
        String exprStr = expr.substring(0, powerIndex)
                .replace("(", "")
                .replace(")", "");

        List<ExprItem> originExpr = parseExpr(exprStr);

        for (int i = 0; i < originExpr.size(); i++) {
            System.out.println(originExpr.get(i).toString());
        }

        List<ExprItem> result = calc(originExpr, power);

        for (int i = 0; i < result.size(); i++) {
            ExprItem item = result.get(i);
            if (i > 0 && item.a > 0) {
                stringBuilder.append("+").append(item);
            } else {
                stringBuilder.append(item);
            }
        }

        return stringBuilder.toString();
    }

    public static List<ExprItem> parseExpr(String expr) {
        expr = expr.trim();
        List<ExprItem> result = new ArrayList<>();
        int flag = 1;
        long num = 0;
        int numCount = 0;

        for (int i = 0; i < expr.length(); i++) {
            char ch = expr.charAt(i);
            if (ch == '+') {
                flag = 1;
            } else if (ch == '-') {
                flag = -1;
            } else if (isInteger(ch)) {
                num = num * 10 + (ch - '0');
                numCount++;
                if (i + 1 == expr.length()
                        || expr.charAt(i + 1) == '+'
                        || expr.charAt(i + 1) == '-') {
                    if (num == 0) continue;
                    result.add(new ExprItem(num * flag, ch, 0));
                    numCount = 0;
                    num = 0;
                }
            } else {
                ExprItem item = null;
                if (numCount == 0) {
                    item = new ExprItem(1 * flag, ch, 1);
                } else {
                    if (num == 0) continue;
                    item = new ExprItem(num * flag, ch, 1);
                }
                result.add(item);
                flag = 1;
                num = 0;
                numCount = 0;
            }
        }
        return result;
    }

    public static boolean isInteger(char ch) {
        if (ch >= '0' && ch <= '9') return true;
        else return false;
    }

    public static List<ExprItem> calc(List<ExprItem> expr, int power) {
        if (power == 0) return new ArrayList<ExprItem>() {
            {
                add(new ExprItem(1, ' ', 0));
            }
        };

        if (power == 2) {
            return calc(expr, expr);
        }

        return calc(expr, calc(expr, power - 1));
    }

    public static List<ExprItem> calc(List<ExprItem> expr1, List<ExprItem> expr2) {
        List<ExprItem> result = new ArrayList<>();

        for (ExprItem item1 : expr1) {
            for (ExprItem item2 : expr2) {
                long a = item1.a * item2.a;
                int power = item1.power + item2.power;
                result.add(new ExprItem(a, item1.var, power));
            }
        }

        sortAndCombinExpr(result);

        return result;
    }

    public static void sortAndCombinExpr(List<ExprItem> expr) {
        expr.sort(new Comparator<ExprItem>() {
            @Override
            public int compare(ExprItem item1, ExprItem item2) {
                if (item1.power > item2.power) return -1;
                else if (item1.power < item2.power) return 1;
                else return 0;
            }
        });

        for (int i = 0; i < expr.size(); ) {
            if (expr.get(i).a == 0) expr.remove(i);

            if (i + 1 < expr.size()) {
                if (expr.get(i).power == expr.get(i + 1).power) {
                    expr.get(i).a = expr.get(i).a + expr.get(i + 1).a;
                    expr.remove(i + 1);
                } else {
                    i++;
                }
            } else {
                i++;
            }
        }
    }

    static class ExprItem {
        long a;
        char var;
        int power;

        public ExprItem(long a, char var, int power) {
            this.a = a;
            this.var = var;
            this.power = power;
        }

        @Override
        public String toString() {
            if (this.power == 0) {
                return String.format("%d", this.a);
            } else if (this.power == 1) {
                if (this.a == 1) {
                    return String.format("%c", this.var);
                } else {
                    return String.format("%d%c", this.a, this.var);
                }

            } else {
                if (this.a == 1) {
                    return String.format("%c^%d", this.var, this.power);
                } else if (this.a == -1) {
                    return String.format("-%c^%d", this.var, this.power);
                } else {
                    return String.format("%d%c^%d", this.a, this.var, this.power);
                }
            }
        }
    }

    public static void main(String[] args) {
        String result = expand("(-n-12)^5");
        System.out.println(result);
    }
}