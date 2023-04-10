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
        StringBuilder sb = new StringBuilder();

        Student[] students = new Student[101];

        int count = 1;

        while (true) {
            int n = Integer.parseInt(br.readLine());

            if (n == 0) {
                break;
            }

            sb.append(count++).append(' ');

            for (int i = 1; i <= n; i++) {
                students[i] = new Student(br.readLine());
            }

            for (int i = 0; i < 2 * n - 1; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                int number = Integer.parseInt(st.nextToken());

                students[number].flag = !students[number].flag;

                // 생략 : 항상 A 또는 B가 나오기 때문
                st.nextToken();
            }

            for (int i = 1; i <= n; i++) {
                if (students[i].flag) {
                    sb.append(students[i].name).append('\n');
                    break;
                }
            }
        }

        bw.write(sb.toString().trim());
        bw.flush();

        br.close();
        bw.close();
    }

    private static class Student {

        public String name;
        public boolean flag;

        public Student(String name) {
            this.name = name;
        }
    }
}
