import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        boolean[] kayaks = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            kayaks[i] = true;
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < S; i++) {
            kayaks[Integer.parseInt(st.nextToken())] = false;
        }

        boolean[] spareKayaks = new boolean[N + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < R; i++) {
            spareKayaks[Integer.parseInt(st.nextToken())] = true;
        }

        for (int i = 1; i <= N; i++) {
            if (kayaks[i]) {
                if (spareKayaks[i]) {
                    if (i > 1 && !kayaks[i - 1] && !spareKayaks[i - 1]) {
                        kayaks[i - 1] = true;
                    } else if (i < N && !kayaks[i + 1] && !spareKayaks[i + 1]) {
                        kayaks[i + 1] = true;
                    }
                }
            } else {
                if (spareKayaks[i]) {
                    kayaks[i] = true;
                }
            }
        }

        int count = 0;

        for (int i = 1; i <= N; i++) {
            if (!kayaks[i]) {
                count++;
            }
        }

        bw.write(Integer.toString(count));
        bw.flush();

        br.close();
        bw.close();
    }
}
