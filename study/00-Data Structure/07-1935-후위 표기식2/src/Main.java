import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Double> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());

        String string = br.readLine();

        Double[] array = new Double[N];

        for (int i = 0; i < N; i++) {
            array[i] = Double.parseDouble(br.readLine());
        }

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '+' || string.charAt(i) == '-' || string.charAt(i) == '*'
                || string.charAt(i) == '/') {
                Double a = stack.pop();
                Double b = stack.pop();

                switch (string.charAt(i)) {
                    case '+':
                        stack.push(a + b);
                        break;
                    case '-':
                        stack.push(b - a);
                        break;
                    case '*':
                        stack.push(a * b);
                        break;
                    case '/':
                        stack.push(b / a);
                        break;
                }
            } else {
                stack.push(array[string.charAt(i) - 'A']);
            }
        }

        bw.write(String.format("%.2f", stack.pop()));

        bw.flush();
        bw.close();
    }
}
