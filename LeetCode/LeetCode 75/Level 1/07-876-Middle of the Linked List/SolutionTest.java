import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    @DisplayName("Middle of the Linked List 예제 1번 테스트")
    void middleNode_example_1_test() {
        Solution solution = new Solution();

        // given
        ListNode input = getListNode(List.of(1, 2, 3, 4, 5));
        ListNode output = getListNode(List.of(3, 4, 5));

        // when
        ListNode result = solution.middleNode(input);

        // then
        assertEquals(true, isSame(result, output));
    }

    @Test
    @DisplayName("Middle of the Linked List 예제 2번 테스트")
    void middleNode_example_2_test() {
        Solution solution = new Solution();

        // given
        ListNode input = getListNode(List.of(1, 2, 3, 4, 5, 6));
        ListNode output = getListNode(List.of(4, 5, 6));

        // when
        ListNode result = solution.middleNode(input);

        // then
        assertEquals(true, isSame(result, output));
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
