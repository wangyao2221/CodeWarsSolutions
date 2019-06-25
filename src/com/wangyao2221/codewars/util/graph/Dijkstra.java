package com.wangyao2221.codewars.util.graph;

public class Dijkstra {
    private final int INF = Integer.MAX_VALUE;
    public int[][] graph = {
            {0, 7, 9, INF, INF, 14},
            {7, 0, 10, 15, INF, INF},
            {9, 10, 0, 11, INF, 2},
            {INF, 15, 11, 0, 6, INF},
            {INF, INF, INF, 6, 0, 9},
            {14, INF, 2, INF, 9, 0}
    };

    public int[] dist = new int[graph.length];
    public int[] path = new int[graph.length];

    public static void main(String[] args) {
        Dijkstra dijkstra =  new Dijkstra();
        dijkstra.dijkstra(0);
        System.out.println(dijkstra.dist[4]);

        int i = 4;
        while (i != 0){
            System.out.println(dijkstra.path[i]);
            i = dijkstra.path[i];
        }
    }

    public void dijkstra(int start){
        int len = graph.length;
        boolean[] visit = new boolean[len];

        for (int i = 0; i < len; i++) {
            dist[i] = graph[start][i];

            if (graph[start][i] < INF){
                path[i] = start;
            }else {
                path[i] = -1;
            }
        }

        dist[start] = 0;
        visit[start] = true;

        for (int i = 1; i < len - 1; i++) {
            int min = INF;
            int k = start;
            for (int j = 0; j < len; j++) {
                if (!visit[j] && dist[j] < min){
                    k = j;
                    min = dist[j];
                }
            }

            visit[k] = true;

            for (int j = 0; j < len; j++) {
                if (!visit[j] && graph[k][j] < INF && dist[j] > dist[k] + graph[k][j]){
                    dist[j] = dist[k] + graph[k][j];
                    path[j] = k;
                }
            }
        }
    }
}
