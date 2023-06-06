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

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        long result = 0;
        long length = 1;
        long nine = 9;

        while (k > nine * length) {
            k -= nine * length;

            result += nine;

            length++;
            nine *= 10;
        }

        result = (result + 1) + (k - 1) / length;

        bw.write(result > N ? "-1"
                : Character.toString(Long.toString(result).charAt((k - 1) % (int) length)));
        bw.flush();

        br.close();
        bw.close();
    }
}
