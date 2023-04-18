public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();

        // test 1
        int k1 = 80;
        int[][] dungeons1 = {{80, 20}, {50, 40}, {30, 10}};
        int result1 = 3;

        System.out.println("test case 1 = " + (solution.solution(k1, dungeons1) == result1));
    }
}
