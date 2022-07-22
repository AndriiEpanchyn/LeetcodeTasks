package helpers;
public class ListNode {
		public int val;
		public ListNode next;

		ListNode() {
		}

		public ListNode(int val) {
			this.val = val;
		}

		public ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}

		@Override
		public String toString() {
			StringBuilder answer = new StringBuilder("{");
			ListNode current = this;
			while (current.next != null) {
				answer.append(current.val + " => ");
				current = current.next;
			}
			answer.append(current.val + "}");
			return answer.toString();
		}
	}
