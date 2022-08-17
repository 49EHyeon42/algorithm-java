import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(Integer.toString(greedy(Integer.parseInt(br.readLine()))));

        bw.flush();
        bw.close();
    }

    private static int greedy(int N) {
        int remainderOfFive = N % 5;

        if (N == 1 || N == 3) {
            return -1;
        } else if (remainderOfFive % 2 == 0) {
            return N / 5 + remainderOfFive / 2;
        } else {
            return N / 5 + (remainderOfFive + 5) / 2 - 1;
        }
    }
}
