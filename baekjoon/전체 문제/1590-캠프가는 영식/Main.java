import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int minWait = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int I = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            int left = 0;
            int right = C - 1;

            while (left <= right) {
                int mid = (left + right) / 2;

                if (S + I * mid >= T) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            // 마지막 버스까지 탈 수 없는 경우
            if (left >= C) {
                continue;
            }

            minWait = Math.min(minWait, S + I * left - T);
        }

        bw.write(Integer.toString(minWait == Integer.MAX_VALUE ? -1 : minWait));
        bw.flush();

        br.close();
        bw.close();
    }
}
