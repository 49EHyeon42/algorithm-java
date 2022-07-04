import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Deque<Balloon> deque = new LinkedList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            deque.offerLast(new Balloon(i, Integer.parseInt(st.nextToken())));
        }

        while (true) {
            sb.append(deque.peek().getIndex()).append(' ');

            Balloon currentBalloon = deque.pollFirst();
            if (deque.isEmpty()) {
                break;
            }

            int currentBalloonNumber = currentBalloon.getNumber();
            if (currentBalloonNumber > 0) {
                for (int i = 0; i < (currentBalloonNumber - 1) % deque.size(); i++) {
                    deque.offerLast(deque.pollFirst());
                }
            } else {
                for (int i = 0; i < (Math.abs(currentBalloonNumber)) % deque.size(); i++) {
                    deque.offerFirst(deque.pollLast());
                }
            }
        }

        bw.write(sb.toString().trim());

        bw.flush();
        bw.close();
    }

    static class Balloon {

        int index;
        int number;

        Balloon(int index, int number) {
            this.index = index;
            this.number = number;
        }

        int getIndex() {
            return index;
        }

        int getNumber() {
            return number;
        }
    }
}
