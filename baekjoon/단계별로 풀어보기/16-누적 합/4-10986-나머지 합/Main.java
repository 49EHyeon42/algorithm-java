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

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] countArray = new int[M];

        st = new StringTokenizer(br.readLine(), " ");

        /*
        모듈러 연산
        (array[j]-array[i]) % MOD = 0 가 만족한다면
        array[j] % MOD = array[i] % MOD 도 만족한다.
        */

        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum = (sum + Integer.parseInt(st.nextToken())) % M;
            countArray[sum]++;
        }

        long count = countArray[0]; // countArray[0] == value % MOD = 0 의 Count 값
        for (int i = 0; i < M; i++) {
            // array[j] % MOD = array[i] % MOD, 각 나머지 중 2개를 뽑는 경우
            count += (long) countArray[i] * (countArray[i] - 1) / 2;
        }

        bw.write(Long.toString(count));

        bw.flush();
        bw.close();
    }
}
