package com.wangyao2221.cn;

public class TenMinWalk {
  public static boolean isValid(char[] walk) {
    // Insert brilliant code here
    if (walk.length != 10) return false;

    int sum = 0;
    for (char c : walk) {
      if (c == 'n') sum += 1;
      else if (c == 's') sum -= 1;
      else if (c == 'w') sum += 2;
      else if (c == 'e') sum -= 2;
    }

    return sum == 0 ? true : false;
  }
}