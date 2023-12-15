import java.io.*;
import java.util.*;

public class Main {

    private static final Queue<Vertex> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        boolean[] primeNumbers = findPrimeNumbers();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            Set<Integer> set = findPrimeNumbersBetweenAAndB(primeNumbers, A, B);

            sb.append(set.isEmpty() ? -1 : bfs(N, set)).append('\n');
        }

        bw.write(sb.toString().trim());
        bw.flush();

        br.close();
        bw.close();
    }

    private static boolean[] findPrimeNumbers() {
        boolean[] primeNumbers = new boolean[100001];

        for (int i = 2; i <= 100000; i++) {
            primeNumbers[i] = true;
        }

        for (int i = 0; i <= 100000; i++) {
            if (!primeNumbers[i]) {
                continue;
            }

            for (int j = i * 2; j <= 100000; j += i) {
                primeNumbers[j] = false;
            }
        }

        return primeNumbers;
    }

    private static Set<Integer> findPrimeNumbersBetweenAAndB(boolean[] primeNumbers, int A, int B) {
        Set<Integer> set = new HashSet<>();

        for (int i = A; i <= B; i++) {
            if (primeNumbers[i]) {
                set.add(i);
            }
        }

        return set;
    }

    private static int bfs(int N, Set<Integer> primeNumbers) {
        boolean[] visited = new boolean[1000001];

        visited[N] = true;

        queue.offer(new Vertex(N, 0));

        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.poll();

            if (primeNumbers.contains(currentVertex.number)) {
                queue.clear();
                return currentVertex.count;
            }

            int nextCount = currentVertex.count + 1;

            int nextNumber = currentVertex.number / 2;
            if (nextNumber > 1 && !visited[nextNumber]) {
                visited[nextNumber] = true;
                queue.offer(new Vertex(nextNumber, nextCount));
            }

            nextNumber = currentVertex.number / 3;
            if (nextNumber > 1 && !visited[nextNumber]) {
                visited[nextNumber] = true;
                queue.offer(new Vertex(nextNumber, nextCount));
            }

            nextNumber = currentVertex.number + 1;
            if (nextNumber < 100001 && !visited[nextNumber]) {
                visited[nextNumber] = true;
                queue.offer(new Vertex(nextNumber, nextCount));
            }

            nextNumber = currentVertex.number - 1;
            if (nextNumber > 1 && !visited[nextNumber]) {
                visited[nextNumber] = true;
                queue.offer(new Vertex(nextNumber, nextCount));
            }
        }

        // 항상 해가 있다.
        return -1;
    }

    private static class Vertex {

        final int number;
        final int count;

        Vertex(int number, int count) {
            this.number = number;
            this.count = count;
        }
    }
}
