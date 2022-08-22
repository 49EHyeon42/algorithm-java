import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();

        // test 1
        String[] genres1 = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays1 = {500, 600, 150, 800, 2500};
        int[] result1 = {4, 1, 3, 0};

        System.out.println(
            "test case 1 = " + (Arrays.equals(solution.solution(genres1, plays1), result1)));
    }
}
