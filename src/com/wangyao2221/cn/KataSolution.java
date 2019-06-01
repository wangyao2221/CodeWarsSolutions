package com.wangyao2221.cn;

import java.util.ArrayList;
import java.util.List;

public class KataSolution {

	public static String expand(String expr) {
		int powerIndex = expr.indexOf("^");
		int power = Integer.parseInt(expr.substring(powerIndex + 1,expr.length()));
		String exprStr = expr.substring(0,powerIndex)
				.replace("(","")
				.replace(")","");

		List<ExprItem> originExpr =  parseExpr(exprStr);
		List<ExprItem> result = calc(originExpr,power);

		for (ExprItem item : result) {
			System.out.println(item.a + " " + item.power);
		}

		return "";
	}

	public static List<ExprItem> parseExpr(String expr){
		expr = expr.trim();
		List<ExprItem> result = new ArrayList<>();
		int flag = 1;
		int num = 0;

		for (int i = 0; i < expr.length(); i++) {
			char ch = expr.charAt(i);
			if (ch == '+'){
				flag = 1;
			} else if (ch == '-'){
				flag = -1;
			}else if (isInteger(ch)){
				num = num * 10 + (ch - '0');
				if (i + 1 == expr.length()
						|| expr.charAt(i + 1) == '+'
						|| expr.charAt(i + 1) == '-'){
					int a = num == 0 ? 1 : flag * num;
					result.add(new ExprItem(a,0));
					num = 0;
				}
			}else {
				int a = num == 0 ? 1 : flag * num;
				ExprItem item = new ExprItem(a,1);
				flag = 1;
				num = 0;
				result.add(item);
			}
		}
		return result;
	}

	public static boolean isInteger(char ch){
		if (ch > '0' && ch < '9') return true;
		else return false;
	}

	public static List<ExprItem> calc(List<ExprItem> expr,int power){
		if (power == 0) return new ArrayList<ExprItem>(){
			{
				add(new ExprItem(1,0));
			}
		};

		if (power == 2){
			return calc(expr,expr);
		}

		return calc(expr,calc(expr,power - 1));
	}

	public static List<ExprItem> calc(List<ExprItem> expr1,List<ExprItem> expr2){
		List<ExprItem> result = new ArrayList<>();

		for (ExprItem item1 : expr1) {
			for (ExprItem item2 : expr2) {
				int a = item1.a * item2.a;
				int power = item1.power + item2.power;
				result.add(new ExprItem(a,power));
			}
		}

		return result;
	}

	// TODO 先将表达式按power排序，然后合并同次幂的项，最后需要写成字符串

	static class ExprItem {
		int a;
		int power;

		public ExprItem(int a, int power) {
			this.a = a;
			this.power = power;
		}
	}

	public static void main(String[] args) {
		expand("(x+1)^3");
	}
}