class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode currentNode = result;

        int sum = 0;

        while (l1 != null || l2 != null) {
            sum /= 10;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            currentNode.next = new ListNode(sum % 10);
            currentNode = currentNode.next;
        }

        if (sum / 10 == 1) {
            currentNode.next = new ListNode(1);
        }

        return result.next;
    }
}
