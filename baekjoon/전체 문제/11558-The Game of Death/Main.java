import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

    private static int N;

    private static int[] graph;
    private static int[] visit;

    private static int dfs() {
        // [0] = next player, [1] = count
        Stack<int[]> stack = new Stack<>();

        stack.push(new int[]{graph[1], 0});

        while (!stack.isEmpty()) {
            int[] currentPlayer = stack.pop();

            if (visit[currentPlayer[0]] != 0) {
                continue;
            }

            visit[currentPlayer[0]] = currentPlayer[1] + 1;

            stack.push(new int[]{graph[currentPlayer[0]], visit[currentPlayer[0]]});
        }

        return visit[N];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());

            graph = new int[N + 1];
            visit = new int[N + 1];

            for (int i = 1; i <= N; i++) {
                graph[i] = Integer.parseInt(br.readLine());
            }

            sb.append(N == 1 || graph[1] == 1 ? 0 : dfs()).append('\n');
        }

        bw.write(sb.toString().trim());
        bw.flush();

        br.close();
        bw.close();
    }
}
