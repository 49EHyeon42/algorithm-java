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
        int M = Integer.parseInt(br.readLine());

        int[] array = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        for (int start = 0; start < N; start++) {
            int end = start + 1;

            while (end < N) {
                int sum = array[start] + array[end++];

                if (sum == M) {
                    count++;
                    break;
                }
            }
        }

        bw.write(Integer.toString(count));
        bw.flush();

        br.close();
        bw.close();
    }
}
