/* Reference
 * - https://hyeo-noo.tistory.com/130#:~:text=%ED%83%80%EC%9E%94%20%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98%EC%97%90%EC%84%9C%EB%8A%94%20%EB%B0%A9%EB%AC%B8%ED%95%A0,%EB%B2%88%EC%9C%BC%EB%A1%9C%20%EB%90%98%EB%8F%8C%EC%95%84%EA%B0%80%EA%B2%8C%20%EB%90%9C%EB%8B%A4.
 * - https://coloredrabbit.tistory.com/44
 * */

public class Main {

    public static void main(String[] args) {
        int vertexCount = 11;

        Tarjan tarjan = new Tarjan(vertexCount);

        tarjan.addEdge(1, 2);
        tarjan.addEdge(2, 3);
        tarjan.addEdge(3, 1);
        tarjan.addEdge(4, 2);
        tarjan.addEdge(4, 5);
        tarjan.addEdge(5, 7);
        tarjan.addEdge(7, 6);
        tarjan.addEdge(6, 5);
        tarjan.addEdge(8, 5);
        tarjan.addEdge(8, 9);
        tarjan.addEdge(9, 10);
        tarjan.addEdge(10, 11);
        tarjan.addEdge(11, 8);
        tarjan.addEdge(11, 3);

        // tarjan dfs 실행
        for (int i = 1; i <= vertexCount; i++) {
            if (tarjan.getDiscovered()[i] == 0) {
                tarjan.dfs(i);
            }
        }

//        for (int i = 1; i < scc.length; i++) {
//            System.out.println("i = " + i + " discovered = " + tarjan.getDiscovered()[i]);
//        }

        int[] scc = tarjan.getScc();
        for (int i = 1; i < scc.length; i++) {
            System.out.println("i = " + i + " scc = " + scc[i]);
        }
    }
}
