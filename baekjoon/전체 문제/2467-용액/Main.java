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

        int[] array = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int index1 = 0;
        int index2 = 0;
        int start = 0;
        int end = N - 1;
        int min = Integer.MAX_VALUE;

        while (start < end) {
            int sum = array[start] + array[end];

            if (Math.abs(sum) < min) {
                min = Math.abs(sum);
                index1 = start;
                index2 = end;
            }

            if (sum < 0) {
                start++;
            } else if (sum > 0) {
                end--;
            } else { // sum == 0
                break;
            }
        }

        bw.write(array[index1] + " " + array[index2]);
        bw.flush();

        br.close();
        bw.close();
    }
}
