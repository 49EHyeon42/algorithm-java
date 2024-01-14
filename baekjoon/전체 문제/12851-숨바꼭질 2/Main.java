import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        bw.write(bfs(N, K));
        bw.flush();

        br.close();
        bw.close();
    }

    private static String bfs(int N, int K) {
        Map<Integer, Visit> visited = new HashMap<>();

        visited.put(N, new Visit(0, 1));

        Queue<Vertex> queue = new ArrayDeque<>();

        queue.offer(new Vertex(N, 0));

        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.poll();

            if (currentVertex.value == K) {
                Visit visit = visited.get(currentVertex.value);

                return visit.minimumVisit + "\n" + visit.count;
            }

            int nextWeight = currentVertex.weight + 1;

            int[] nextNs = new int[]{currentVertex.value - 1, currentVertex.value + 1, currentVertex.value * 2};

            for (int nextN : nextNs) {
                if (nextN < 0 || nextN > 100000) {
                    continue;
                }

                if (!visited.containsKey(nextN)) {
                    visited.put(nextN, new Visit(nextWeight, 1));

                    queue.offer(new Vertex(nextN, nextWeight));
                } else {
                    Visit visit = visited.get(nextN);

                    if (visit.minimumVisit == nextWeight) {
                        visit.count++;

                        queue.offer(new Vertex(nextN, nextWeight));
                    } else if (visit.minimumVisit > nextWeight) {
                        visit.minimumVisit = nextWeight;

                        visit.count = 1;
                    }
                }
            }
        }

        throw new RuntimeException();
    }

    private static class Visit {

        int minimumVisit;
        int count;

        Visit(int minimumVisit, int count) {
            this.minimumVisit = minimumVisit;
            this.count = count;
        }
    }

    private static class Vertex {

        final int value;
        final int weight;

        Vertex(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }
    }
}
