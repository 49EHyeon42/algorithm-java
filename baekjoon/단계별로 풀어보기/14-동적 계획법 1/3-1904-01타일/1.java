import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    // 18760 KB, 144 MS
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int answer;
        if (N < 4) {
            answer = N;
        } else {
            int[] dpArray = new int[N + 1];

            dpArray[0] = 0;
            dpArray[1] = 1;
            dpArray[2] = 2;

            for (int i = 3; i <= N; i++) {
                dpArray[i] = (dpArray[i - 2] + dpArray[i - 1]) % 15746;
            }

            answer = dpArray[N];
        }

        bw.write(Integer.toString(answer));

        bw.flush();
        bw.close();
    }
}
