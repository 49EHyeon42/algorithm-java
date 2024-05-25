import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Set<Integer> set = new HashSet<>();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            if (N == 0 && M == 0) {
                break;
            }

            for (int i = 0; i < N; i++) {
                set.add(Integer.parseInt(br.readLine()));
            }

            int count = 0;

            for (int i = 0; i < M; i++) {
                if (!set.contains(Integer.parseInt(br.readLine()))) {
                    continue;
                }

                count++;
            }

            sb.append(count).append('\n');

            // init
            set.clear();
        }

        bw.write(sb.toString().trim());
        bw.flush();

        br.close();
        bw.close();
    }
}
