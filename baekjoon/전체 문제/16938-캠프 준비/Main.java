import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int L;
    private static int R;
    private static int X;

    private static int[] array;

    private static int count;

    private static void backtracking(int depth, int start, int[] buffer) {
        if (depth == buffer.length) {
            int sum = 0;

            if (buffer[buffer.length - 1] - buffer[0] < X) {
                return;
            }

            for (int i : buffer) {
                sum += i;
            }

            if (sum < L || sum > R) {
                return;
            }

            count++;
            return;
        }

        for (int i = start; i < N; i++) {
            buffer[depth] = array[i];
            backtracking(depth + 1, i + 1, buffer);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        array = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);

        for (int i = 2; i <= N; i++) {
            backtracking(0, 0, new int[i]);
        }

        bw.write(Integer.toString(count));
        bw.flush();

        br.close();
        bw.close();
    }
}
