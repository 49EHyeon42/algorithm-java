import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int M;
    private static int[] array;
    private static boolean[] visited;
    private static StringBuilder sb = new StringBuilder();;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        array = new int[M];
        visited = new boolean[N];

        Recursion(0);

        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }

    public static void Recursion(int depth) {
        if (depth == M) {
            for (int value : array) {
                sb.append(value).append(" ");
            }
            sb.append("\n");

            return;
        }
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                array[depth] = i+1;
                Recursion(depth+1);
                visited[i] = false;
            }
        }
    }
}
