import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final BabyShark babyShark = new BabyShark();

    private static final Queue<Vertex> queue = new LinkedList<>();

    private static final int[][] dyx = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private static int N;

    private static int[][] array;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        array = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                int number = Integer.parseInt(st.nextToken());

                if (number == 9) {
                    babyShark.y = i;
                    babyShark.x = j;

                    array[i][j] = 0;

                    continue;
                }

                array[i][j] = number;
            }
        }

        int time = 0;

        while (true) {
            Vertex eatVertex = bfs();

            // 아기 상어가 엄마 상어에게 도움을 요청하는 경우
            if (eatVertex.weight == Integer.MAX_VALUE) {
                break;
            }

            time += eatVertex.weight;

            // 물고기 먹기
            babyShark.eat++;

            if (babyShark.size == babyShark.eat) {
                babyShark.size++;

                babyShark.eat = 0;
            }

            // 먹은 물고기 제거
            array[eatVertex.y][eatVertex.x] = 0;

            babyShark.y = eatVertex.y;
            babyShark.x = eatVertex.x;
        }

        bw.write(Integer.toString(time));
        bw.flush();

        br.close();
        bw.close();
    }

    private static Vertex bfs() {
        Vertex eatVertex = new Vertex(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);

        boolean[][] visited = new boolean[N][N];

        visited[babyShark.y][babyShark.x] = true;

        queue.offer(new Vertex(babyShark.y, babyShark.x, 0));

        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextY = currentVertex.y + dyx[i][0];
                int nextX = currentVertex.x + dyx[i][1];

                if (nextY < 0 || nextY >= N || nextX < 0 || nextX >= N) {
                    continue;
                }

                if (visited[nextY][nextX]) {
                    continue;
                }

                if (array[nextY][nextX] > babyShark.size) {
                    continue;
                }

                // array[nextY][nextX] >= babyShark.size
                int nextWeight = currentVertex.weight + 1;

                visited[nextY][nextX] = true;

                queue.offer(new Vertex(nextY, nextX, nextWeight));

                if (array[nextY][nextX] == 0) {
                    continue;
                }

                if (array[nextY][nextX] < babyShark.size) {
                    // 거리는 아기 상어가 있는 칸에서 물고기가 있는 칸으로 이동할 때, 지나야하는 칸의 개수의 최솟값이다.
                    // 거리가 가까운 물고기가 많다면, 가장 위에 있는 물고기, 그러한 물고기가 여러마리라면, 가장 왼쪽에 있는 물고기를 먹는다.
                    if (eatVertex.weight > nextWeight) {
                        eatVertex.y = nextY;
                        eatVertex.x = nextX;
                        eatVertex.weight = nextWeight;
                    } else if (eatVertex.weight == nextWeight) {
                        if (eatVertex.y > nextY) {
                            eatVertex.y = nextY;
                            eatVertex.x = nextX;
                        } else if (eatVertex.y == nextY) {
                            if (eatVertex.x > nextX) {
                                eatVertex.x = nextX;
                            }
                        }
                    }
                }
            }
        }

        return eatVertex;
    }

    private static class BabyShark {

        int size = 2;
        int eat;
        int y;
        int x;
    }

    private static class Vertex {

        int y;
        int x;
        int weight;

        Vertex(int y, int x, int weight) {
            this.y = y;
            this.x = x;
            this.weight = weight;
        }
    }
}
