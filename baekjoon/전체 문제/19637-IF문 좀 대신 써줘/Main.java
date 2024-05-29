import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] titles = new String[N];
        int[] powers = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            titles[i] = st.nextToken();
            powers[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            sb.append(binarySearch(titles, powers, Integer.parseInt(br.readLine()))).append('\n');
        }

        bw.write(sb.toString().trim());
        bw.flush();

        br.close();
        bw.close();
    }

    private static String binarySearch(String[] titles, int[] powers, int target) {
        int left = 0;
        int right = powers.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (powers[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return titles[left];
    }
}
