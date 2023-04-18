public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();

        // test 1
        int[] scoville1 = {1, 2, 3, 9, 10, 12};
        int K = 7;
        int result1 = 2;

        System.out.println("test case 1 = " + (solution.solution(scoville1, K) == result1));
    }
}
