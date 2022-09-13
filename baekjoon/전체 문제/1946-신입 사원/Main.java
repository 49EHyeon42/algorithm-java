import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            ArrayList<Employee> employees = new ArrayList<>();

            while (N-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int document = Integer.parseInt(st.nextToken());
                int interview = Integer.parseInt(st.nextToken());

                employees.add(new Employee(document, interview));
            }

            // 바로 정렬하는 방법도 있음
            employees.sort(Comparator.comparingInt(Employee::getDocument));

            int maxEmployee = 0;

            int maxInterview = employees.get(0).getInterview();
            for (Employee employee : employees) {
                if (maxInterview >= employee.getInterview()) {
                    maxEmployee++;

                    maxInterview = employee.getInterview();
                }
            }

            sb.append(maxEmployee).append('\n');
        }

        bw.write(sb.toString().trim());
        bw.flush();
    }

    private static class Employee {

        private final int document;
        private final int interview;

        public Employee(int document, int interview) {
            this.document = document;
            this.interview = interview;
        }

        public int getDocument() {
            return document;
        }

        public int getInterview() {
            return interview;
        }
    }
}
