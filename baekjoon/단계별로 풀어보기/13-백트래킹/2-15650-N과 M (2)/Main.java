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
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        array = new int[M];

        Recursion(1, 0);

        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }

    // 1부터 N까지 중복 없이 M개를 고른 순열, 오름차순
    public static void Recursion(int currentIndex, int depth) {
        if (depth == M) {
            for (int value : array) {
                sb.append(value).append(" ");
            }
            sb.append("\n");

            return;
        }
        for (int i = currentIndex; i <= N; i++) {
            array[depth] = i;
            Recursion(i + 1, depth + 1);
        }
    }
}
