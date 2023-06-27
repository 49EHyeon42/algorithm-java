import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    // 증명 : https://www.acmicpc.net/board/view/15979

    private static int gcd(int a, int b) {
        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        }

        while (b != 0) {
            int i = a % b;
            a = b;
            b = i;
        }

        return a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        bw.write(Integer.toString(M - gcd(N, M)));
        bw.flush();

        br.close();
        bw.close();
    }
}
