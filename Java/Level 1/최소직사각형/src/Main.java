public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();

        // test 1
        int[][] sizes1 = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        int result1 = 4000;

        System.out.println("test case 1 = " + (solution.solution(sizes1) == result1));

        // test 2
        int[][] sizes2 = {{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}};
        int result2 = 120;

        System.out.println("test case 2 = " + (solution.solution(sizes2) == result2));

        // test 3
        int[][] sizes3 = {{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}};
        int result3 = 133;

        System.out.println("test case 3 = " + (solution.solution(sizes3) == result3));
    }
}
