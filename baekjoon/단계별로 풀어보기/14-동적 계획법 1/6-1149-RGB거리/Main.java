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

        int N = Integer.parseInt(br.readLine());

        int[][] dpArray = new int[N][3];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            dpArray[i][0] = Integer.parseInt(st.nextToken());
            dpArray[i][1] = Integer.parseInt(st.nextToken());
            dpArray[i][2] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N; i++) {
            dpArray[i][0] += Integer.min(dpArray[i - 1][1], dpArray[i - 1][2]);
            dpArray[i][1] += Integer.min(dpArray[i - 1][0], dpArray[i - 1][2]);
            dpArray[i][2] += Integer.min(dpArray[i - 1][0], dpArray[i - 1][1]);
        }

        int min = Integer.min(Integer.min(dpArray[N - 1][0], dpArray[N - 1][1]), dpArray[N - 1][2]);

        bw.write(Integer.toString(min));

        bw.flush();
        bw.close();
    }
}
