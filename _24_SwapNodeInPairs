package leo.algorithms;

/**
 * 
 * @author zyongbo
 * @problem description: Given a linked list, swap every two adjacent nodes and return its head.
 * @example Given 1->2->3->4, you should return the list as 2->1->4->3.
 * @note your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed
 */
public class _24_SwapNodeInPairs<E> {

	//---------nested linked node definition-----------
	private static class SinglyLinkedListNode<E> {
		private E val;
		private SinglyLinkedListNode<E> next;
		
		@SuppressWarnings("unused")
		public SinglyLinkedListNode(E e, SinglyLinkedListNode<E> n) {
			val = e;
			next = n;
		}
		
		public SinglyLinkedListNode(E e) {
			val = e;
			next = null;
		}
		
		@SuppressWarnings("unused")
		public E getValue() {return val;}
		@SuppressWarnings("unused")
		public SinglyLinkedListNode<E> getNext() {return next;}
		@SuppressWarnings("unused")
		public void setValue(E e) {val = e;}
		@SuppressWarnings("unused")
		public void setNext(SinglyLinkedListNode<E> n) {next = n;}
	}
	
	private static class ListNode {
		@SuppressWarnings("unused")
		int val;
		ListNode next;
		
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public ListNode swapPairs1(ListNode head) {
		ListNode helper = new ListNode(0);
		helper.next = head;
		ListNode n1 = helper, n2 = head;
		
		while(n2!=null && n2.next!=null) {
			ListNode temp = n2.next.next;
			n2.next.next = n1.next;
			n1.next = n2.next;
			n2.next = temp;
			n1 = n2;
			n2 = n1.next;
		}
		return helper.next;
	}
	
	public SinglyLinkedListNode<E> swapPairs2(SinglyLinkedListNode<E> head) {
		if(head==null || head.next == null) return head;
		
		SinglyLinkedListNode<E> fakehead = new SinglyLinkedListNode<E>(null);
		fakehead.next = head;
		
		SinglyLinkedListNode<E> ptr1 = fakehead, ptr2 = head;
		
		while(ptr2!=null && ptr2.next!=null) {
			SinglyLinkedListNode<E> nextstart = ptr2.next.next;
			ptr2.next.next = ptr2;
			ptr1.next = ptr2.next;
			ptr2.next = nextstart;
			//prepare for the next iteration
			ptr1 = ptr2;
			ptr2 = ptr2.next;
		}
		return fakehead.next;
	}
	
    public ListNode swapPairs3(ListNode head) {
        if(head == null || head.next == null)
        return head;
     
        ListNode fakehead = new ListNode(-1);
        fakehead.next = head;
       
        ListNode ptr1 = fakehead;
        ListNode ptr2 = head;
       
        while(ptr2!=null && ptr2.next!=null){
            ListNode nextstart = ptr2.next.next;
            ptr2.next.next = ptr2;
            ptr1.next = ptr2.next;
            ptr2.next = nextstart;
            ptr1 = ptr2;
            ptr2 = ptr2.next;
        }
        return fakehead.next;
    }
}
