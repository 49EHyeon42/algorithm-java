import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[] top = new int[H + 1]; // 석순
        int[] bottom = new int[H + 1]; // 종유석

        for (int i = 0; i < N; i++) {
            int length = Integer.parseInt(br.readLine());

            if (i % 2 == 0) {
                bottom[length]++;
            } else {
                top[H - length + 1]++;
            }
        }

        for (int i = 1; i <= H; i++) {
            top[i] += top[i - 1];
            bottom[H - i] += bottom[H - i + 1];
        }

        long min = Integer.MAX_VALUE;
        int count = 0;

        for (int i = 1; i <= H; i++) {
            int cumulativeSum = top[i] + bottom[i];

            if (min > cumulativeSum) {
                min = cumulativeSum;
                count = 1;
            } else if (min == cumulativeSum) {
                count++;
            }
        }

        bw.write(min + " " + count);
        bw.flush();

        br.close();
        bw.close();
    }
}
