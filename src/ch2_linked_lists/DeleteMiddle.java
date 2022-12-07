package ch2_linked_lists;

// I misunderstood the problem
public class DeleteMiddle {
	public void mySolution(Node head) {
		if (head == null || head.next == null || head.next.next == null)
			return;
		
		Node slow = head, fast = head.next.next;
		while (fast != null && fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		slow.next = slow.next.next;
	}
	
	public static void main(String args[]) {
		Node testList = new Node(1, 2, 3, 4, 5, 6);
		DeleteMiddle dm = new DeleteMiddle();
		dm.mySolution(testList);
		testList.printList();
	}
}
