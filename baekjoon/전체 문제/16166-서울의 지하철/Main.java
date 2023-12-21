import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    // 호선, 역들
    private static Map<Integer, Set<Integer>> lines;
    // 역, 호선들
    private static Map<Integer, Set<Integer>> stations;
    // 출발 호선
    private static int startLine;
    // 도착 역
    private static int endStation;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        lines = new HashMap<>();

        stations = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int K = Integer.parseInt(st.nextToken());

            Set<Integer> set = new HashSet<>();

            for (int j = 0; j < K; j++) {
                int station = Integer.parseInt(st.nextToken());

                if (station == 0) {
                    startLine = i;
                }

                stations.computeIfAbsent(station, key -> new HashSet<>());

                stations.get(station).add(i);

                set.add(station);
            }

            lines.put(i, set);
        }

        endStation = Integer.parseInt(br.readLine());

        bw.write(Integer.toString(bfs()));
        bw.flush();

        br.close();
        bw.close();
    }

    private static int bfs() {
        // 버퍼
        Set<Integer> buffer = new HashSet<>();

        // 호선 방문 확인
        boolean[] visited = new boolean[N + 1];

        visited[startLine] = true;

        Queue<Vertex> queue = new ArrayDeque<>();

        queue.offer(new Vertex(startLine, lines.get(startLine), 0));

        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.poll();

            for (int station : currentVertex.stations) {
                if (station == endStation) {
                    return currentVertex.count;
                }

                for (int nextLine : stations.get(station)) {
                    if (currentVertex.line == nextLine) {
                        continue;
                    }

                    if (visited[nextLine]) {
                        continue;
                    }

                    visited[nextLine] = true;

                    buffer.add(nextLine);
                }
            }

            for (int nextLine : buffer) {
                queue.offer(new Vertex(nextLine, lines.get(nextLine), lines.get(nextLine).contains(0) ? currentVertex.count : currentVertex.count + 1));
            }

            buffer.clear();
        }

        return -1;
    }

    private static class Vertex {

        final int line;
        final Set<Integer> stations;
        final int count;

        Vertex(int line, Set<Integer> stations, int count) {
            this.line = line;
            this.stations = stations;
            this.count = count;
        }
    }
}
