import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] array = new int[M];

        for (int i = 0; i < M; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(array);

        int maximumPrice = 0;
        int maximumProfit = 0;

        for (int i = 0; i < M; i++) {
            int profit = array[i] * Integer.min(N, M - i);

            if (maximumProfit < profit) {
                maximumPrice = array[i];
                maximumProfit = profit;
            }
        }

        bw.write(maximumPrice + " " + maximumProfit);
        bw.flush();

        br.close();
        bw.close();
    }
}
