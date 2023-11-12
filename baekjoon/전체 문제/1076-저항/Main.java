import java.io.*;
import java.util.Map;

public class Main {

    private static final Map<String, Color> map = Map.of(
            "black", new Color(0, 1),
            "brown", new Color(1, 10),
            "red", new Color(2, 100),
            "orange", new Color(3, 1000),
            "yellow", new Color(4, 10000),
            "green", new Color(5, 100000),
            "blue", new Color(6, 1000000),
            "violet", new Color(7, 10000000),
            "grey", new Color(8, 100000000),
            "white", new Color(9, 1000000000)
    );

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(Long.toString(((long) map.get(br.readLine()).value * 10 + map.get(br.readLine()).value) * map.get(br.readLine()).product));
        bw.flush();

        br.close();
        bw.close();
    }

    private static class Color {

        final int value;
        final int product;

        Color(int value, int product) {
            this.value = value;
            this.product = product;
        }
    }
}
