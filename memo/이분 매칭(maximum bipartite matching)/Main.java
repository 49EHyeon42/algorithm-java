import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        testExample1();
        testExample2();
    }

    private static void testExample1() {
        int vertexCount = 5;

        boolean[][] graph = new boolean[vertexCount][vertexCount];

        // zero to 0, 2, 4
        graph[0][0] = true;
        graph[0][2] = true;
        graph[0][4] = true;

        // one to 0, 1
        graph[1][0] = true;
        graph[1][1] = true;

        // two to 4
        graph[2][4] = true;

        // three to 2
        graph[3][2] = true;

        // four to 1
        graph[4][1] = true;

        BipartiteMatching bipartiteMatching = new BipartiteMatching(vertexCount, vertexCount,
                graph);

        System.out.println("1.");
        System.out.println("actual = " + bipartiteMatching.bipartiteMatching());
        System.out.println("expected = " + 4);
        System.out.println("StartMatch = " + Arrays.toString(bipartiteMatching.getStartMatch()));
        System.out.println("EndMatch = " + Arrays.toString(bipartiteMatching.getEndMatch()));
    }

    private static void testExample2() {
        int vertexCount = 4;

        boolean[][] graph = new boolean[vertexCount][vertexCount];

        // zero to 0, 1, 3
        graph[0][0] = true;
        graph[0][1] = true;
        graph[0][3] = true;

        // one to 0, 1
        graph[1][0] = true;
        graph[1][1] = true;

        // two to 0, 2
        graph[2][0] = true;
        graph[2][2] = true;

        // three to 3
        graph[3][2] = true;
        graph[3][3] = true;

        BipartiteMatching bipartiteMatching = new BipartiteMatching(vertexCount, vertexCount,
                graph);

        System.out.println("2.");
        System.out.println("actual = " + bipartiteMatching.bipartiteMatching());
        System.out.println("expected = " + 4);
        System.out.println("StartMatch = " + Arrays.toString(bipartiteMatching.getStartMatch()));
        System.out.println("EndMatch = " + Arrays.toString(bipartiteMatching.getEndMatch()));
    }
}
