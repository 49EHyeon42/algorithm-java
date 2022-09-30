import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    private static int N;

    private static int[] array;

    private static int[] temp;
    private static boolean[] isVisited;

    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        array = new int[N];

        temp = new int[N];
        isVisited = new boolean[N];

        for (int i = 1; i <= N; i++) {
            array[i - 1] = i;
        }

        backtracking(0);

        bw.write(sb.toString().trim());
        bw.flush();

        br.close();
        bw.close();
    }

    private static void backtracking(int depth) {
        if (depth == N) {
            StringBuilder tempSb = new StringBuilder();

            for (int i = 0; i < N; i++) {
                tempSb.append(temp[i]).append(' ');
            }

            sb.append(tempSb).append('\n');

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
