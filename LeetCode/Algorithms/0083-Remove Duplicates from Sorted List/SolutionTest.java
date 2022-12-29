import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private final static Solution SOLUTION = new Solution();

    @Test
    @DisplayName("Remove Duplicates from Sorted List 예제 1번 테스트")
    void deleteDuplicates_example_1_test() {
        // given
        ListNode input = getListNode(List.of(1, 1, 2));
        ListNode output = getListNode(List.of(1, 2));

        // when
        ListNode result = SOLUTION.deleteDuplicates(input);

        // then
        assertTrue(isSame(output, result));
    }

    @Test
    @DisplayName("Remove Duplicates from Sorted List 예제 2번 테스트")
    void deleteDuplicates_example_2_test() {
        // given
        ListNode input = getListNode(List.of(1, 1, 2, 3, 3));
        ListNode output = getListNode(List.of(1, 2, 3));

        // when
        ListNode result = SOLUTION.deleteDuplicates(input);

        // then
        assertTrue(isSame(output, result));
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

    boolean isSame(ListNode output, ListNode result) {
        while (output != null && result != null) {
            if (output.val != result.val) {
                return false;
            }

            output = output.next;
            result = result.next;
        }

        return true;
    }
}
