package com.wangyao2221.codewars;

public class SumSquaredDivisors {
	
	public static String listSquared(long m, long n) {
		 // your code
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("[");
		for (long i = m;i < n;i++){
			long tmp = checkSquared(i);
			if (tmp != -1){
				stringBuilder.append(String.format("[%d, %d], ",i,tmp));
			}
		}
		if (stringBuilder.length() > 3) {
			stringBuilder.deleteCharAt(stringBuilder.length() - 1);
			stringBuilder.deleteCharAt(stringBuilder.length() - 1);
		}
		stringBuilder.append("]");

		return stringBuilder.toString();
	}

	public static long checkSquared(long n){
		long sum = 1;

		for (long i = 2;i <= n;i++){
			if(n % i == 0){
				sum += i * i;
			}
		}

		long sqrtSum = (long) Math.sqrt(sum);

		return sqrtSum * sqrtSum == sum ? sum : -1;
	}

}
