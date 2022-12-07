package ch2_linked_lists;

import java.util.Stack;

public class Palindrome {
	public boolean mySolution(Node head) {
		Node slow = head;
		Node fast = head;
		Stack<Integer> history = new Stack<Integer>();
		
		while (fast != null && fast.next != null) {
			history.add(slow.value);
			slow = slow.next;
			fast = fast.next.next;
		}

		if (fast != null)
			slow = slow.next;
		
		while (!history.isEmpty() && slow != null) {
			if (history.pop() != slow.value)
				return false;
			slow = slow.next;
		}

		return slow == null && history.isEmpty();
	}
	
	public static void main(String args[]) {
		Palindrome p = new Palindrome();
		
		Node testList1 = new Node(1,2,3,4,3,2,1);
		Node testList2 = new Node(1,2,3,3,2,1);
		Node testList3 = new Node(1,2,3,4,2,1);
		
		System.out.println(p.mySolution(testList1));
		System.out.println(p.mySolution(testList2));
		System.out.println(p.mySolution(testList3));
	}
}
