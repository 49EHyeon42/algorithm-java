import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();

        // test 1
        int[] prices1 = {1, 2, 3, 2, 3};
        int[] result1 = {4, 3, 1, 1, 0};

        System.out.println("test case 1 = " + Arrays.equals(solution.solution(prices1), result1));
    }
}
