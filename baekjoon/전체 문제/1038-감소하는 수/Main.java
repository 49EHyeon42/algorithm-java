import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    private static long solution(int N) {
        if (N < 10) {
            return N;
        }

        if (N > 1022) {
            return -1;
        }

        List<Long> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            backtracking(list, 1, i);
        }

        list.sort(Comparator.naturalOrder());

        return list.get(N);
    }

    private static void backtracking(List<Long> list, int depth, long number) {
        if (depth > 10) { // length(9876543210) = 10
            return;
        }

        list.add(number);

        for (int i = 0; i < number % 10; i++) {
            backtracking(list, depth + 1, number * 10 + i);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(Long.toString(solution(Integer.parseInt(br.readLine()))));
        bw.flush();

        br.close();
        bw.close();
    }
}
