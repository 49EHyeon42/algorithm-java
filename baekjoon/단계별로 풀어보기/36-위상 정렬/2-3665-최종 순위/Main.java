import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// reference : https://maetdori.tistory.com/entry/%EB%B0%B1%EC%A4%80-3665-%EC%B5%9C%EC%A2%85-%EC%88%9C%EC%9C%84-JAVA
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int testCaseCount = Integer.parseInt(br.readLine());
        while (testCaseCount-- > 0) {
            int teamCount = Integer.parseInt(br.readLine());

            int[] indegree = new int[teamCount + 1];
            boolean[][] edges = new boolean[teamCount + 1][teamCount + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < teamCount; i++) {
                int num = Integer.parseInt(st.nextToken());
                indegree[num] = i;

                for (int j = 1; j <= teamCount; j++) {
                    if (j != num && !edges[j][num]) {
                        edges[num][j] = true;
                    }
                }
            }

            int changeRankCount = Integer.parseInt(br.readLine());
            for (int i = 0; i < changeRankCount; i++) {
                st = new StringTokenizer(br.readLine());
                int vertex1 = Integer.parseInt(st.nextToken());
                int vertex2 = Integer.parseInt(st.nextToken());

                swap(indegree, edges, vertex1, vertex2);
            }

            sb.append(topologicalSort(indegree, edges, teamCount)).append('\n');
        }

        bw.write(sb.toString().trim());

        bw.flush();
        bw.close();
    }

    private static void swap(int[] indegree, boolean[][] edges, int vertex1, int vertex2) {
        if (!edges[vertex1][vertex2]) {
            indegree[vertex1]--;
            indegree[vertex2]++;
            edges[vertex1][vertex2] = true;
            edges[vertex2][vertex1] = false;
        } else {
            indegree[vertex1]++;
            indegree[vertex2]--;
            edges[vertex1][vertex2] = false;
            edges[vertex2][vertex1] = true;
        }
    }

    private static String topologicalSort(int[] indegree, boolean[][] edges, int teamCount) {
        StringBuilder sb = new StringBuilder();

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= teamCount; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        for (int i = 1; i <= teamCount; i++) {
            if (queue.size() == 0) {
                return "IMPOSSIBLE";
            } else if (queue.size() > 1) {
                return "?";
            }

            int currentVertex = queue.poll();

            sb.append(currentVertex).append(' ');

            for (int j = 1; j <= teamCount; j++) {
                if (edges[currentVertex][j]) {
                    edges[currentVertex][j] = false;

                    if (--indegree[j] == 0) {
                        queue.offer(j);
                    }
                }
            }
        }

        return sb.toString().trim();
    }
}
