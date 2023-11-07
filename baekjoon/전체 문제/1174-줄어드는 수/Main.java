import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final List<Long> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(Long.toString(getResult(Integer.parseInt(br.readLine()))));
        bw.flush();

        br.close();
        bw.close();
    }

    private static long getResult(int N) {
        if (N < 11) {
            return N - 1;
        }

        if (N > 1023) {
            return -1;
        }

        for (int i = 0; i < 10; i++) {
            backtracking(1, i);
        }

        list.sort(Long::compareTo);

        return list.get(N - 1);
    }

    private static void backtracking(int depth, long number) {
        if (depth > 10) {
            return;
        }

        list.add(number);

        for (int i = 0; i < number % 10; i++) {
            backtracking(depth + 1, number * 10 + i);
        }
    }
}
