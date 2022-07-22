package LeetCodeTasks;

import helpers.ListNode;

public class Task019_RemoveNthNodeFromEndOfList {

	public static void run() {
		ListNode node11 = new ListNode(0);
		ListNode node10 = new ListNode(10, node11);
		ListNode node9 = new ListNode(9, node10);
		ListNode node8 = new ListNode(8, node9);
		ListNode node7 = new ListNode(7, node8);
		ListNode node6 = new ListNode(6, node7);
		ListNode node5 = new ListNode(5, node6);
		ListNode node4 = new ListNode(4, node5);
		ListNode node3 = new ListNode(3, node4);
		ListNode node2 = new ListNode(2, node3);
		ListNode node1 = new ListNode(1, node2);
		ListNode node0 = new ListNode(0, node1);

		System.out.println(node0);
		System.out.println(removeNthFromEnd(node0,8));

	}

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode answer = new ListNode(-1);
		answer.next=head;
		ListNode target = answer;
		ListNode current = answer;

		for (int i = n; i > 0; i--) {
				current = current.next;	
		}
		while(current.next!=null) {
			current = current.next;
			target = target.next;
			}
		target.next=target.next.next;
		return answer.next;
	}
	
	 public static ListNode removeNthFromEndLeetCode(ListNode head, int n) {
	       ListNode answer = new ListNode(0);
	       answer.next = head;
	       ListNode target = answer;
	       ListNode current = answer;
	       while(n>0){
	           current = current.next;
	           n--;
	       }
	       while(current.next!=null){
	           current = current.next;
	           target=target.next;
	       }
	       target.next = target.next.next;
	       return answer.next;
	    }
}
