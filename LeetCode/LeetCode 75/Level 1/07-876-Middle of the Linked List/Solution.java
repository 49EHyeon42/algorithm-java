class Solution {
    public ListNode middleNode(ListNode head) {
        int size = getSize(head);
        for (int i = 0; i < size / 2; i++) {
            head = head.next;
        }
        return head;
    }

    private int getSize(ListNode head) {
        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        return size;
    }
}
