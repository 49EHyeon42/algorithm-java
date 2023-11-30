import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        boolean[] existed = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            existed[Integer.parseInt(st.nextToken())] = true;
        }

        int sum = 0;

        for (int i = 1, last = 0; i <= N; i++) {
            if (!existed[i]) {
                sum += last == 0 ? 7 : Math.min(7, (i - last) * 2);

                last = i;
            }
        }

        bw.write(Integer.toString(sum));
        bw.flush();

        br.close();
        bw.close();
    }
}
