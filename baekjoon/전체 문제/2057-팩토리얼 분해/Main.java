import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long N = Long.parseLong(br.readLine());

        bw.write(solution(N));
        bw.flush();

        br.close();
        bw.close();
    }

    private static String solution(long N) {
        if (N == 0) {
            return "NO";
        }

        long[] factorial = new long[21];

        factorial[0] = 1;

        for (int i = 1; i <= 20; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        for (int i = 20; i >= 0; i--) {
            if (N >= factorial[i]) {
                N -= factorial[i];
            }
        }

        return N == 0 ? "YES" : "NO";
    }
}
