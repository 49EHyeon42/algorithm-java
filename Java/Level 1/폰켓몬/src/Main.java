public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();

        // test 1
        int[] nums1 = {3, 1, 2, 3};
        int result1 = 2;

        System.out.println("test case 1 = " + (solution.solution(nums1) == result1));

        // test 2
        int[] nums2 = {3, 3, 3, 2, 2, 4};
        int result2 = 3;

        System.out.println("test case 2 = " + (solution.solution(nums2) == result2));

        // test 3
        int[] nums3 = {3, 3, 3, 2, 2, 2};
        int result3 = 2;

        System.out.println("test case 3 = " + (solution.solution(nums3) == result3));
    }
}
