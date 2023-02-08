package cci.ch3_stacks_and_queues;

public class Queue<T> {
	private class QueueNode {
		public T value;
		public QueueNode next;
		
		public QueueNode(T value) {
			this.value = value;
			next = null;
		}
	}
	
	private QueueNode head;
	private QueueNode tail;
	
	public void add(T value) {
		QueueNode newNode = new QueueNode(value);
		if (tail == null) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			tail = tail.next;
		}
	}

	public T remove() {
		if (head == null)
			return null;
		T ret = head.value;
		head = head.next;
		return ret;
	}

	public T peek() {
		if (head == null)
			return null;
		return head.value;
	}

	public boolean isEmpty() {
		return head == null;
	}
}
