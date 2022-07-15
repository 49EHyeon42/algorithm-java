public class Vertex implements Comparable<Vertex> {

    private final int value;
    private final int weight;

    public Vertex(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }

    public int getValue() {
        return value;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Vertex o) {
        return this.weight - o.weight;
    }
}
