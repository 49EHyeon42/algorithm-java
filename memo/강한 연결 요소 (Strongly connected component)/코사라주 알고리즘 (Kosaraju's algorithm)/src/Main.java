/* Reference
 * - https://yjg-lab.tistory.com/188
 * - https://jooona.tistory.com/159
 * */

public class Main {

    public static void main(String[] args) {
        int vertexCount = 8;

        Kosaraju kosaraju = new Kosaraju(vertexCount);

        kosaraju.addEdge(1, 2);
        kosaraju.addEdge(2, 3);
        kosaraju.addEdge(3, 4);
        kosaraju.addEdge(4, 8);
        kosaraju.addEdge(8, 4);
        kosaraju.addEdge(4, 3);
        kosaraju.addEdge(3, 7);
        kosaraju.addEdge(7, 6);
        kosaraju.addEdge(6, 7);
        kosaraju.addEdge(2, 5);
        kosaraju.addEdge(5, 1);

        // 순방향 그래프, 역방향 그래프 정렬
        kosaraju.graphSort();

        // 순방향 그래프 dfs 로 스택 넣기
        for (int i = 1; i <= vertexCount; i++) {
            if (!kosaraju.getIsVisited()[i]) {
                kosaraju.dfs(i);
            }
        }

        // 방문 초기화
        kosaraju.initIsVisited();

        // 역방향 그래프 dfs 로 scc 찾기
        int number = 1;
        
        while (!kosaraju.getStack().isEmpty()) {
            int currentVertex = kosaraju.getStack().pop();

            if (!kosaraju.getIsVisited()[currentVertex]) {
                kosaraju.reverseDfs(currentVertex, number++);
            }
        }

        // 출력
        for (int i = 1; i < kosaraju.getScc().length; i++) {
            System.out.println("i = " + i + " scc = " + kosaraju.getScc()[i]);
        }
    }
}
