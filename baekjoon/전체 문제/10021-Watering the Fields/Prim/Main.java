import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        List<Point> points = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            points.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        List<List<Vertex>> graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                int weight = getWeight(points.get(i), points.get(j));

                if (weight < C) {
                    continue;
                }

                graph.get(i).add(new Vertex(j, weight));
                graph.get(j).add(new Vertex(i, weight));
            }
        }

        bw.write(Integer.toString(getResult(N, graph)));

        bw.flush();
        bw.close();
    }

    private static int getWeight(Point point1, Point point2) {
        int temp1 = point1.x - point2.x;
        int temp2 = point1.y - point2.y;

        return temp1 * temp1 + temp2 * temp2;
    }

    private static int getResult(int N, List<List<Vertex>> graph) {
        int result = 0;

        int visitedCount = 0;

        PriorityQueue<Vertex> pq = new PriorityQueue<>(Comparator.comparingInt(vertex -> vertex.weight));
        pq.offer(new Vertex(0, 0));

        boolean[] visited = new boolean[N];

        while (!pq.isEmpty()) {
            Vertex currentVertex = pq.poll();

            if (visited[currentVertex.number]) {
                continue;
            }

            visited[currentVertex.number] = true;

            result += currentVertex.weight;

            visitedCount++;

            for (Vertex nextVertex : graph.get(currentVertex.number)) {
                if (visited[nextVertex.number]) {
                    continue;
                }

                pq.offer(nextVertex);
            }
        }

        return visitedCount == N ? result : -1;
    }

    private static class Point {

        final int x;
        final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static class Vertex {

        final int number;
        final int weight;

        public Vertex(int number, int weight) {
            this.number = number;
            this.weight = weight;
        }
    }
}
