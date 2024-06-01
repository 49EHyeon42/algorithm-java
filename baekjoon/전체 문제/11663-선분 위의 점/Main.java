import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] dots = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            dots[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(dots);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            sb.append(binarySearch(dots, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))).append('\n');
        }

        bw.write(sb.toString().trim());
        bw.flush();

        br.close();
        bw.close();
    }

    private static int binarySearch(int[] dots, int start, int end) {
        int left = 0;
        int right = dots.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (dots[mid] >= start) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        int minIndex = left;

        left = 0;
        right = dots.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (dots[mid] > end) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        // 점의 개수이기 떄문에 + 1
        return right - minIndex + 1;
    }
}
