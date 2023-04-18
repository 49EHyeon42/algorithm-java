public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();

        // test 1
        int[] people1 = {70, 50, 80, 50};
        int limit1 = 100;
        int result1 = 3;

        System.out.println("test case 1 = " + (solution.solution(people1, limit1) == result1));

        // test 2
        int[] people2 = {70, 80, 50};
        int limit2 = 100;
        int result2 = 3;

        System.out.println("test case 2 = " + (solution.solution(people2, limit2) == result2));
    }
}
