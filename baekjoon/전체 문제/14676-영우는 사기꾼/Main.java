import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] countOfEdge = new int[N + 1];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int vertex1 = Integer.parseInt(st.nextToken());
            int vertex2 = Integer.parseInt(st.nextToken());

            countOfEdge[vertex2]++;
            graph.get(vertex1).add(vertex2);
        }

        boolean isLiar = false;
        int[] countBuilding = new int[N + 1];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int vertex = Integer.parseInt(st.nextToken());

            if (command == 1) { // 건설
                if (countOfEdge[vertex] > 0) {
                    isLiar = true;
                    break;
                } else {
                    countBuilding[vertex]++;

                    if (countBuilding[vertex] == 1) {
                        for (int nextVertex : graph.get(vertex)) {
                            countOfEdge[nextVertex]--;
                        }
                    }
                }
            } else { // 파괴
                if (countBuilding[vertex] == 0) {
                    isLiar = true;
                    break;
                } else {
                    countBuilding[vertex]--;

                    if (countBuilding[vertex] == 0) {
                        for (int nextVertex : graph.get(vertex)) {
                            countOfEdge[nextVertex]++;
                        }
                    }
                }
            }
        }

        if (isLiar) {
            bw.write("Lier!");
        } else {
            bw.write("King-God-Emperor");
        }

        bw.flush();
        bw.close();
    }
}
