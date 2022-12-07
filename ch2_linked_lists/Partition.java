package ch2_linked_lists;

public class Partition {
	public Node bookInspiredSolution1(Node head, int x) {
		Node n = head;
		Node smallHead = null;
		Node bigHead = null;
		Node small = null;
		Node big = null;
		
		while (n != null) {
			Node nextN = n.next;
			if (n.value < x) {
				if (smallHead == null) {
					smallHead = n;
					small = n;
				} else {
					small.next = n;
					small = small.next;
				}
			} else {
				if (bigHead == null) {
					bigHead = n;
					big = n;
				} else {
					big.next = n;
					big = big.next;
				}
			}
			n = nextN;
		}
		
		small.next = bigHead;
		big.next = null;
		return smallHead;
	}
	
	public Node bookInspiredSolution2(Node head, int x) {
		Node tail = head;
		Node n = head;

		while (n != null) {
			Node nextN = n.next;
			
			if (n.value < x) {
				n.next = head;
				head = n;
			} else {
				tail.next = n;
				tail = n;
			}
			
			n = nextN;
		}
		
		tail.next = null;
		return head;
	}
	
	public static void main (String args[]) {
		Partition p = new Partition();
		Node testList = new Node(3,5,8,5,10,2,1);
		Node partitionedList = p.bookInspiredSolution1(testList, 5);
		partitionedList.printList();
		
		testList = new Node(3,5,8,5,10,2,1);
		partitionedList = p.bookInspiredSolution1(testList, 5);
		partitionedList.printList();
	}
}
