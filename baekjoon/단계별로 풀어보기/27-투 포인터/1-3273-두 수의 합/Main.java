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

        int n = Integer.parseInt(br.readLine());

        int[] array = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int x = Integer.parseInt(br.readLine());

        Arrays.sort(array);

        int start = 0;
        int end = n - 1;
        int answer = 0;
        while (start < end) {
            int sum = array[start] + array[end];
            if (sum < x) {
                start++;
            } else if (sum > x) {
                end--;
            } else {
                start++;
                answer++;
            }
        }

        bw.write(Integer.toString(answer));

        bw.flush();
        bw.close();
    }
}
