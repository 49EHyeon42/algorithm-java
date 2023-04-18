import java.util.ArrayList;

public class Solution {

    public String solution(int[] numbers) {
        ArrayList<String> stringNumbers = new ArrayList<>();

        for (int number : numbers) {
            stringNumbers.add(Integer.toString(number));
        }

        stringNumbers.sort(
            (o1, o2) -> Integer.compare(Integer.parseInt(o2 + o1), Integer.parseInt(o1 + o2)));

        StringBuilder sb = new StringBuilder();
        for (String stringNumber : stringNumbers) {
            sb.append(stringNumber);
        }

        String answer = sb.toString();
        return (answer.charAt(0) == '0') ? "0" : answer;
    }
}
