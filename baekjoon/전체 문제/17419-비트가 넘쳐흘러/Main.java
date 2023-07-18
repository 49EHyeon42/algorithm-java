import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    // K = K - (K & ((~K) + 1)) -> K의 최하위 1비트를 제거
    // 몇 번 연산이 수행되는가? -> 1의 개수만큼 연산

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String K = br.readLine();

        int count = 0;

        for (int i = 0; i < N; i++) {
            if (K.charAt(i) == '1') {
                count++;
            }
        }

        bw.write(Integer.toString(count));
        bw.flush();

        br.close();
        bw.close();
    }
}
