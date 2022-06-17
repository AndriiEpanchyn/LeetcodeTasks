
public class Task06_RemoveDuplicatesInList {

	public static void run() {
		ListNode node1 = new ListNode(0);
		ListNode node2 = new ListNode(1);
		ListNode node3 = new ListNode(2);
		ListNode node4 = new ListNode(2);
		ListNode node5 = new ListNode(3);
		ListNode node6 = new ListNode(4);
		ListNode node7 = new ListNode(5);
		ListNode node8 = new ListNode(6);
		ListNode node9 = new ListNode(7);
		ListNode node10 = new ListNode(8);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		node7.next = node8;
		node8.next = node9;
		node9.next = node10;

		System.out.println((node1).printAllSequence());
		System.out.println(deleteDuplicates(node1).printAllSequence());
	}

	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null) {
			return null;
		}
		if (head.next == null) {
			return new ListNode(head.val);
		}
		ListNode answer = null;
		ListNode lastNode = null;
		ListNode current = head;
		ListNode prev = null;
		while (current.next != null) {
			if (prev == null) {
				if (current.val != current.next.val) {
					if (answer == null) {
						answer = new ListNode(current.val);
						lastNode = answer;
					} else {
						lastNode.next = new ListNode(current.val);
						lastNode = lastNode.next;
					}
				}
			} else if (current.val != prev.val && current.val != current.next.val) {
				if (answer == null) {
					answer = new ListNode(current.val);
					lastNode = answer;
				} else {
					lastNode.next = new ListNode(current.val);
					lastNode = lastNode.next;
				}
			}
			prev = current;
			current = current.next;
		}
		if (current.val != prev.val) {
			if (answer == null) {
				answer = new ListNode(current.val);
				lastNode = answer;
			} else {
				lastNode.next = new ListNode(current.val);
			}
		}
		return answer;
	}

	public ListNode deleteDuplicatesLeetCode(ListNode head) {
		// Doesn't create new structure from begin, it just uses the same structure and
		// reinstrall pointers on correct Node

		if (head == null)
			return null;
		ListNode FakeHead = new ListNode(0);
		FakeHead.next = head;
		ListNode pre = FakeHead;
		ListNode cur = head;
		while (cur != null) {
			while (cur.next != null && cur.val == cur.next.val) {
				cur = cur.next;
			}
			if (pre.next == cur) {
				pre = pre.next;
			} else {
				pre.next = cur.next;
			}
			cur = cur.next;
		}
		return FakeHead.next;
	}

}

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}

	public String printAllSequence() {
		ListNode current = this;
		StringBuilder answer = new StringBuilder("{");
		String toReturn = "null";
		if (this != null) {
			while (current.next != null) {
				answer.append(current.val + ", ");
				current = current.next;
			}
			answer.append(current.val + ", ");
			toReturn = answer.substring(0, answer.lastIndexOf(", ")) + "}";
		}
		return toReturn;
	}

}
