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

        bw.write(Integer.toString(solution(br)));

        bw.flush();
        bw.close();
    }

    private static int solution(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        if (N == 0) {
            return 0;
        }

        int totalBox = 1;

        int currentBoxWeight = 0;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int bookWeight = Integer.parseInt(st.nextToken());

            if (currentBoxWeight + bookWeight > M) {
                totalBox++;

                currentBoxWeight = bookWeight;
            } else {
                currentBoxWeight += bookWeight;
            }
        }

        return totalBox;
    }
}
