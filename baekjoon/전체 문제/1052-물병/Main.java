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
        int K = Integer.parseInt(st.nextToken());

        bw.write(Integer.toString(solution(N, K)));
        bw.flush();
    }

    private static int solution(int N, int K) {
        if (N <= K) {
            return 0;
        }

        int answer = 0;

        while (true) {
            int count = 0;

            int temp = N;
            while (temp > 0) {
                if (temp % 2 == 1) {
                    count++;
                }
                temp /= 2;
            }

            if (K >= count) {
                break;
            }

            N++;
            answer++;
        }

        return answer;
    }
}
