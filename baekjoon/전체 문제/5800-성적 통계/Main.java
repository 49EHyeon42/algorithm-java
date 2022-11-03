import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int K = Integer.parseInt(br.readLine());
        for (int i = 1; i <= K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());

            int[] array = new int[N];

            for (int j = 0; j < N; j++) {
                array[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(array);

            int max = array[N - 1];
            int min = array[0];
            int largestGap = getLargestGap(array);

            sb.append("Class ").append(i).append('\n');
            sb.append("Max ").append(max).append(", Min ").append(min).append(", Largest gap ")
                .append(largestGap).append('\n');
        }

        bw.write(sb.toString().trim());
        bw.flush();

        br.close();
        bw.close();
    }

    private static int getLargestGap(int[] array) {
        int largestGap = 0;
        for (int i = 0; i < array.length - 1; i++) {
            int currentGap = array[i + 1] - array[i];
            if (largestGap < currentGap) {
                largestGap = currentGap;
            }
        }
        return largestGap;
    }
}
