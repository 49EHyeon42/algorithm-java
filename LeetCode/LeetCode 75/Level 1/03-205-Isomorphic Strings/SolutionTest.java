import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    @DisplayName("Isomorphic Strings 예제 1번 테스트")
    void isIsomorphic_example_1_test() {
        Solution solution = new Solution();

        // given
        String inputS = "egg";
        String inputT = "add";
        boolean output = true;

        // when
        boolean result = solution.isIsomorphic(inputS, inputT);

        // then
        assertEquals(result, output);
    }

    @Test
    @DisplayName("Isomorphic Strings 예제 2번 테스트")
    void isIsomorphic_example_2_test() {
        Solution solution = new Solution();

        // given
        String inputS = "foo";
        String inputT = "bar";
        boolean output = false;

        // when
        boolean result = solution.isIsomorphic(inputS, inputT);

        // then
        assertEquals(result, output);
    }

    @Test
    @DisplayName("Isomorphic Strings 예제 3번 테스트")
    void isIsomorphic_example_3_test() {
        Solution solution = new Solution();

        // given
        String inputS = "paper";
        String inputT = "title";
        boolean output = true;

        // when
        boolean result = solution.isIsomorphic(inputS, inputT);

        // then
        assertEquals(result, output);
    }
}
