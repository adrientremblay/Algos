package ch3_stacks_and_queues;

/**
 * Identical to a stack but with the additional O(n) operation of 
 */

public class StackMin extends Stack<Integer> {
	Stack<Integer> minStack;
	
	public StackMin() {
		super();
		minStack = new Stack();
	}
	
	@Override
	public void push(Integer value) {
		super.push(value);
		
		if (minStack.isEmpty() || minStack.peek() > value)
			minStack.push(value);
	}

	@Override
	public Integer pop() {
		Integer ret = super.pop();
		
		if (minStack.peek() == ret)
			minStack.pop();
		
		return ret;
	}
	
	public Integer min() {
		if (minStack.isEmpty())
			return null;
		
		return minStack.peek();
	}
	
	public static void main(String args[]) {
		StackMin stackMin = new StackMin();
		
		stackMin.push(3);
		System.out.println(stackMin.min());
		stackMin.push(4);
		System.out.println(stackMin.min());
		stackMin.push(2);
		System.out.println(stackMin.min());
		stackMin.pop();
		System.out.println(stackMin.min());
	}
}
