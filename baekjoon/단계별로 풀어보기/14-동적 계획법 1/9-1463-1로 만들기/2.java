import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        bw.write(Integer.toString(recursive(N, 0)));

        bw.flush();
        bw.close();
    }

    private static int recursive(int N, int depth) {
        if (N < 2) {
            return depth;
        }
        return Integer.min(recursive(N / 2, N % 2 + depth + 1),
            recursive(N / 3, N % 3 + depth + 1));
    }
}
