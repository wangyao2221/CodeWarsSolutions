package com.wangyao2221.cn;

import javafx.geometry.Pos;

import java.util.LinkedList;
import java.util.Queue;

public class Finder {

    public static int pathFinder(String maze) {
        String[] mazeArr = maze.split("\n");
        int row = mazeArr.length;
        int col = maze.length() / mazeArr.length;
        String[][] matrix = new String[row][col];
        boolean[][] visit = new boolean[row][col];
        int[][] depth = new int[row][col];
        depth[0][0] = 0;
        Queue<Position> positionQueue = new LinkedList<Position>() {
            {
                add(new Position(0, 0));
            }
        };

        for (int i = 0; i < row; i++) {
            matrix[i] = mazeArr[i].split("");
        }

        while (!positionQueue.isEmpty()) {
            Position position = positionQueue.poll();
            int i = position.x;
            int j = position.y;
            visit[i][j] = true;

            if (i == matrix.length - 1 && j == matrix[0].length - 1) return depth[i][j];

            if (i - 1 > 0 && visit[i - 1][j] == false && ".".equals(matrix[i - 1][j])) {
                positionQueue.add(new Position(i - 1, j));
                depth[i - 1][j] = depth[i][j] + 1;
            }
            if (j - 1 > 0 && visit[i][j - 1] == false  && ".".equals(matrix[i][j - 1])) {
                positionQueue.add(new Position(i - 1, j));
                depth[i][j - 1] = depth[i][j] + 1;
            }
            if (i + 1 < matrix.length && visit[i + 1][j] == false  && ".".equals(matrix[i + 1][j])) {
                positionQueue.add(new Position(i + 1, j));
                depth[i + 1][j] = depth[i][j] + 1;
            }
            if (j + 1 < matrix[i].length && visit[i][j + 1] == false && ".".equals(matrix[i][j + 1])) {
                positionQueue.add(new Position(i, j + 1));
                depth[i][j + 1] = depth[i][j] + 1;
            }
        }

        return -1;
    }

    private static class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}