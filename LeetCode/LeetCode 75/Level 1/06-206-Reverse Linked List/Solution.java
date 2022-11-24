class Solution {

    public ListNode reverseList(ListNode head) {
        ListNode previousNode = null;
        ListNode currentNode = head;

        while (currentNode != null) {
            ListNode next = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = next;
        }

        return previousNode;
    }

    // Recursive Approach
    public ListNode reverseList2(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
    
        ListNode res = reverseList2(head.next);
        head.next.next = head;
        head.next = null;

        return res;
    }
}
