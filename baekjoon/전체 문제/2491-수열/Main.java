import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] array = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int max = 1;

        int ascending = 1;
        int descending = 1;

        for (int i = 0; i < N - 1; i++) {
            if (array[i] < array[i + 1]) {
                ascending++;
                descending = 1;
            } else if (array[i] > array[i + 1]) {
                descending++;
                ascending = 1;
            } else {
                ascending++;
                descending++;
            }

            max = Integer.max(max, Integer.max(ascending, descending));
        }

        bw.write(Integer.toString(max));
        bw.flush();

        br.close();
        bw.close();
    }
}
