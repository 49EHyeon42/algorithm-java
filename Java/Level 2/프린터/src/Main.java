public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();

        // test 1
        int[] priorities1 = {2, 1, 3, 2};
        int location1 = 2;
        int result1 = 1;

        System.out.println(
            "test case 1 = " + (solution.solution(priorities1, location1) == result1));

        // test 2
        int[] priorities2 = {1, 1, 9, 1, 1, 1};
        int location2 = 0;
        int result2 = 5;

        System.out.println(
            "test case 2 = " + (solution.solution(priorities2, location2) == result2));
    }
}
