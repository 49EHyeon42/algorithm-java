import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Integer> pq = new PriorityQueue<>((cake1, cake2) -> {
            boolean isCake1DivisibleBy10 = cake1 % 10 == 0;
            boolean isCake2DivisibleBy10 = cake2 % 10 == 0;

            if (isCake1DivisibleBy10 && !isCake2DivisibleBy10) {
                return -1;
            }

            if (!isCake1DivisibleBy10 && isCake2DivisibleBy10) {
                return 1;
            }

            return cake1 - cake2;
        });

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            pq.offer(Integer.parseInt(st.nextToken()));
        }

        int maxCount = 0;

        while (!pq.isEmpty()) {
            int cakeLength = pq.poll();

            if (cakeLength < 10) {
                continue;
            }

            if (cakeLength == 10) {
                maxCount++;
                continue;
            }

            if (M < 1) {
                continue;
            }

            while (M > 0) {
                if (cakeLength <= 10) {
                    break;
                }

                cakeLength -= 10;
                maxCount++;
                M--;
            }

            if (cakeLength == 10) {
                maxCount++;
            }
        }

        bw.write(Integer.toString(maxCount));
        bw.flush();

        br.close();
        bw.close();
    }
}
