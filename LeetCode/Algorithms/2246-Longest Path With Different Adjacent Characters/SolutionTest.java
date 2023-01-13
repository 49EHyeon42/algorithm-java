import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SolutionTest {

    private final Solution SOLUTION = new Solution();

    @Test
    @DisplayName("Longest Path With Different Adjacent Characters 예제 1번 테스트")
    void longestPath_example_1_test() {
        // given
        int[] inputParent = {-1, 0, 0, 1, 1, 2};
        String inputS = "abacbe";
        int output = 3;

        // when
        int result = SOLUTION.longestPath(inputParent, inputS);

        // then
        assertEquals(output, result);
    }

    @Test
    @DisplayName("Longest Path With Different Adjacent Characters 예제 2번 테스트")
    void longestPath_example_2_test() {
        // given
        int[] inputParent = {-1, 0, 0, 0};
        String inputS = "aabc";
        int output = 3;

        // when
        int result = SOLUTION.longestPath(inputParent, inputS);

        // then
        assertEquals(output, result);
    }

    @Test
    @DisplayName("Longest Path With Different Adjacent Characters 추가 1번 테스트")
    void longestPath_add_1_test() {
        // given
        int[] inputParent = {-1, 0, 0};
        String inputS = "acb";
        int output = 3;

        // when
        int result = SOLUTION.longestPath(inputParent, inputS);

        // then
        assertEquals(output, result);
    }

    @Test
    @DisplayName("Longest Path With Different Adjacent Characters 추가 2번 테스트")
    void longestPath_add_2_test() {
        // given
        int[] inputParent = {-1, 0, 0};
        String inputS = "aab";
        int output = 2;

        // when
        int result = SOLUTION.longestPath(inputParent, inputS);

        // then
        assertEquals(output, result);
    }

    @Test
    @DisplayName("Longest Path With Different Adjacent Characters 추가 3번 테스트")
    void longestPath_add_3_test() {
        // given
        int[] inputParent = {-1, 0, 0, 2, 2};
        String inputS = "aaabc";
        int output = 3;

        // when
        int result = SOLUTION.longestPath(inputParent, inputS);

        // then
        assertEquals(output, result);
    }

    @Test
    @DisplayName("Longest Path With Different Adjacent Characters 추가 4번 테스트")
    void longestPath_add_4_test() {
        // given
        int[] inputParent = {-1, 0, 0, 2, 2};
        String inputS = "aabcd";
        int output = 3;

        // when
        int result = SOLUTION.longestPath(inputParent, inputS);

        // then
        assertEquals(output, result);
    }

    @Test
    @DisplayName("Longest Path With Different Adjacent Characters 추가 5번 테스트")
    void longestPath_add_5_test() {
        // given
        int[] inputParent = {-1};
        String inputS = "z";
        int output = 1;

        // when
        int result = SOLUTION.longestPath(inputParent, inputS);

        // then
        assertEquals(output, result);
    }

    @Test
    @DisplayName("Longest Path With Different Adjacent Characters 추가 6번 테스트")
    void longestPath_add_6_test() {
        // given
        int[] inputParent = {-1, 137, 65, 60, 73, 138, 81, 17, 45, 163, 145, 99, 29, 162, 19, 20,
                132, 132, 13, 60, 21, 18, 155, 65, 13, 163, 125, 102, 96, 60, 50, 101, 100, 86, 162,
                42, 162, 94, 21, 56, 45, 56, 13, 23, 101, 76, 57, 89, 4, 161, 16, 139, 29, 60, 44,
                127, 19, 68, 71, 55, 13, 36, 148, 129, 75, 41, 107, 91, 52, 42, 93, 85, 125, 89,
                132, 13, 141, 21, 152, 21, 79, 160, 130, 103, 46, 65, 71, 33, 129, 0, 19, 148, 65,
                125, 41, 38, 104, 115, 130, 164, 138, 108, 65, 31, 13, 60, 29, 116, 26, 58, 118, 10,
                138, 14, 28, 91, 60, 47, 2, 149, 99, 28, 154, 71, 96, 60, 106, 79, 129, 83, 42, 102,
                34, 41, 55, 31, 154, 26, 34, 127, 42, 133, 113, 125, 113, 13, 54, 132, 13, 56, 13,
                42, 102, 135, 130, 75, 25, 80, 159, 39, 29, 41, 89, 85, 19};
        String inputS = "ajunvefrdrpgxltugqqrwisyfwwtldxjgaxsbbkhvuqeoigqssefoyngykgtthpzvsxgxrqedntvsjcpdnupvqtroxmbpsdwoswxfarnixkvcimzgvrevxnxtkkovwxcjmtgqrrsqyshxbfxptuvqrytctujnzzydhpal";
        int output = 17;

        // when
        int result = SOLUTION.longestPath(inputParent, inputS);

        // then
        assertEquals(output, result);
    }
}
