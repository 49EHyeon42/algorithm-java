/* Reference
 * - https://velog.io/@kimdukbae/%ED%81%AC%EB%A3%A8%EC%8A%A4%EC%B9%BC-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-Kruskal-Algorithm
 * - https://ongveloper.tistory.com/376
 * */

public class Main {

    public static void main(String[] args) {
        int vertexCount = 7;

        Graph graph = new Graph(vertexCount);

        graph.addEdge(1, 2, 29);
        graph.addEdge(1, 6, 75);
        graph.addEdge(2, 3, 35);
        graph.addEdge(2, 6, 34);
        graph.addEdge(3, 4, 7);
        graph.addEdge(4, 6, 23);
        graph.addEdge(4, 7, 13);
        graph.addEdge(5, 6, 53);
        graph.addEdge(6, 7, 25);

        Prim prim = new Prim(graph.getGraph(), vertexCount);

        System.out.println("minimum weight = " + prim.prim(1));
    }
}
