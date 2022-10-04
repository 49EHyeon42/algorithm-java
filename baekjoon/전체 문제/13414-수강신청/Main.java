import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < L; i++) {
            String number = br.readLine();
            hashMap.put(number, i);
        }

        TreeSet<Student> treeSet = new TreeSet<>(Comparator.comparingInt(Student::getIndex));

        for (Entry<String, Integer> entry : hashMap.entrySet()) {
            treeSet.add(new Student(entry.getValue(), entry.getKey()));
        }

        int count = 0;

        StringBuilder sb = new StringBuilder();
        for (Student student : treeSet) {
            if (count == K) {
                break;
            }
            sb.append(student.getNumber()).append('\n');
            count++;
        }

        bw.write(sb.toString().trim());
        bw.flush();

        br.close();
        bw.close();
    }

    private static class Student {

        private final int index;
        private final String number;

        public Student(int index, String number) {
            this.index = index;
            this.number = number;
        }

        public int getIndex() {
            return index;
        }

        public String getNumber() {
            return number;
        }
    }
}
