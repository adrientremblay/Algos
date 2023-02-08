package cci.ch2_linked_lists;

import java.util.HashSet;

public class RemoveDups {
	public Node extraSpaceSolution(Node head) {
		HashSet<Integer> seen = new HashSet<Integer>();
		
		Node n = head;
		while (n != null) {
			seen.add(n.value);
			if (n.next != null && seen.contains(n.next.value))
				n.next = n.next.next;
			else
				n = n.next;
		}
		
		return head;
	}
	
	public Node noBufferAllowedSolution(Node head) {
		Node n = head;

		while (n != null && n.next != null) {
			int target = n.value;
			Node runner = n;
			while (runner != null && runner.next != null) {
				if (runner.next.value == target)
					runner.next = runner.next.next;
				else
					runner = runner.next;
			}
			n = n.next;
		}
		
		return head;
	}
	
	public static void main (String args[]) {
		RemoveDups removeDups = new RemoveDups();
		
		Node testList = new Node(1,2,3,2,1,4,5,2);
		
		Node newHead = removeDups.extraSpaceSolution(testList);
		newHead.printList();

		Node testList2 = new Node(1,2,3,2,1,4,5,2);
		
		Node newHead2 = removeDups.noBufferAllowedSolution(testList2);
		newHead2.printList();
	}
}
