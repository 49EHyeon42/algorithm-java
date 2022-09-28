import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int S;

    private static int[] array;
    private static boolean[] isVisited;

    private static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        array = new int[N];
        isVisited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            backtracking(i, 0);
        }

        bw.write(Integer.toString(count));
        bw.flush();

        br.close();
        bw.close();
    }

    private static void backtracking(int depth, int start) {
        if (depth == 0) {
            int sum = 0;

            for (int i = 0; i < N; i++) {
                if (isVisited[i]) {
                    sum += array[i];
                }
            }

            if (S == sum) {
                count++;
            }

            return;
        }

        for (int i = start; i < N; i++) {
            isVisited[i] = true;
            backtracking(depth - 1, i + 1);
            isVisited[i] = false;
        }
    }
}
