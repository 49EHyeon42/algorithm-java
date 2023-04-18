public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();

        // test 1
        int[] numbers1 = {6, 10, 2};
        String result1 = "6210";

        System.out.println("test case 1 = " + (solution.solution(numbers1).equals(result1)));

        // test 2
        int[] numbers2 = {3, 30, 34, 5, 9};
        String result2 = "9534330";

        System.out.println("test case 2 = " + (solution.solution(numbers2).equals(result2)));
    }
}
