import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            if (N == 0 && M == 0) {
                break;
            }

            int[] array = new int[N];

            for (int i = 0; i < N; i++) {
                array[i] = Integer.parseInt(br.readLine());
            }

            Arrays.sort(array);

            int count = 0;

            for (int i = 0; i < M; i++) {
                if (!exists(array, Integer.parseInt(br.readLine()))) {
                    continue;
                }

                count++;
            }

            sb.append(count).append('\n');
        }

        bw.write(sb.toString().trim());
        bw.flush();

        br.close();
        bw.close();
    }

    private static boolean exists(int[] array, int i) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (array[mid] == i) {
                return true;
            } else if (array[mid] < i) {
                left = mid + 1;
            } else { // array[mid] > i
                right = mid - 1;
            }
        }

        return false;
    }
}
