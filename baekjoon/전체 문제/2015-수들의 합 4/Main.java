import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        HashMap<Integer, Long> hashMap = new HashMap<>();
        long count = 0;

        int[] array = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            // 부분합
            array[i] = Integer.parseInt(st.nextToken()) + array[i - 1];

            if (array[i] == K) {
                count++;
            }

            // 범위 누적합 추가
            count += hashMap.getOrDefault(array[i] - K, 0L);

            // 누적합 반영
            hashMap.put(array[i], hashMap.getOrDefault(array[i], 0L) + 1);
        }

        bw.write(Long.toString(count));
        bw.flush();

        br.close();
        bw.close();
    }
}
