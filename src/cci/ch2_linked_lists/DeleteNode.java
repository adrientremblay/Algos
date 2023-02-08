package cci.ch2_linked_lists;

public class DeleteNode {
	public Node mySolution(Node head, int v) {
		Node prev = null;
		Node n = head;
		
		while (n != null) {
			if (n.value == v) {
				if (n == head) {
					return n.next;
				}
				prev.next = n.next;
				break;
			} else {
				prev = n;
				n = n.next;
			}
		}
		
		return head;
	}
	
	// 2.3 Delete Middle Node in the book
	public void deleteNode(Node n) {
		if (n == null || n.next == null)
			return;
		
		n.value = n.next.value;
		n.next = n.next.next;
	}
	
	public static void main(String args[]) {
		DeleteNode deleteNode = new DeleteNode();
		
		Node testList = new Node(1,2,3,4,5,6);
		
		testList = deleteNode.mySolution(testList, 5);
		testList.printList();
		testList = deleteNode.mySolution(testList, 1);
		testList.printList();
		testList = deleteNode.mySolution(testList, 6);
		testList.printList();
		
		testList = new Node(1,2,3,4,5,6);
		Node five = testList.next.next.next.next;
		deleteNode.deleteNode(five);
		testList.printList();
	}
}
