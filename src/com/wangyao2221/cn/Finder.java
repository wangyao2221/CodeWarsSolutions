package com.wangyao2221.cn;

import java.util.LinkedList;
import java.util.Queue;

public class Finder {

    public static int pathFinder(String maze) {
        maze = maze.replaceAll("\n","");
        StringBuilder stringBuilder = new StringBuilder(maze);
        int n = (int) Math.sqrt(maze.length());
        stringBuilder.replace(0,1,"W");
        Queue<Position> positionQueue = new LinkedList<Position>() {
            {
                offer(new Position(0,0,0));
            }
        };

        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (!positionQueue.isEmpty()) {
            Position position = positionQueue.poll();
            int i = position.x;
            int j = position.y;
            if (i == n - 1 && j == n - 1) return position.steps;

            for (int k = 0; k < dir.length; k++) {
                int posX = i + dir[k][0];
                int posY = j + dir[k][1];

                if (posX < 0 || posY < 0 || posX >= n || posY >= n || stringBuilder.charAt(posX * n + posY) == 'W')
                    continue;

                positionQueue.offer(new Position(posX,posY,position.steps + 1));
                stringBuilder.replace(posX * n + posY,posX * n + posY + 1,"W");
            }
        }

        return -1;
    }

    static class Position{
        int x;
        int y;
        int steps;

        public Position(int x, int y, int steps) {
            this.x = x;
            this.y = y;
            this.steps = steps;
        }
    }
}