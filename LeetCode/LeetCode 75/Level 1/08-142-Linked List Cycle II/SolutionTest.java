import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    @DisplayName("Linked List Cycle II 예제 1번 테스트")
    void detectCycle_example_1_test() {
        Solution solution = new Solution();

        // given
        ListNode input = getListNode(List.of(3, 2, 0, 4));
        ListNode output = input.next;

        // when
        ListNode result = solution.detectCycle(input);

        // then
        assertTrue(isSame(result, output));
    }

    @Test
    @DisplayName("Linked List Cycle II 예제 2번 테스트")
    void detectCycle_example_2_test() {
        Solution solution = new Solution();

        // given
        ListNode input = getListNode(List.of(1, 2));
        ListNode output = input;

        // when
        ListNode result = solution.detectCycle(input);

        // then
        assertTrue(isSame(result, output));
    }

    @Test
    @DisplayName("Linked List Cycle II 예제 3번 테스트")
    void detectCycle_example_3_test() {
        Solution solution = new Solution();

        // given
        ListNode input = getListNode(List.of(1));
        ListNode output = null;

        // when
        ListNode result = solution.detectCycle(input);

        // then
        assertTrue(isSame(result, output));
    }

    ListNode getListNode(List<Integer> list) {
        ListNode head = new ListNode();
        ListNode currentNode = head;

        for (Integer integer : list) {
            ListNode newNode = new ListNode(integer);
            currentNode.next = newNode;
            currentNode = newNode;
        }

        return head.next;
    }

    boolean isSame(ListNode result, ListNode output) {
        while (result != null && output != null) {
            if (result.val != output.val) {
                return false;
            }

            result = result.next;
            output = output.next;
        }
        return true;
    }
}
