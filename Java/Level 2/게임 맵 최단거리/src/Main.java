public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();

        // test 1
        int[][] maps1 = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1},
            {0, 0, 0, 0, 1}};
        int answer1 = 11;

        System.out.println("test case 1 = " + (solution.solution(maps1) == answer1));

        // test 2
        int[][] maps2 = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 0},
            {0, 0, 0, 0, 1}};
        int answer2 = -1;

        System.out.println("test case 2 = " + (solution.solution(maps2) == answer2));
    }
}
