import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        // 가로등
        int[] array = new int[M];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int result = -1;

        int left = 1;
        int right = N;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (canGoHome(N, array, mid)) {
                right = mid - 1;
                result = mid;
            } else {
                left = mid + 1;
            }
        }

        bw.write(Integer.toString(result));
        bw.flush();

        br.close();
        bw.close();
    }

    private static boolean canGoHome(int N, int[] array, int height) {
        int index = 0;

        for (int i : array) {
            if (i - height <= index) {
                index = i + height;
            } else {
                return false;
            }
        }

        return N <= index;
    }
}
