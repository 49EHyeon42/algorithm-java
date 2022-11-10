import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        List<Long> solutions = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            solutions.add(Long.parseLong(st.nextToken()));
        }

        solutions.sort(Comparator.comparingLong(o -> o));

        StringBuilder sb = new StringBuilder();
        for (long i : getAnswer(solutions)) {
            sb.append(i).append(' ');
        }

        bw.write(sb.toString().trim());
        bw.flush();

        br.close();
        bw.close();
    }

    private static long[] getAnswer(List<Long> solutions) {
        long min = Long.MAX_VALUE;

        long[] answer = new long[3];

        for (int start = 0; start < solutions.size() - 2; start++) {
            int mid = start + 1;
            int end = solutions.size() - 1;

            while (mid < end) {
                long startValue = solutions.get(start);
                long midValue = solutions.get(mid);
                long endValue = solutions.get(end);

                long currentMin = startValue + midValue + endValue;

                if (currentMin == 0) {
                    return new long[]{startValue, midValue, endValue};
                }

                if (Math.abs(currentMin) < min) {
                    min = Math.abs(currentMin);

                    answer[0] = startValue;
                    answer[1] = midValue;
                    answer[2] = endValue;
                }

                if (currentMin < 0) {
                    mid++;
                } else {
                    end--;
                }
            }
        }

        return answer;
    }
}
