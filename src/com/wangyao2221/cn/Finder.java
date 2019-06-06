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
        int[][] depth = new int[row][col];
        depth[0][0] = 0;
        Queue<Position> positionQueue = new LinkedList<Position>() {
            {
                offer(new Position(0, 0));
            }
        };

        for (int i = 0; i < row; i++) {
            matrix[i] = mazeArr[i].split("");
        }

        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (!positionQueue.isEmpty()) {
            Position position = positionQueue.poll();
            int i = position.x;
            int j = position.y;
            if (i == matrix.length - 1 && j == matrix[0].length - 1) return depth[i][j];
            matrix[i][j] = "W";

            for (int k = 0; k < dir.length; k++) {
                int posX = i + dir[k][0];
                int posY = j + dir[k][1];

                if (posX < 0 || posY < 0 || posX >= matrix.length || posY >= matrix[i].length || "W".equals(matrix[posX][posY]))
                    continue;

                positionQueue.offer(new Position(posX, posY));
                depth[posX][posY] = depth[i][j] + 1;
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

    public static void main(String[] args) {
        String test = "......W..\n" +
                "..W....W.\n" +
                "....WW...\n" +
                ".....WWW.\n" +
                "...WW..W.\n" +
                "....W.W..\n" +
                "WW.W.W..W\n" +
                "W.W......\n" +
                "..WW.W.W.";
        System.out.println(pathFinder(test));
    }
}