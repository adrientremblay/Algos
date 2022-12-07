package ch2_linked_lists;

import java.util.HashSet;

public class Intersection {
	public Node Iq1000HashSetSolution(Node h1, Node h2) {
		HashSet<Node> history = new HashSet<Node>();
		
		while (h1 != null || h2 != null) {
			if (h1 != null) {
				if (history.contains(h1))
					return h1;
				history.add(h1);
				h1 = h1.next;
			}
			if (h2 != null) {
				if (history.contains(h2))
					return h2;
				history.add(h2);
				h2 = h2.next;
			}
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		Node common = new Node(7);
		Node common_2 = new Node(2);
		Node common_3 = new Node(1);
		common.next = common_2;
		common_2.next = common_3;

		Node h1_1 = new Node(3);
		Node h1_2 = new Node(1);
		Node h1_3 = new Node(5);
		Node h1_4 = new Node(9);
		h1_1.next = h1_2;
		h1_2.next = h1_3;
		h1_3.next = h1_4;
		h1_4.next = common;

		Node h2_1 = new Node(4);
		Node h2_2 = new Node(6);
		h2_1.next = h2_2;
		h2_2.next = common;
		
		Intersection i = new Intersection();
		Node intersection = i.Iq1000HashSetSolution(h1_1, h2_2);
		System.out.println(intersection.value);
	}
}
