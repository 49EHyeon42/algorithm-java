import java.io.*;
import java.util.*;

public class Main {

    private static final Map<Integer, List<Integer>> graph = new HashMap<>();

    private static final List<Integer> list = new ArrayList<>();
    private static final Set<Integer> district1 = new HashSet<>();
    private static final Set<Integer> district2 = new HashSet<>();

    private static final Queue<Integer> queue = new LinkedList<>();

    private static int N;
    private static int[] populations;

    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        populations = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            populations[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            int count = Integer.parseInt(st.nextToken());

            for (int j = 0; j < count; j++) {
                graph.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }

        for (int i = 1; i < N; i++) { // 모든 선거구를 선택하는 조합은 제외
            combination(i, 1);
        }

        bw.write(Integer.toString(min == Integer.MAX_VALUE ? -1 : min));
        bw.flush();

        br.close();
        bw.close();
    }

    // backtracking
    // depth == r, n 개 중 r 개 선택
    private static void combination(int depth, int nextIndex) {
        if (depth == 0) {
            int startDistrict1Vertex = -1;
            int startDistrict2Vertex = -1;

            district1.clear();
            district2.clear();

            for (int i = 1; i <= N; i++) {
                if (list.contains(i)) {
                    startDistrict1Vertex = i;
                    district1.add(i);
                } else {
                    startDistrict2Vertex = i;
                    district2.add(i);
                }
            }

            if (!bfs(startDistrict1Vertex, district1)) {
                return;
            }

            if (!bfs(startDistrict2Vertex, district2)) {
                return;
            }

            min = Math.min(min, Math.abs(getPopulation(district1) - getPopulation(district2)));

            return;
        }

        for (int i = nextIndex; i <= N; i++) {
            list.add(i);
            combination(depth - 1, i + 1);
            list.remove(list.size() - 1);
        }
    }

    private static boolean bfs(int startVertex, Set<Integer> district) {
        int count = 0;

        boolean[] visited = new boolean[N + 1];

        visited[startVertex] = true;

        queue.offer(startVertex);

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();

            count++;

            for (int nextVertex : graph.get(currentVertex)) {
                if (visited[nextVertex]) {
                    continue;
                }

                if (!district.contains(nextVertex)) {
                    continue;
                }

                visited[nextVertex] = true;

                queue.offer(nextVertex);
            }
        }

        return count == district.size();
    }

    private static int getPopulation(Set<Integer> district) {
        int sum = 0;

        for (int i : district) {
            sum += populations[i];
        }

        return sum;
    }
}
