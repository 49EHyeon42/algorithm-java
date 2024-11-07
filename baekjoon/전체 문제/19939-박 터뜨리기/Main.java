import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int min = 0;

        for (int i = 1; i <= K; i++) {
            min += i;
        }

        int result;

        if (min > N) {
            result = -1;
        } else {
            result = (K - 1) + ((N - min) % K != 0 ? 1 : 0);
        }

        bw.write(Integer.toString(result));
        bw.flush();

        br.close();
        bw.close();
    }
}
