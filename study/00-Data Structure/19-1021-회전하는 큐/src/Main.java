import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        LinkedList<Integer> deque = new LinkedList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            deque.addLast(i);
        }

        int[] array = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int min = 0;
        for (int i = 0; i < M; i++) {
            int index = deque.indexOf(array[i]);
            int indexHalf = (deque.size() % 2 == 0) ? deque.size() / 2 - 1 : deque.size() / 2;

            if (index <= indexHalf) {
                for (int j = 0; j < index; j++) {
                    deque.addLast(deque.pollFirst());
                    min++;
                }
            } else {
                for (int j = 0; j < deque.size() - index; j++) {
                    deque.addFirst(deque.pollLast());
                    min++;
                }
            }

            deque.pollFirst();
        }

        bw.write(Integer.toString(min));

        bw.flush();
        bw.close();
    }
}
