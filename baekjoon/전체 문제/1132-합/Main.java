import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        String[] strings = new String[N];

        Map<Character, Value> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            strings[i] = br.readLine();

            for (int index = 0, exponent = strings[i].length() - 1; index < strings[i].length();
                    index++, exponent--) {
                char currentChar = strings[i].charAt(index);

                Value value = map.get(currentChar);

                if (value == null) {
                    map.put(currentChar, new Value(currentChar, 0, true));
                    value = map.get(currentChar);
                }

                if (index == 0) {
                    value.canZero = false;
                }

                value.weight += (long) Math.pow(10, exponent);
            }
        }

        ArrayList<Value> list = new ArrayList<>(map.values());

        list.sort((v1, v2) -> Long.compare(v2.weight, v1.weight));

        // list.size() == 10 -> 0이 포함된 경우
        // !list.get(list.size() - 1).canZero -> 리스트 마지막이 0이 될 수 없는 경우
        if (list.size() == 10 && !list.get(list.size() - 1).canZero) {
            for (int i = list.size() - 2; i >= 0; i--) {
                if (list.get(i).canZero) {
                    Value temp = list.get(i);
                    list.remove(i);
                    list.add(temp);
                    break;
                }
            }
        }

        int[] values = new int[10];

        for (int i = 0, j = 9; i < list.size(); i++, j--) {
            values[list.get(i).c - 'A'] = j;
        }

        long sum = 0;

        for (String string : strings) {
            for (int index = 0, exponent = string.length() - 1; index < string.length();
                    index++, exponent--) {
                sum += values[string.charAt(index) - 'A'] * (long) Math.pow(10, exponent);
            }
        }

        bw.write(Long.toString(sum));
        bw.flush();

        br.close();
        bw.close();
    }

    private static class Value {

        private final char c;
        private long weight;
        private boolean canZero;

        public Value(char c, long weight, boolean canZero) {
            this.c = c;
            this.weight = weight;
            this.canZero = canZero;
        }
    }
}
