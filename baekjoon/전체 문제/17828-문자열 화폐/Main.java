import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    private static String solution(int N, int X) {
        if (N > X || N * 26 < X) {
            return "!";
        }

        StringBuilder sb = new StringBuilder();

        while (true) {
            if (X - 26 - N > 0) {
                sb.append('Z');
                X -= 26;
                N--;
            } else {
                sb.append((char) ('A' + X - N));
                N--;
                break;
            }
        }

        for (int i = 0; i < N; i++) {
            sb.append('A');
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        bw.write(solution(N, X));
        bw.flush();

        br.close();
        bw.close();
    }
}
