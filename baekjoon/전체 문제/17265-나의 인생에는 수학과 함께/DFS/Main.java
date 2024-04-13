import java.io.*;
import java.util.Stack;

public class Main {

    private static final Stack<Vertex> stack = new Stack<>();

    private static final int[][] dyx = {{1, 0}, {0, 1}};

    private static int N;

    private static char[][] graph;

    private static int max = Integer.MIN_VALUE;
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        graph = new char[N][N];

        for (int i = 0; i < N; i++) {
            String string = br.readLine();

            for (int j = 0, k = 0; j < N; j++, k += 2) {
                graph[i][j] = string.charAt(k);
            }
        }

        dfs();

        bw.write(max + " " + min);
        bw.flush();

        br.close();
        bw.close();
    }

    private static void dfs() {
        stack.push(new Vertex(0, 0, graph[0][0] - '0'));

        while (!stack.isEmpty()) {
            Vertex currentVertex = stack.pop();

            if (currentVertex.y == N - 1 && currentVertex.x == N - 1) {
                max = Math.max(max, currentVertex.value);
                min = Math.min(min, currentVertex.value);

                continue;
            }

            for (int i = 0; i < 2; i++) {
                int nextY = currentVertex.y + dyx[i][0];
                int nextX = currentVertex.x + dyx[i][1];

                if (nextY < 0 || nextY >= N || nextX < 0 || nextX >= N) {
                    continue;
                }

                // 숫자, 연산자, ... 규칙성을 이루며, 홀수로 되어있고, 최단 거리 이동이 명시되었기 때문에 아래의 로직이 가능

                if (graph[nextY][nextX] < 48) { // ASCII, 다음이 연산자라 라면
                    stack.push(new Vertex(nextY, nextX, currentVertex.value, graph[nextY][nextX]));
                } else {
                    stack.push(new Vertex(nextY, nextX, calculation(currentVertex.operator, currentVertex.value, graph[nextY][nextX] - '0')));
                }
            }
        }
    }

    private static int calculation(char operator, int i, int j) {
        if (operator == '+') {
            return i + j;
        } else if (operator == '-') {
            return i - j;
        } else if (operator == '*') {
            return i * j;
        }

        throw new RuntimeException();
    }

    private static class Vertex {

        final int y;
        final int x;
        final int value;
        char operator;

        Vertex(int y, int x, int value) {
            this.y = y;
            this.x = x;
            this.value = value;
        }

        Vertex(int y, int x, int value, char operator) {
            this.y = y;
            this.x = x;
            this.value = value;
            this.operator = operator;
        }
    }
}
