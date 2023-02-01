package ch2_linked_lists;

public class KthToLast {
	public Node mySolution(Node head, int k) {
		Node slow = head, fast = head;
		
		for (int count = 1 ; count <= k - 1; count++) {
			fast = fast.next;
		}
		
		while (fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}
		
		return slow;
	}
	
	public static void main(String args[]) {
		KthToLast kthToLast = new KthToLast();
		Node testList = new Node(1, 2, 3, 4, 5, 6, 7, 8, 9);
		Node seven = kthToLast.mySolution(testList, 3);
		seven.printList();
	}
}
