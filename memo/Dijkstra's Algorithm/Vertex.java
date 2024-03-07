public class Vertex implements Comparable<Vertex> {

    private final int number;
    private final int weight;

    public Vertex(int number, int weight) {
        this.number = number;
        this.weight = weight;
    }

    public int getNumber() {
        return number;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Vertex otherVertex) {
        return this.weight - otherVertex.weight;
    }
}
