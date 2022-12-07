import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SolutionTest {

    private final static Solution SOLUTION = new Solution();

    @Test
    @DisplayName("Add Two Numbers 예제 1번 테스트")
    void addTwoNumbers_example_1_test() {
        // given
        ListNode inputL1 = getListNode(List.of(2, 4, 3));
        ListNode inputL2 = getListNode(List.of(5, 6, 4));
        ListNode output = getListNode(List.of(7, 0, 8));

        // when
        ListNode result = SOLUTION.addTwoNumbers(inputL1, inputL2);

        // then
        assertTrue(isSame(output, result));
    }

    @Test
    @DisplayName("Add Two Numbers 예제 2번 테스트")
    void addTwoNumbers_example_2_test() {
        // given
        ListNode inputL1 = getListNode(List.of(0));
        ListNode inputL2 = getListNode(List.of(0));
        ListNode output = getListNode(List.of(0));

        // when
        ListNode result = SOLUTION.addTwoNumbers(inputL1, inputL2);

        // then
        assertTrue(isSame(output, result));
    }

    @Test
    @DisplayName("Add Two Numbers 예제 3번 테스트")
    void addTwoNumbers_example_3_test() {
        // given
        ListNode inputL1 = getListNode(List.of(9, 9, 9, 9, 9, 9, 9));
        ListNode inputL2 = getListNode(List.of(9, 9, 9, 9));
        ListNode output = getListNode(List.of(8, 9, 9, 9, 0, 0, 0, 1));

        // when
        ListNode result = SOLUTION.addTwoNumbers(inputL1, inputL2);

        // then
        assertTrue(isSame(output, result));
    }

    private ListNode getListNode(List<Integer> list) {
        ListNode result = new ListNode();
        ListNode currentNode = result;

        for (Integer integer : list) {
            currentNode.next = new ListNode(integer);
            currentNode = currentNode.next;
        }

        return result.next;
    }

    private boolean isSame(ListNode output, ListNode result) {
        while (output != null && result != null) {
            if (output.val != result.val) {
                return false;
            }

            output = output.next;
            result = result.next;
        }

        return output == null && result == null;
    }
}
