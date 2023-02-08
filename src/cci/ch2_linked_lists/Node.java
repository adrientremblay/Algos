package cci.ch2_linked_lists;

public class Node {
	public Node next;
	public int value;
	
	public Node() {
		this.next = null;
	}
	
	public Node(int value) {
		this.value = value;
	}
	
	public Node (int... values) {
		value = values[0];
		Node n = this;
		
		for (int i = 1 ; i < values.length ; i++) {
			n.next = new Node(values[i]);
			n = n.next;
		}
	}
	
	@Override
	public String toString() {
		return String.valueOf(value);
	}
	
	public void printList() {
		Node n = this;
		while (n != null) {
			System.out.print(n);
			System.out.print(n != null && n.next != null ? " -> " : "");
			n = n.next;
		}
		System.out.println();
	}
}
