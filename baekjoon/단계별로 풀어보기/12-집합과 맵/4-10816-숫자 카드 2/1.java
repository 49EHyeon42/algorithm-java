import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// 128472 KB, 1572 MS
public class Main {

    public static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        array = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);

        int M = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            sb.append(upperBound(target) - lowerBound(target)).append(' ');
        }

        bw.write(sb.toString().trim());

        bw.flush();
        bw.close();
    }

    public static int upperBound(int target) {
        int start = 0;
        int end = array.length;

        while (start < end) {
            int mid = (start + end) / 2;

            if (target < array[mid]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    public static int lowerBound(int target) {
        int start = 0;
        int end = array.length;

        while (start < end) {
            int mid = (start + end) / 2;

            if (target <= array[mid]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }
}
