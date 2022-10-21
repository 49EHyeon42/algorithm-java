import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        Coordinate a = new Coordinate(Integer.parseInt(st.nextToken()),
            Integer.parseInt(st.nextToken()));
        Coordinate b = new Coordinate(Integer.parseInt(st.nextToken()),
            Integer.parseInt(st.nextToken()));
        Coordinate c = new Coordinate(Integer.parseInt(st.nextToken()),
            Integer.parseInt(st.nextToken()));

        bw.write(getSlope(a, b) != getSlope(b, c) ? Double.toString(getAnswer(a, b, c)) : "-1.0");
        bw.flush();

        br.close();
        bw.close();
    }

    private static double getSlope(Coordinate a, Coordinate b) {
        return (double) Math.abs(a.getY() - b.getY()) / Math.abs(a.getX() - b.getX());
    }

    private static double getAnswer(Coordinate a, Coordinate b, Coordinate c) {
        double abLength = getLength(a, b);
        double bcLength = getLength(b, c);
        double acLength = getLength(a, c);

        double[] temp = new double[3];
        temp[0] = (abLength + bcLength) * 2;
        temp[1] = (bcLength + acLength) * 2;
        temp[2] = (abLength + acLength) * 2;
        Arrays.sort(temp);

        return temp[2] - temp[0];
    }

    private static double getLength(Coordinate a, Coordinate b) {
        return Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2));
    }

    private static class Coordinate {

        private final int x;
        private final int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}
