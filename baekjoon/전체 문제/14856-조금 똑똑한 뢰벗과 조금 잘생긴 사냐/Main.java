import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long N = Long.parseLong(br.readLine());

        List<Long> list = getFibonacci(N);

        List<Long> result = new ArrayList<>();

        for (int i = list.size() - 1; i >= 0; i--) {
            long l = list.get(i);

            if (l <= N) {
                result.add(l);
                N -= l;
            }

            if (N <= 0) {
                break;
            }
        }

        StringBuilder sb = new StringBuilder();

        if (N == 0) {
            sb.append(result.size()).append('\n');

            for (int i = result.size() - 1; i >= 0; i--) {
                sb.append(result.get(i)).append(' ');
            }
        } else {
            sb.append(-1);
        }

        bw.write(sb.toString().trim());
        bw.flush();

        br.close();
        bw.close();
    }

    private static List<Long> getFibonacci(long N) {
        List<Long> list = new ArrayList<>();
        list.add(1L);
        list.add(2L);

        int i = 2;

        while (true) {
            long l = list.get(i - 1) + list.get(i - 2);

            if (l > N) {
                break;
            }

            list.add(l);
            i++;
        }

        return list;
    }
}
