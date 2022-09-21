import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Stack<Person> stack = new Stack<>();

        long answer = 0;

        while (N-- > 0) {
            Person person = new Person(Integer.parseInt(br.readLine()), 1);

            while (!stack.isEmpty() && stack.peek().getHeight() <= person.getHeight()) {
                Person currentPerson = stack.pop();

                if (currentPerson.getHeight() == person.getHeight()) {
                    person.addCount(currentPerson.getCount());
                }

                answer += currentPerson.getCount();
            }

            if (!stack.isEmpty()) {
                answer++;
            }

            stack.push(person);
        }

        bw.write(Long.toString(answer));
        bw.flush();

        br.close();
        bw.close();
    }

    private static class Person {

        private final int height;
        private int count;

        public Person(int height, int count) {
            this.height = height;
            this.count = count;
        }

        public int getHeight() {
            return height;
        }

        public int getCount() {
            return count;
        }

        public void addCount(int count) {
            this.count += count;
        }
    }
}
