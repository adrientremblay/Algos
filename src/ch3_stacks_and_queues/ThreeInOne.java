package ch3_stacks_and_queues;

// no generic T this time because cannot create arrays of generics
public class ThreeInOne {
	private int[] array;
	private int[] boundaries = new int[4];
	private int[] heads = new int[3];
	
	public ThreeInOne(int capacity) throws Exception {
		if (capacity <= 3 ) {
			throw new Exception("Capacity too low!");
		}
		
		array = new int[capacity];
		
		int third = capacity / 3;
		boundaries[0] = 0;
		boundaries[1] = third;
		boundaries[2] = third * 2;
		boundaries[3] = capacity;
		
		heads[0] = 0;
		heads[1] = boundaries[1];
		heads[2] = boundaries[2];
	}
	
	public void push(int stackNum, int value) throws Exception {
		if (stackNum < 1 || stackNum > 3)
			throw new Exception("Invalid stack number!");
		
		if (isFull(stackNum))
			throw new Exception("The specified stack is full!");
		
		int headIndex = stackNum - 1;
		
		array[heads[headIndex]++] = value;
	}
	
	public int pop(int stackNum) throws Exception {
		if (stackNum < 1 || stackNum > 3)
			throw new Exception("Invalid stack number");

		if (isEmpty(stackNum))
			throw new Exception("The specified stack is empty!");
		
		int headIndex = stackNum - 1;
		
		return array[--heads[headIndex]];
	}
	
	public int peek(int stackNum) throws Exception {
		if (stackNum < 1 || stackNum > 3)
			throw new Exception("Invalid stack number");

		if (isEmpty(stackNum))
			throw new Exception("The specified stack is empty!");

		int headIndex = stackNum - 1;
		
		return array[heads[headIndex] - 1];
	}
	
	public boolean isEmpty(int stackNum) throws Exception {
		if (stackNum < 1 || stackNum > 3)
			throw new Exception("Invalid stack number");
		
		int i = stackNum - 1;
		return heads[i] == boundaries[i];
	}
	
	public boolean isFull(int stackNum) throws Exception {
		if (stackNum < 1 || stackNum > 3)
			throw new Exception("Invalid stack number");
		
		int i = stackNum - 1;
		return heads[i] == boundaries[i+1];

	}
	
	public static void main(String args[]) throws Exception {
		ThreeInOne threeInOne = new ThreeInOne(10);
		
		threeInOne.push(1, 1);
		threeInOne.push(1, 1);
		threeInOne.push(1, 1);
		threeInOne.push(2, 2);
		threeInOne.push(2, 2);
		threeInOne.push(2, 2);
		threeInOne.push(3, 3);
		threeInOne.push(3, 3);
		threeInOne.push(3, 3);
		threeInOne.push(3, 12);
		System.out.println(threeInOne.pop(3));
		System.out.println(threeInOne.peek(3));
	}
}
