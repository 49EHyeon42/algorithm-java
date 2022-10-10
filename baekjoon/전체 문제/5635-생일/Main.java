import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        ArrayList<Student> students = new ArrayList<>();

        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());

            students.add(new Student(name, day, month, year));
        }

        students.sort((o1, o2) -> {
            if (o1.getYear() == o2.getYear()) {
                if (o1.getMonth() == o2.getMonth()) {
                    return Integer.compare(o1.getDay(), o2.getDay());
                }
                return Integer.compare(o1.getMonth(), o2.getMonth());
            }
            return Integer.compare(o1.getYear(), o2.getYear());
        });

        bw.write(students.get(students.size() - 1).getName() + "\n" + students.get(0).getName());
        bw.flush();

        br.close();
        bw.close();
    }

    private static class Student {

        private final String name;
        private final int day;
        private final int month;
        private final int year;

        public Student(String name, int day, int month, int year) {
            this.name = name;
            this.day = day;
            this.month = month;
            this.year = year;
        }

        public String getName() {
            return name;
        }

        public int getDay() {
            return day;
        }

        public int getMonth() {
            return month;
        }

        public int getYear() {
            return year;
        }
    }
}
