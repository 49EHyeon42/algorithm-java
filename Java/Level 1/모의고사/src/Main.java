import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();

        // test 1
        int[] answers1 = {1, 2, 3, 4, 5};
        int[] result1 = {1};

        System.out.println("test case 1 = " + Arrays.equals(solution.solution(answers1), result1));

        // test 2
        int[] answers2 = {1, 3, 2, 4, 2};
        int[] result2 = {1, 2, 3};

        System.out.println("test case 2 = " + Arrays.equals(solution.solution(answers2), result2));
    }
}
