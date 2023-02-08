package cci.ch2_linked_lists;

public class SumLists {
	public Node reverseOrder(Node h1, Node h2) {
		Node h = new Node();
		Node n = h;
		int carry = 0;
		while (h1 != null || h2 != null) {
			int sum = carry;
			if (h1 != null) {
				sum += h1.value;
				h1 = h1.next;
			}
			if (h2 != null) {
				sum += h2.value;
				h2 = h2.next;
			}
			carry = sum / 10;
			sum -= carry * 10;
			
			n.next = new Node(sum);
			n = n.next;
		}
		
		if (carry != 0)
			n.next = new Node(carry);
	
		return h.next;
	}
	
	/**
	 * Recursive solution inspired by the book
	 * @param h1
	 * @param h2
	 * recursive method
	 */
	public Node forwardOrder(Node h1, Node h2) {
		if (h1 == null && h2 == null)
			return null;
		
		Node ret = new Node();
		
		int sum = 0;
		if (h1 != null) {
			sum += h1.value;
			h1 = h1.next;
		}
		if (h2 != null) {
			sum += h2.value;
			h2 = h2.next;
		}
		
		Node nextNode = forwardOrder(h1, h2);
		
		int carry = 0;
		if (nextNode != null && nextNode.value >= 10) {
			nextNode.value -= 10;
			carry = 1;
		}
		
		ret.value = sum + carry;
		ret.next = nextNode;
		return ret;
	}
	
	public static void main(String args[]) {
		SumLists sl = new SumLists();

		// reverse order tests
		Node testList1 = new Node(7, 1, 6);
		Node testList2 = new Node(5, 9, 2);
		Node sumList = sl.reverseOrder(testList1, testList2);
		sumList.printList();

		Node testList3 = new Node(7, 1, 6);
		Node testList4 = new Node(5, 9, 9);
		Node sumList2 = sl.reverseOrder(testList3, testList4);
		sumList2.printList();

		Node testList5 = new Node(7, 1, 6, 4);
		Node testList6 = new Node(5, 9, 9);
		Node sumList3 = sl.reverseOrder(testList5, testList6);
		sumList3.printList();
		
		// forward order tests
		Node testList7 = new Node(6, 1, 7);
		Node testList8 = new Node(2, 9, 5);
		Node sumList4 = sl.forwardOrder(testList7, testList8);
		sumList4.printList();
	}
}
