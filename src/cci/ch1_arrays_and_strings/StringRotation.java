package cci.ch1_arrays_and_strings;

public class StringRotation {
	public boolean mySol(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		
		int l = s1.length();
		
		if (l < 2)
			return false;
		
		for (int split = 1 ; split < l - 1 ; split++) {
			String[] splitS1 = {s1.substring(0, split), s1.substring(split, l)};
			
			if (s2.contains(splitS1[0]) && s2.contains(splitS1[1]))
				return true;
		}
		
		return false;
	}
	
	public boolean oneCallSol(String s1, String s2) {
		return ((String)(s1 + s1)).contains(s2);
	}
	
	public static void main(String args[]) {
		StringRotation stringRotation = new StringRotation();
		
		System.out.println(stringRotation.mySol("waterbottle", "erbottlewat"));
		System.out.println(stringRotation.mySol("waterbottle", "bottlewater"));
		System.out.println(stringRotation.mySol("waterbottl", "erbottlewat"));
		System.out.println(stringRotation.mySol("waterbottle", "erboetlewat"));
		
		System.out.println(stringRotation.oneCallSol("waterbottle", "erbottlewat"));
		System.out.println(stringRotation.oneCallSol("waterbottle", "bottlewater"));
		System.out.println(stringRotation.oneCallSol("waterbottl", "erbottlewat"));
		System.out.println(stringRotation.oneCallSol("waterbottle", "erboetlewat"));
	}
}
