import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        ArrayList<Coordinate> coordinates = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());

            coordinates.add(new Coordinate(x, y));
        }

        double answer = 0;
        for (int i = 1; i < N - 1; i++) {
            double x1 = coordinates.get(0).getX();
            double x2 = coordinates.get(i).getX();
            double x3 = coordinates.get(i + 1).getX();
            double y1 = coordinates.get(0).getY();
            double y2 = coordinates.get(i).getY();
            double y3 = coordinates.get(i + 1).getY();

            answer += ((x1 * y2 + x2 * y3 + x3 * y1) - (x2 * y1 + x3 * y2 + x1 * y3)) / 2;
        }

        bw.write(String.format("%.1f", Math.abs(answer)));

        bw.flush();
        bw.close();
    }
}

class Coordinate {

    private final double x;
    private final double y;

    public Coordinate(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
