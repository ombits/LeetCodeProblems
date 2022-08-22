
/*
Given a non-negative integer represented as non-empty a singly linked list of digits, plus one to the integer.

You may assume the integer do not contain any leading zero, except the number 0 itself.

The digits are stored such that the most significant digit is at the head of the list.

Example :

Input: [1,2,3]
Output: [1,2,4]
 */
public class PlusOneLinkedList_369 {

    public static void main(String[] args ){
        ListNode head = new ListNode(9);
        head.next = new ListNode(9);
        head.next.next = new ListNode(9);
        head.next.next.next = new ListNode(9);
        PlusOneLinkedList_369 plusOneLinkedList_369 = new PlusOneLinkedList_369();
        plusOneLinkedList_369.plusOne(head);

    }
    public ListNode plusOne(ListNode head) {
        if(head == null)
            return new ListNode(1);

        int carry =  addOne(head);

        if(carry == 1){
            ListNode newHead = new ListNode(1);
            newHead.next = head;
            return newHead;
        }
        return head;

    }

    private int addOne(ListNode node){

        int carry = node.next == null ?  1 : addOne(node.next);
        int sum = carry + node.val;
        node.val = sum % 10;
        return sum / 10;

    }

}
