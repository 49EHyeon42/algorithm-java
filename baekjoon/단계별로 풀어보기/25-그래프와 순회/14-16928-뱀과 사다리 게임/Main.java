import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final int MAX_SIZE = 100;

    private static int[] move;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int ladderNumber = Integer.parseInt(st.nextToken());
        int snakeNumber = Integer.parseInt(st.nextToken());

        move = new int[MAX_SIZE + 1];

        for (int i = 0; i < ladderNumber + snakeNumber; i++) {
            st = new StringTokenizer(br.readLine());
            move[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }

        bw.write(Integer.toString(bfs() - 1));

        bw.flush();
        bw.close();
    }

    private static int bfs() {
        Queue<Integer> queue = new LinkedList<>();
        int[] isVisited = new int[MAX_SIZE + 1];

        queue.offer(1);
        isVisited[1] = 1;

        while (!queue.isEmpty()) {
            int currentLocation = queue.poll();

            if (currentLocation == MAX_SIZE) {
                return isVisited[100];
            }

            for (int i = 1; i <= 6; i++) {
                int tempLocation = currentLocation + i;
                if (tempLocation > MAX_SIZE) {
                    break;
                }

                if (move[tempLocation] != 0) {
                    tempLocation = move[tempLocation];
                }

                if (isVisited[tempLocation] == 0) {
                    isVisited[tempLocation] = isVisited[currentLocation] + 1;
                    queue.offer(tempLocation);
                }
            }
        }

        return -1;
    }
}
