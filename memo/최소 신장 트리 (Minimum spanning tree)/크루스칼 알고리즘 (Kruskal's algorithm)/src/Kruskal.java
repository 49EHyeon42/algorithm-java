public class Kruskal {

    private final int[] parent;

    public Kruskal(int vertexCount) {
        parent = new int[vertexCount + 1];
        for (int i = 1; i <= vertexCount; i++) {
            parent[i] = i;
        }
    }

    public void merge(int x, int y) {
        int tempX = find(x);
        int tempY = find(y);
        if (tempX != tempY) {
            parent[tempY] = tempX;
        }
    }

    public boolean isUnion(int x, int y) {
        return find(x) == find(y);
    }

    private int find(int index) {
        return (parent[index] == index) ? index : (parent[index] = find(parent[index]));
    }
}
