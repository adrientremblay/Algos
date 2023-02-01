package ch2_linked_lists;

public class LoopDetection {
	
	public Node findLoop(Node linkedList) {
		Node slow = linkedList;
		Node fast = linkedList;
		
		do {
			slow = slow.next;
			fast = fast.next.next;
		} while (slow != fast);
		
		slow = linkedList;
		
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		
		return slow;
	}
	
	public static void main(String args[]) {
		Node test = new Node(1,2,3,4,5);
		test.next.next.next.next.next = test.next.next;
		
		LoopDetection loopDetection = new LoopDetection();
		
		Node beginning = loopDetection.findLoop(test);
		
		System.out.println(beginning.value);
	}
}
