import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    @DisplayName("Reverse Linked List 예제 1번 테스트")
    void reverseList_example_1_test() {
        Solution solution = new Solution();

        // given
        ListNode input = getListNode(List.of(1, 2, 3, 4, 5));
        ListNode output = getListNode(List.of(5, 4, 3, 2, 1));

        // when
        ListNode result = solution.reverseList(input);

        // then
        assertEquals(true, isSame(result, output));
    }

    @Test
    @DisplayName("Reverse Linked List 예제 2번 테스트")
    void reverseList_example_2_test() {
        Solution solution = new Solution();

        // given
        ListNode input = getListNode(List.of(1, 2));
        ListNode output = getListNode(List.of(2, 1));

        // when
        ListNode result = solution.reverseList(input);

        // then
        assertEquals(true, isSame(result, output));
    }

    @Test
    @DisplayName("Reverse Linked List 예제 3번 테스트")
    void reverseList_example_3_test() {
        Solution solution = new Solution();

        // given
        ListNode input = getListNode(List.of());
        ListNode output = getListNode(List.of());

        // when
        ListNode result = solution.reverseList(input);

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
        while (result != null || output != null) {
            if (result.val != output.val) {
                return false;
            }

            result = result.next;
            output = output.next;
        }
        return true;
    }
}
