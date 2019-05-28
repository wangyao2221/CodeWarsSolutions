package com.wangyao2221.cn;

public class TenMinWalk {
  public static boolean isValid(char[] walk) {
    // Insert brilliant code here
    if (walk.length != 10) return false;

    int x = 0;
    int y = 0;

    for (char c : walk) {
      if (c == 'n') x++;
      else if (c == 's') x--;
      else if (c == 'w') y++;
      else if (c == 'e') y--;
    }

    return x == 0 && y == 0 ? true : false;
  }
}