import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    private static int[] lis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] array = new int[N + 1];
        lis = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        int max = 0;
        for (int i = 1; i <= N; i++) {
            array[i] = Integer.parseInt(st.nextToken());

            if (lis[max] < array[i]) {
                lis[max + 1] = array[i];
                max++;
            } else {
                lis[binarySearch(0, max, array[i])] = array[i];
            }
        }

        bw.write(Integer.toString(max));

        bw.flush();
        bw.close();
    }

    private static int binarySearch(int left, int right, int target) {
        while (left < right) {
            int mid = (left + right) / 2;

            if (lis[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }
}
