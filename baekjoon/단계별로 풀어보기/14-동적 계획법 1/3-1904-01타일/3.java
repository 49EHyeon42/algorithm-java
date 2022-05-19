import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    
    // 15176 KB, 140 MS
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int answer;
        if (N < 4) {
            answer = N;
        } else {
            int temp = 0;
            int dp1 = 1;
            int dp2 = 2;

            for (int i = 0; i < N - 2; i++) {
                temp = (dp1 + dp2) % 15746;
                dp1 = dp2;
                dp2 = temp;
            }

            answer = temp;
        }

        bw.write(Integer.toString(answer));

        bw.flush();
        bw.close();
    }
}
