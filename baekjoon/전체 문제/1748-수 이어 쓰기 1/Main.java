import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int length = 0;

        // N - 1 + 1: N 중 1의 자리 수를 가진 수의 개수
        // N - 10 + 1: N 중 10의 자리 수를 가진 수의 개수
        // ...
        for (int i = 1; i <= N; i *= 10) {
            length += N - i + 1;
        }

        bw.write(Integer.toString(length));
        bw.flush();

        br.close();
        bw.close();
    }
}
