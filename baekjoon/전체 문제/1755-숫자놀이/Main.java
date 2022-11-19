import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    private static final Map<Integer, String> MAP = Map.of(0, "zero", 1, "one", 2, "two", 3,
        "three", 4, "four", 5, "five", 6, "six", 7, "seven", 8, "eight", 9, "nine");

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        List<Number> list = new ArrayList<>();

        for (int i = M; i <= N; i++) {
            list.add(new Number(i));
        }

        list.sort(Comparator.comparing(Number::getString));

        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i).getValue()).append(' ');
            if (i % 10 == 9) {
                sb.append('\n');
            }
        }

        bw.write(sb.toString().trim());
        bw.flush();

        br.close();
        bw.close();
    }

    private static class Number {

        private final int value;
        private final String string;

        public Number(int value) {
            this.value = value;
            this.string =
                value >= 10 ? MAP.get(value / 10) + " " + MAP.get(value % 10) : MAP.get(value % 10);
        }

        public int getValue() {
            return value;
        }

        public String getString() {
            return string;
        }
    }
}
