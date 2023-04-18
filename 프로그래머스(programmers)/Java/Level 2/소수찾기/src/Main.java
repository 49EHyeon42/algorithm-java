public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();

        // test 1
        String numbers1 = "17";
        int result1 = 3;

        System.out.println("test case 1 = " + (solution.solution(numbers1) == result1));

        // test 2
        String numbers2 = "011";
        int result2 = 2;

        System.out.println("test case 2 = " + (solution.solution(numbers2) == result2));
    }
}
