import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        BigInteger temp1 = BigInteger.ONE;
        BigInteger temp2 = BigInteger.ONE;

        for (int i = 0; i < M; i++) {
            temp1 = temp1.multiply(new BigInteger(String.valueOf(N - i)));
            temp2 = temp2.multiply(new BigInteger(String.valueOf(i + 1)));
        }

        bw.write(temp1.divide(temp2).toString());

        bw.flush();
        bw.close();
    }
}
