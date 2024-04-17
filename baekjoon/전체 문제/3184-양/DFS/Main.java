import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    private static final Stack<Vertex> stack = new Stack<>();

    private static final int[][] dyx = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private static int R;
    private static int C;

    private static char[][] graph;
    private static boolean[][] visited;

    private static int numberOfSheep;
    private static int numberOfWolf;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        graph = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String string = br.readLine();

            for (int j = 0; j < C; j++) {
                graph[i][j] = string.charAt(j);
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (graph[i][j] != '#' && !visited[i][j]) {
                    dfs(i, j);
                }
            }
        }

        bw.write(numberOfSheep + " " + numberOfWolf);
        bw.flush();

        br.close();
        bw.close();
    }

    private static void dfs(int startY, int startX) {
        int sheep = 0;
        int wolf = 0;

        visited[startY][startX] = true;

        stack.push(new Vertex(startY, startX));

        while (!stack.isEmpty()) {
            Vertex currentVertex = stack.pop();

            if (graph[currentVertex.y][currentVertex.x] == 'o') {
                sheep++;
            } else if (graph[currentVertex.y][currentVertex.x] == 'v') {
                wolf++;
            }

            for (int i = 0; i < 4; i++) {
                int nextY = currentVertex.y + dyx[i][0];
                int nextX = currentVertex.x + dyx[i][1];

                if (nextY < 0 || nextY >= R || nextX < 0 || nextX >= C) {
                    continue;
                }

                if (graph[nextY][nextX] == '#') {
                    continue;
                }

                if (visited[nextY][nextX]) {
                    continue;
                }

                visited[nextY][nextX] = true;

                stack.push(new Vertex(nextY, nextX));
            }
        }

        if (sheep > wolf) {
            numberOfSheep += sheep;
        } else {
            numberOfWolf += wolf;
        }
    }

    private static class Vertex {

        final int y;
        final int x;

        Vertex(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
