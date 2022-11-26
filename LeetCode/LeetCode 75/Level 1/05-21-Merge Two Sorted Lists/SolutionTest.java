import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    @DisplayName("Merge Two Sorted Lists 예제 1번 테스트")
    void mergeTwoLists_example_1_test() {
        Solution solution = new Solution();

        // given
        ListNode inputList1 = getListNode(List.of(1, 2, 4));
        ListNode inputList2 = getListNode(List.of(1, 3, 4));
        ListNode output = getListNode(List.of(1, 1, 2, 3, 4, 4));

        // when
        ListNode result = solution.mergeTwoLists(inputList1, inputList2);

        // then
        assertEquals(true, isSame(output, result));
    }

    @Test
    @DisplayName("Merge Two Sorted Lists 예제 2번 테스트")
    void mergeTwoLists_example_2_test() {
        Solution solution = new Solution();

        // given
        ListNode inputList1 = getListNode(List.of());
        ListNode inputList2 = getListNode(List.of());
        ListNode output = getListNode(List.of());

        // when
        ListNode result = solution.mergeTwoLists(inputList1, inputList2);

        // then
        assertEquals(true, isSame(output, result));
    }

    @Test
    @DisplayName("Merge Two Sorted Lists 예제 3번 테스트")
    void mergeTwoLists_example_3_test() {
        Solution solution = new Solution();

        // given
        ListNode inputList1 = getListNode(List.of());
        ListNode inputList2 = getListNode(List.of(0));
        ListNode output = getListNode(List.of(0));

        // when
        ListNode result = solution.mergeTwoLists(inputList1, inputList2);

        // then
        assertEquals(true, isSame(output, result));
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
