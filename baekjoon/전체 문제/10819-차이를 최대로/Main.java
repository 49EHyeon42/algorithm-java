import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    private static int N;

    private static int[] array;

    private static int[] temp;
    private static boolean[] isVisited;

    private static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        array = new int[N];

        temp = new int[N];
        isVisited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        backtracking(0);

        bw.write(Integer.toString(max));
        bw.flush();

        br.close();
        bw.close();
    }

    private static void backtracking(int depth) {
        if (depth == N) {
            int sum = 0;

            for (int i = 0; i < N - 1; i++) {
                sum += Math.abs(temp[i] - temp[i + 1]);
            }

            max = Math.max(max, sum);

            return;
        }

        for (int i = 0; i < N; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                temp[depth] = array[i];
                backtracking(depth + 1);
                isVisited[i] = false;
            }
        }
    }
}
