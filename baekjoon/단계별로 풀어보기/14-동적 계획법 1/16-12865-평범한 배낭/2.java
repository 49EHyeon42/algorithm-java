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

        int[][] items = new int[N + 1][N + 1];
        int[] dpArray = new int[K + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            items[i][0] = Integer.parseInt(st.nextToken()); // items[i][0] = W
            items[i][1] = Integer.parseInt(st.nextToken()); // items[i][1] = V
        }

        for (int i = 1; i <= N; i++) {
            for (int j = K; j - items[i][0] >= 0; j--) {
                dpArray[j] = Math.max(dpArray[j], dpArray[j - items[i][0]] + items[i][1]);
            }
        }

        bw.write(Integer.toString(dpArray[K]));

        bw.flush();
        bw.close();
    }
}
