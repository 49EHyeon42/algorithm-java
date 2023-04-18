import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test 1
        int[] arr1 = {1, 1, 3, 3, 0, 1, 1};
        int[] answer1 = {1, 3, 0, 1};
        System.out.println("Test Case 1 = " + Arrays.equals(solution.solution(arr1), answer1));

        // Test 2
        int[] arr2 = {4, 4, 4, 3, 3};
        int[] answer2 = {4, 3};
        System.out.println("Test Case 2 = " + Arrays.equals(solution.solution(arr2), answer2));
    }
}
