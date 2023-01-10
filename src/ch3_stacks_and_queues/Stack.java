package ch3_stacks_and_queues;

public class Stack<T> {
	private class StackNode {
		public T value;
		public StackNode next;
		
		public StackNode(T value) {
			this.value = value;
			next = null;
		}
	}
	
	private StackNode head = null;

	public void push(T value) {
		StackNode newNode = new StackNode(value);
		if (head != null)
			newNode.next = head;
		head = newNode;
	}
	

	public T pop() {
		if (head == null)
			return null;

		T ret = head.value;
		head = head.next;
		return ret;
	}
	
	public T peek() {
		return head.value;
	}
	
	public boolean isEmpty() {
		return head == null;
	}

}