import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main2 {

    private static int N;

    private static int[][] graph;
    private static boolean[][] visit;

    private static String bfs() {
        // [0] = Y, [1] = X
        CircularQueue queue = new CircularQueue(N * N);

        visit[0][0] = true;
        queue.enqueue(0, 0);

        while (!queue.isEmpty()) {
            int[] cc = queue.dequeue(); // cc = current coordinate

            // 오른쪽 이동
            if (isPossible(cc[0], cc[1] + graph[cc[0]][cc[1]]) &&
                    !visit[cc[0]][cc[1] + graph[cc[0]][cc[1]]]) {
                int nextY = cc[0];
                int nextX = cc[1] + graph[cc[0]][cc[1]];

                if (nextY == N - 1 && nextX == N - 1) {
                    return "HaruHaru";
                }

                visit[nextY][nextX] = true;
                queue.enqueue(nextY, nextX);
            }

            // 아래쪽 이동
            if (isPossible(cc[0] + graph[cc[0]][cc[1]], cc[1]) &&
                    !visit[cc[0] + graph[cc[0]][cc[1]]][cc[1]]) {
                int nextY = cc[0] + graph[cc[0]][cc[1]];
                int nextX = cc[1];

                if (nextY == N - 1 && nextX == N - 1) {
                    return "HaruHaru";
                }

                visit[nextY][nextX] = true;
                queue.enqueue(nextY, nextX);
            }
        }

        return "Hing";
    }

    private static boolean isPossible(int y, int x) {
        return y < N && x < N;
    }

    private static class CircularQueue {

        private int[][] array;
        private int front;
        private int rear;

        public CircularQueue(int maxSize) {
            array = new int[maxSize + 1][2];
        }

        public boolean isEmpty() {
            return front == rear;
        }

        public boolean isFull() {
            return (rear + 1) % array.length == front;
        }

        public void enqueue(int i, int j) {
            if (isFull()) {
                throw new IllegalStateException("The queue is full.");
            }

            rear = ++rear % array.length;

            array[rear][0] = i;
            array[rear][1] = j;
        }

        public int[] dequeue() {
            if (isEmpty()) {
                throw new IllegalStateException("The queue is empty.");
            }

            front = ++front % array.length;

            return array[front];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        graph = new int[N][N];
        visit = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bw.write(bfs());
        bw.flush();

        br.close();
        bw.close();
    }
}
