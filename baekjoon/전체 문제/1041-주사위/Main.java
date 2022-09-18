import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] dice = new int[6];

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            dice[i] = Integer.parseInt(st.nextToken());
        }

        long answer = 0;

        if (N == 1) {
            Arrays.sort(dice);

            for (int i = 0; i < 5; i++) {
                answer += dice[i];
            }
        } else {
            int[] temp = new int[3];
            temp[0] = Math.min(dice[0], dice[5]);
            temp[1] = Math.min(dice[1], dice[4]);
            temp[2] = Math.min(dice[2], dice[3]);

            Arrays.sort(temp);

            answer += temp[0] * (4L * (N - 1) * (N - 2) + (long) (N - 2) * (N - 2));
            answer += (temp[0] + temp[1]) * (4L * (N - 2) + 4L * (N - 1));
            answer += (temp[0] + temp[1] + temp[2]) * 4L;
        }

        bw.write(Long.toString(answer));
        bw.flush();

        br.close();
        bw.close();
    }
}
