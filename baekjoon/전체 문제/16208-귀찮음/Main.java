import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int sum = 0;

        int[] array = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(st.nextToken());

            sum += value;

            array[i] = value;
        }

        Arrays.sort(array);

        long result = 0;

        for (int i = 0; i < N; i++) {
            int x = array[i];

            sum -= x;

            result += x * sum;
        }

        bw.write(Long.toString(result));
        bw.flush();

        br.close();
        bw.close();
    }
}
