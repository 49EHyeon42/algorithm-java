import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        int vertexCount = 0;
        int edgeCount = 0;

        // Adjacency List
        ArrayList<LinkedList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < vertexCount; i++) {
            graph.add(i, new LinkedList<>());
        }

        for (int i = 0; i < edgeCount; i++) {
            int temp1 = 0;
            int temp2 = 0;
            graph.get(temp1).add(temp2);
            graph.get(temp2).add(temp1);
        }
    }
}
