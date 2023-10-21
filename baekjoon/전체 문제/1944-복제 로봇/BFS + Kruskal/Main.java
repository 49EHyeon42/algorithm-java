import java.io.*;
import java.util.*;

public class Main {

    private static final int[] dy = {1, -1, 0, 0};
    private static final int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int mazeSize = Integer.parseInt(st.nextToken());
        int numberOfKeys = Integer.parseInt(st.nextToken());

        char[][] maze = new char[mazeSize][mazeSize];

        // for문을 사용할 수 있지만, vertex number를 빠르게 찾기 위해 사용
        int[][] vertex = new int[mazeSize][mazeSize];

        Coordinate robot = new Coordinate();

        Coordinate[] coordinates = new Coordinate[numberOfKeys + 1];
        coordinates[0] = robot;

        for (int i = 0, vertexCount = 1; i < mazeSize; i++) {
            String string = br.readLine();

            for (int j = 0; j < mazeSize; j++) {
                maze[i][j] = string.charAt(j);

                if (maze[i][j] == 'S') {
                    robot.init(i, j);
                    // vertex[i][j] = 0
                } else if (maze[i][j] == 'K') {
                    coordinates[vertexCount] = new Coordinate(i, j);
                    vertex[i][j] = vertexCount++;
                }
            }
        }

        List<Edge> edges = new ArrayList<>();

        bfs(maze, vertex, coordinates, edges);

        edges.sort(Comparator.comparingInt(edge -> edge.weight));

        // Kruskal

        int minimumWeight = 0;

        Kruskal kruskal = new Kruskal(numberOfKeys + 1);

        for (Edge edge : edges) {
            if (!kruskal.isUnion(edge.vertex1, edge.vertex2)) {
                kruskal.merge(edge.vertex1, edge.vertex2);

                minimumWeight += edge.weight;
            }
        }

        bw.write(Integer.toString(kruskal.isUnionAll() ? minimumWeight : -1));

        bw.flush();
        bw.close();
    }

    private static void bfs(char[][] maze, int[][] vertex, Coordinate[] coordinates, List<Edge> edges) {
        Queue<Coordinate> queue = new LinkedList<>();

        for (int i = 0; i < coordinates.length; i++) {
            Coordinate startCoordinate = coordinates[i];

            int[][] graph = new int[maze.length][maze.length];

            queue.offer(startCoordinate);
            graph[startCoordinate.y][startCoordinate.x] = 0;

            while (!queue.isEmpty()) {
                Coordinate currentCoordinate = queue.poll();

                for (int j = 0; j < 4; j++) {
                    int nextY = currentCoordinate.y + dy[j];
                    int nextX = currentCoordinate.x + dx[j];

                    if (!isPossibleRange(maze.length, nextY, nextX) || maze[nextY][nextX] == '1' || graph[nextY][nextX] != 0) {
                        continue;
                    }

                    queue.offer(new Coordinate(nextY, nextX));

                    graph[nextY][nextX] = graph[currentCoordinate.y][currentCoordinate.x] + 1;

                    if (!(startCoordinate.y == nextY && startCoordinate.x == nextX) && (maze[nextY][nextX] == 'S' || maze[nextY][nextX] == 'K')) {
                        edges.add(new Edge(i, vertex[nextY][nextX], graph[nextY][nextX]));
                    }
                }
            }
        }
    }

    private static boolean isPossibleRange(int maxSize, int y, int x) {
        return y >= 0 && y < maxSize && x >= 0 && x < maxSize;
    }

    // vertex 반복문으로 찾기
    private static int coordinateToVertexNumber(Coordinate[] coordinates, int y, int x) {
        for (int i = 0; i < coordinates.length; i++) {
            if (coordinates[i].y == y && coordinates[i].x == x) {
                return i;
            }
        }

        return -1;
    }

    private static class Coordinate {

        int y;
        int x;

        Coordinate() {

        }

        Coordinate(int y, int x) {
            init(y, x);
        }

        void init(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }


    private static class Edge {

        private final int vertex1;
        private final int vertex2;
        private final int weight;


        Edge(int vertex1, int vertex2, int weight) {
            this.vertex1 = vertex1;
            this.vertex2 = vertex2;
            this.weight = weight;
        }
    }

    private static class Kruskal {

        // private
        final int[] parent;

        Kruskal(int vertexCount) {
            parent = new int[vertexCount];
            for (int i = 0; i < vertexCount; i++) {
                parent[i] = i;
            }
        }

        // public
        void merge(int x, int y) {
            int tempX = find(x);
            int tempY = find(y);
            if (tempX != tempY) {
                parent[tempY] = tempX;
            }
        }

        // public
        boolean isUnion(int x, int y) {
            return find(x) == find(y);
        }

        // public
        boolean isUnionAll() {
            int p = 0;

            for (int i = 1; i < parent.length; i++) {
                if (!isUnion(p, i)) {
                    return false;
                }
            }

            return true;
        }

        // private
        int find(int index) {
            return (parent[index] == index) ? index : (parent[index] = find(parent[index]));
        }
    }
}
