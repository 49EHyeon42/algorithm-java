import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();

        // test 1
        int[] array1 = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        int[] result1 = {5, 6, 3};

        System.out.println(
            "test case 1 = " + (Arrays.equals(solution.solution(array1, commands), result1)));
    }
}
