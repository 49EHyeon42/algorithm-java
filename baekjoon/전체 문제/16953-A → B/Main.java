import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        bw.write(Integer.toString(bfs(A, B)));
        bw.flush();

        br.close();
        bw.close();
    }

    private static int bfs(int A, int B) {
        Set<Integer> visited = new HashSet<>();

        visited.add(A);

        Queue<Node> queue = new ArrayDeque<>();

        queue.offer(new Node(A, 1));

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();

            if (currentNode.number == B) {
                return currentNode.count;
            }

            int nextNumber = currentNode.number * 2;

            if (nextNumber < currentNode.number || nextNumber > B) {
                continue;
            }

            if (visited.contains(nextNumber)) {
                continue;
            }

            queue.offer(new Node(nextNumber, currentNode.count + 1));

            nextNumber = currentNode.number * 10 + 1;

            if (nextNumber < currentNode.number || nextNumber > B) {
                continue;
            }

            if (visited.contains(nextNumber)) {
                continue;
            }

            queue.offer(new Node(nextNumber, currentNode.count + 1));
        }

        return -1;
    }

    private static class Node {

        final int number;
        final int count;

        Node(int number, int count) {
            this.number = number;
            this.count = count;
        }
    }
}
