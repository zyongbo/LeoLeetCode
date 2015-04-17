package leo.algorithms;

/**
 * 
 * @author zyongbo
 * @problem You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order 
 * @problem and each of their nodes contain a single digit. Add the two numbers, and return it as a linked list.
 * @problem (2->4->3) + (5->6->4) = (7->0->8)
 * 
 */

public class _2_AddTwoNumbers {


	//-----------nested class---------
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}//end of nested class

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int carry = 0;
		ListNode res = new ListNode(0);
		ListNode cur1 = l1, cur2 = l2, head = res;
		while(cur1!=null || cur2!=null) {
			if(cur1!=null) {
				carry += cur1.val;
				cur1 = cur1.next;
			}
			if(cur2!=null) {
				carry += cur2.val;
				cur2 = cur2.next;
			}
			head.next = new ListNode(carry%10);
			head = head.next;
			carry /= 10;
		}
		if(carry==1) head.next = new ListNode(1);
		return res.next;
	}
	
	//iterative
	public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
		int sum, currBit, carry = 0;
		ListNode head = new ListNode(0);
		ListNode walk = head;
		while(l1!=null || l2!=null) {
			sum = (l1==null?0:l1.val) + (l2==null?0:l2.val) + carry;
			currBit = sum%10;
			carry = sum/10;
			walk.next = new ListNode(currBit);
			walk = walk.next;
			l1 = (l1==null?null:l1.next);
			l2 = (l2==null?null:l2.next);
		}
		if(carry>0)
			walk.next = new ListNode(carry);
		return head.next;
	}
	
	//recursion
	public ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
		return addTwoNumbers(l1, l2, 0);
	}
	private ListNode addTwoNumbers(ListNode l1, ListNode l2, int carry) {
		if(l1==null)
			return (carry==0?l2:addTwoNumbers(new ListNode(carry),l2,0));
		else if(l2==null)
			return (carry==0?l1:addTwoNumbers(l1, new ListNode(carry),0));
		else {
			int sum = l1.val + l2.val + carry;
			ListNode node = new ListNode(sum%10);
			node.next = addTwoNumbers(l1.next, l2.next, sum/10);
			return node;
		}
	}
}
