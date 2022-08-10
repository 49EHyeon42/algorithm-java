import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// reference : https://johoonday.tistory.com/107?category=901651
public class Main {

    private static final List<Coordinate> coordinates = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < 2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 2; j++) {
                long x = Long.parseLong(st.nextToken());
                long y = Long.parseLong(st.nextToken());

                coordinates.add(new Coordinate(x, y));
            }
        }

        bw.write(isIntersect() ? '1' : '0');

        bw.flush();
        bw.close();
    }

    private static boolean isIntersect() {
        Coordinate a = coordinates.get(0);
        Coordinate b = coordinates.get(1);
        Coordinate c = coordinates.get(2);
        Coordinate d = coordinates.get(3);

        int ab = ccw(a, b, c) * ccw(a, b, d);
        int cd = ccw(c, d, a) * ccw(c, d, b);

        if (ab == 0 && cd == 0) {
            return isLine();
        }
        return ab <= 0 && cd <= 0;
    }

    private static int ccw(Coordinate a, Coordinate b, Coordinate c) {
        long operation = a.getX() * b.getY() + b.getX() * c.getY() + c.getX() * a.getY() -
            (b.getX() * a.getY() + c.getX() * b.getY() + a.getX() * c.getY());

        return Long.compare(operation, 0);
    }

    // Is it in one line segment?
    private static boolean isLine() {
        Coordinate a = coordinates.get(0);
        Coordinate b = coordinates.get(1);
        Coordinate c = coordinates.get(2);
        Coordinate d = coordinates.get(3);

        return (!isBetween(a, b, c) || !isBetween(a, b, d)) &&
            (!isBetween(b, a, c) || !isBetween(b, a, d));
    }

    // Is C between A and B?
    private static boolean isBetween(Coordinate a, Coordinate b, Coordinate c) {
        if (a.getX() < b.getX()) {
            return b.getX() < c.getX();
        } else if (a.getX() > b.getX()) {
            return b.getX() > c.getX();
        } else { // a.getX() == b.getX()
            if (a.getY() < b.getY()) {
                return b.getY() < c.getY();
            } else if (a.getY() > b.getY()) {
                return b.getY() > c.getY();
            } else { // a.getX() == b.getX() && a.getY() == b.getY()
                return a.getX() == c.getX() && a.getY() == c.getY();
            }
        }
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
