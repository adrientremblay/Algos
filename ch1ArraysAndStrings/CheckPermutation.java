package ch1ArraysAndStrings;

public class CheckPermutation {
    public boolean arraySolution(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;

        int[] charCounts = new int[256];

        for (char c : s1.toCharArray())
            charCounts[c] += 1;

        for (char c : s2.toCharArray())
            charCounts[c] -= 1;

        for (int i : charCounts)
            if (i != 0)
                return false;

        return true;
    }

    public static void main(String args[]) {
        CheckPermutation checkPermutation = new CheckPermutation();
        System.out.println(checkPermutation.arraySolution("abc", "cba"));
        System.out.println(checkPermutation.arraySolution("dbc", "cba"));
    }
}
