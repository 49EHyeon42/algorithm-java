import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        List<String> people = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            people.add(st.nextToken());
        }

        Collections.sort(people);

        Map<String, Integer> peopleIndex = new HashMap<>();
        for (int i = 0; i < N; i++) {
            peopleIndex.put(people.get(i), i);
        }

        int[] countOfEdge = new int[N];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            Integer vertex1 = peopleIndex.get(st.nextToken());
            Integer vertex2 = peopleIndex.get(st.nextToken());

            countOfEdge[vertex1]++;
            graph.get(vertex2).add(vertex1);
        }

        // 부모 인덱스 저장 리스트
        ArrayList<Integer> parents = new ArrayList<>();

        // 자식 인덱스 저장 리스트
        ArrayList<ArrayList<Integer>> children = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            children.add(new ArrayList<>());
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            if (countOfEdge[i] == 0) {
                parents.add(i);

                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();

            for (int nextVertex : graph.get(currentVertex)) {
                countOfEdge[nextVertex]--;

                if (countOfEdge[nextVertex] == 0) {
                    children.get(currentVertex).add(nextVertex);

                    queue.offer(nextVertex);
                }
            }
        }

        for (ArrayList<Integer> child : children) {
            Collections.sort(child);
        }

        sb.append(parents.size()).append('\n');
        for (Integer index : parents) {
            sb.append(people.get(index)).append(' ');
        }
        sb.append('\n');
        for (int i = 0; i < N; i++) {
            ArrayList<Integer> personInfo = children.get(i);

            sb.append(people.get(i)).append(' ').append(personInfo.size()).append(' ');
            // 자식 탐색
            for (Integer index : personInfo) {
                sb.append(people.get(index)).append(' ');
            }
            sb.append('\n');
        }

        bw.write(sb.toString().trim());

        bw.flush();
        bw.close();
    }
}
