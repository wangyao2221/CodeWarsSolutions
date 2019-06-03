package com.wangyao2221.cn;

/**
 * 错误的解法！！！用BFS
 */
public class WrongFinder {
//    public static int pathFinder(String maze) {
//        String[] mazeArr = maze.split("\n");
//        int row = mazeArr.length;
//        int col = maze.length() / mazeArr.length;
//        String[][] matrix = new String[row][col];
//        boolean[][] visit = new boolean[row][col];
//
//        for (int i = 0; i < row; i++) {
//            matrix[i] = mazeArr[i].split("");
//        }
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[i].length; j++) {
//                System.out.print(matrix[i][j]);
//            }
//            System.out.println();
//        }
//        int pathLen = pathFinder(matrix, visit, 0, 0);
//        System.out.println(pathLen);
//
//        return pathLen >= matrix.length + matrix[0].length - 1 ? pathLen - 1 : -1;
//    }
//
//    public static int pathFinder(String[][] matrix, boolean[][] visit, int i, int j) {
//        if (i >= matrix.length || j >= matrix[0].length || i < 0 || j < 0) return 0;
//        if (visit[i][j] == true) return 0;
//        if (i == matrix.length - 1 && j == matrix[0].length - 1) {
//            visit[i][j] = true;
//            return 1;
//        }
//        if ("W".equals(matrix[i][j])){
//            visit[i][j] = true;
//            return 0;
//        }
//
//        visit[i][j] = true;
//        int right = pathFinder(matrix, visit, i, j + 1);
//        int down = pathFinder(matrix, visit, i + 1, j);
//        int left = pathFinder(matrix,visit,i,j - 1);
//        int up = pathFinder(matrix,visit,i - 1,j);
//        int min = min(right,left,down,up);
//
//        return min + 1;
//    }
//
//    private static int min(int right, int left, int down, int up) {
//        int min = Integer.MAX_VALUE;
//        if (right < min && right != -1) min = right;
//        if (left < min && left != -1) min = left;
//        if (down < min && down != -1) min = down;
//        if (up < min && up != -1) min = up;
//        return min;
//    }

    public static int pathFinder(String maze) {
        String[] mazeArr = maze.split("\n");
        int row = mazeArr.length;
        int col = maze.length() / mazeArr.length;
        String[][] matrix = new String[row][col];

        for (int i = 0; i < row; i++) {
            matrix[i] = mazeArr[i].split("");
        }
        int pathLen = pathFinder(matrix, 0, 0);

        return  pathLen >= 0 ? pathLen - 1 : -1;
    }

    public static int pathFinder(String[][] matrix, int i, int j) {
        if (i == matrix.length - 1 && j == matrix[0].length - 1) return 1;
        if (i >= matrix.length || j >= matrix[0].length) return 0;
        if ("W".equals(matrix[i][j])) return -1;

        int right = pathFinder(matrix, i, j + 1);
        int down = pathFinder(matrix, i + 1, j);
        int max = right > down ? right : down;

        return max > 0 ? max + 1 : -1;
    }

    public static void main(String[] args) {
        String a = ".W.\n" +
                ".W.\n" +
                "...";
        System.out.println(pathFinder(a));
    }
}