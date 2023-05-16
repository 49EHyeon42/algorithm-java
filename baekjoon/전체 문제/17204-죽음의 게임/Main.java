import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    private static int[] graph;
    private static boolean[] visit;

    private static int dfs(int K) {
        Stack<Integer> stack = new Stack<>();

        stack.push(0);

        int count = 0;

        while (!stack.isEmpty()) {
            int nextVertex = stack.pop();

            if (nextVertex == K) {
                return count;
            }

            if (!visit[nextVertex]) {
                visit[nextVertex] = true;
                stack.push(graph[nextVertex]);
                count++;
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        graph = new int[N];
        visit = new boolean[N];

        for (int i = 0; i < N; i++) {
            graph[i] = Integer.parseInt(br.readLine());
        }

        bw.write(Integer.toString(dfs(K)));
        bw.flush();

        br.close();
        bw.close();
    }
}
