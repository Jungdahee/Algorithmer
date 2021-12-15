package BOJ;

import java.io.*;
import java.util.*;

public class BOJ_1753_최단경로 {
    public static class Vertex implements Comparable<Vertex> {
        int v, weight;

        public Vertex(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }

        @Override
        public int compareTo(Vertex o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        int V = Integer.parseInt(input[0]);
        int E = Integer.parseInt(input[1]);
        int start = Integer.parseInt(br.readLine()) - 1;
        ArrayList<Vertex> adj[] = new ArrayList[V];
        int d[] = new int[V];
        boolean visited[] = new boolean[V];

        // 1. 입력 값 원하는 포맷으로 데이터 변경
        for(int i = 0;  i < V; i++) adj[i] = new ArrayList<Vertex>();

        for(int i = 0; i < E; i++) {
            input = br.readLine().split(" ");

            int u = Integer.parseInt(input[0]) - 1;
            int v = Integer.parseInt(input[1]) - 1;
            int w = Integer.parseInt(input[2]);

            adj[u].add(new Vertex(v, w));
        }

        // 2. 각 정점으로 가는 최소의 비용을 담은 d 배열 초기화
        Arrays.fill(d, Integer.MAX_VALUE);

        // 3. 시작 정점 설정
        d[start] = 0;

        PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>();
        pq.offer(new Vertex(start, d[start]));

        while(!pq.isEmpty()) {
            Vertex cur = pq.poll();

            if(visited[cur.v]) continue;
            visited[cur.v] = true;

            for(Vertex next : adj[cur.v]) {
                if(visited[next.v]) continue;
                if(next.weight == 0) continue;
                if(cur.weight + next.weight >= d[next.v]) continue;

                d[next.v] = cur.weight + next.weight;
                pq.offer(new Vertex(next.v, d[next.v]));
            }
        }

        for(int i = 0 ; i < d.length; i++) {
            if(d[i] == Integer.MAX_VALUE) System.out.println("INF");
            else System.out.println(d[i]);
        }
    }
}
