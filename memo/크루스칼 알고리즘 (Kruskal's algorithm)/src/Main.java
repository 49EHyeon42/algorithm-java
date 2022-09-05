/* Reference
 * - https://data-make.tistory.com/527
 * - https://velog.io/@kimdukbae/%ED%81%AC%EB%A3%A8%EC%8A%A4%EC%B9%BC-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-Kruskal-Algorithm
 * */

import java.util.ArrayList;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        int vertexCount = 7;

        Graph graph = new Graph();
        Kruskal kruskal = new Kruskal(vertexCount);

        graph.addEdge(1, 2, 29);
        graph.addEdge(1, 6, 75);
        graph.addEdge(2, 3, 35);
        graph.addEdge(2, 6, 34);
        graph.addEdge(3, 4, 7);
        graph.addEdge(4, 6, 23);
        graph.addEdge(4, 7, 13);
        graph.addEdge(5, 6, 53);
        graph.addEdge(6, 7, 25);

        ArrayList<Edge> edges = graph.getEdges();

        edges.sort(Comparator.comparingInt(Edge::getWeight));

        int minWeight = 0;

        for (Edge edge : edges) {
            if (!kruskal.isUnion(edge.getVertex1(), edge.getVertex2())) {
                System.out.println(
                    "connected vertex1 = " + edge.getVertex1() + " vertex2 = " + edge.getVertex2());

                kruskal.merge(edge.getVertex1(), edge.getVertex2());

                minWeight += edge.getWeight();
            }
        }

        System.out.println("minimum weight = " + minWeight);
    }
}
