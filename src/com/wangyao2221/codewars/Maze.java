package com.wangyao2221.codewars;

import java.util.LinkedList;
import java.util.Queue;

public class Maze {
    public static boolean hasExit(String[] maze) {
        Position start = findStart(maze);

        if (start == null){
            throw new RuntimeException();
        }

        int maxRowLength = 0;

        for (int i = 0; i < maze.length; i++) {
            if (maze[i].length() > maxRowLength){
                maxRowLength = maze[i].length();
            }
        }

        StringBuilder[] mazeBuilder = new StringBuilder[maze.length];
        for (int i = 0; i < maze.length; i++) {
            StringBuilder spaces = new StringBuilder();
            for (int j = maze[i].length(); j <= maxRowLength; j++) {
                spaces.append(" ");
            }
            mazeBuilder[i] = new StringBuilder(maze[i] + spaces.toString());
        }

        int[][] dir = {
                {0,1},
                {0,-1},
                {1,0},
                {-1,0}
        };
        Queue<Position> queue = new LinkedList<>();

        queue.offer(start);
        mazeBuilder[start.x].replace(start.y,start.y + 1,"#");

        while (!queue.isEmpty()){
            Position position = queue.poll();
            int x = position.x;
            int y = position.y;

            if (x == 0 || y == 0 || x == maze.length - 1 || y == maze[x].length() - 1){
                return true;
            }

            for (int i = 0; i < dir.length; i++) {
                int posX = x + dir[i][0];
                int posY = y + dir[i][1];
                if (posX < 0 || posY < 0 || posX >= mazeBuilder.length || posY >= mazeBuilder[posX].length() || mazeBuilder[posX].charAt(posY) == '#'){
                    continue;
                }

                queue.offer(new Position(posX,posY));
                mazeBuilder[posX].replace(posY,posY + 1,"#");
            }
        }

        return false;
    }

    public static Position findStart(String[] maze){
        Position position = null;

        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length(); j++) {
                if ('k' == (maze[i].charAt(j)) && position == null){
                    position = new Position(i,j);
                }else if ('k' == (maze[i].charAt(j)) && position != null){
                    return null;
                }
            }
        }

        return position;
    }

    static class Position{
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        String[] test1 = new String[]{
                "#########",
                "#k        #",
                "###########"
        };
        System.out.println(Maze.hasExit(test1));

        String[] test2 = new String[]{
                "###########",
                "#k        #",
                "#########"
        };
        System.out.println(Maze.hasExit(test2));
    }
}