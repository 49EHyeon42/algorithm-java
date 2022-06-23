import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    private static int c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        bw.write(Long.toString(pow(a, b)));

        bw.flush();
        bw.close();
    }

    private static long pow(int a, int b) {
        if (b == 1) {
            return a % c;
        }
        long temp = pow(a, b / 2);
        if (b % 2 == 1) {
            return (temp * temp % c) * a % c;
        }
        return temp * temp % c;
    }
}
