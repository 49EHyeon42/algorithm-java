import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Coordinate> coordinates = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 2; j++) {
                long x = Long.parseLong(st.nextToken());
                long y = Long.parseLong(st.nextToken());

                coordinates.add(new Coordinate(x, y));
            }
        }

        bw.write(isIntersect(coordinates) ? '1' : '0');

        bw.flush();
        bw.close();
    }

    private static boolean isIntersect(List<Coordinate> coordinates) {
        int abc = ccw(coordinates.get(0), coordinates.get(1), coordinates.get(2));
        int abd = ccw(coordinates.get(0), coordinates.get(1), coordinates.get(3));
        int cda = ccw(coordinates.get(2), coordinates.get(3), coordinates.get(0));
        int cdb = ccw(coordinates.get(2), coordinates.get(3), coordinates.get(1));

        return abc * abd < 0 && cda * cdb < 0;
    }

    private static int ccw(Coordinate a, Coordinate b, Coordinate c) {
        long operation = a.getX() * b.getY() + b.getX() * c.getY() + c.getX() * a.getY() -
            (b.getX() * a.getY() + c.getX() * b.getY() + a.getX() * c.getY());

        return Long.compare(operation, 0);
    }
}

class Coordinate {

    private final long x;
    private final long y;

    public Coordinate(long x, long y) {
        this.x = x;
        this.y = y;
    }

    public long getX() {
        return x;
    }

    public long getY() {
        return y;
    }
}
