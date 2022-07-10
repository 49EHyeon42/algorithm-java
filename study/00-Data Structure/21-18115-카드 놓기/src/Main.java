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

        Deque<Integer> deque = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());

        int[] skills = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = N - 1; i >= 0; i--) {
            skills[i] = Integer.parseInt(st.nextToken());
        }

        int currentCard = 1;
        for (int skill : skills) {
            if (skill == 1) {
                deque.offerFirst(currentCard);
            } else if (skill == 2) {
                int temp = deque.pollFirst();
                deque.offerFirst(currentCard);
                deque.offerFirst(temp);
            } else {
                deque.offerLast(currentCard);
            }

            currentCard++;
        }

        while (!deque.isEmpty()) {
            sb.append(deque.pollFirst()).append(' ');
        }

        bw.write(sb.toString().trim());

        bw.flush();
        bw.close();
    }
}
