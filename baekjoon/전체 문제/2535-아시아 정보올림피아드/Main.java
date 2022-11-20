import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        List<Student> students = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int countryCode = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());

            students.add(new Student(countryCode, number, score));
        }

        students.sort((o1, o2) -> o2.getScore() - o1.getScore());

        StringBuilder sb = new StringBuilder();
        Map<Integer, Integer> countryCodeCount = new HashMap<>();

        for (int i = 0; i < 2; i++) {
            Student student = students.get(i);

            sb.append(student.getCountryCode()).append(' ').append(student.getNumber())
                .append('\n');
            countryCodeCount.put(student.getCountryCode(),
                countryCodeCount.getOrDefault(student.getCountryCode(), 0) + 1);
        }

        for (int i = 2; i < N; i++) {
            Student student = students.get(i);

            if (countryCodeCount.get(student.getCountryCode()) == null
                || countryCodeCount.get(student.getCountryCode()) < 2) {
                sb.append(student.getCountryCode()).append(' ').append(student.getNumber())
                    .append('\n');
                break;
            }
        }

        bw.write(sb.toString().trim());
        bw.flush();

        br.close();
        bw.close();
    }

    private static class Student {

        private final int countryCode;
        private final int number;
        private final int score;

        public Student(int countryCode, int number, int score) {
            this.countryCode = countryCode;
            this.number = number;
            this.score = score;
        }

        public int getCountryCode() {
            return countryCode;
        }

        public int getNumber() {
            return number;
        }

        public int getScore() {
            return score;
        }
    }
}
