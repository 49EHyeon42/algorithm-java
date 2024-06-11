import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // `indexOf()`를 사용하기 위해 `Deque<>` 대신 `LinkedList<>` 사용
        LinkedList<Integer> deque = new LinkedList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            deque.offer(i);
        }

        int[] array = new int[M];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            array[i] = Integer.parseInt(st.nextToken());

        }

        int min = 0;

        for (int i = 0; i < M; i++) {
            int targetIndex = deque.indexOf(array[i]);

            int centerIndex = deque.size() - targetIndex;

            if (targetIndex < centerIndex) {
                for (int j = 0; j < targetIndex; j++) {
                    deque.addLast(deque.pollFirst());
                    min++;
                }
            } else {
                for (int j = 0; j < centerIndex; j++) {
                    deque.addFirst(deque.pollLast());
                    min++;
                }
            }

            // target 제거
            deque.pollFirst();
        }

        bw.write(Integer.toString(min));
        bw.flush();

        br.close();
        bw.close();
    }
}
