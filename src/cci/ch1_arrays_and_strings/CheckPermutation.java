package ch1_arrays_and_strings;

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

    private String sort(String s) {
        char[] content = s.toCharArray();
        java.util.Arrays.sort(content);
        return new String(content);
    }

    public boolean sortSolution(String s1, String s2) {
        return sort(s1).equals(sort(s2));
    }

    public boolean bookSolution(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;

        int[] letters = new int[256];

        for (char c : s1.toCharArray())
            letters[c]++;

        for (char c : s2.toCharArray())
            if (--letters[c] < 0)
                return false;

        return true;
    }

    public static void main(String args[]) {
        CheckPermutation checkPermutation = new CheckPermutation();
        System.out.println(checkPermutation.arraySolution("abc", "cba"));
        System.out.println(checkPermutation.arraySolution("dbc", "cba"));

        System.out.println(checkPermutation.sortSolution("abc", "cba"));
        System.out.println(checkPermutation.sortSolution("dbc", "cba"));

        System.out.println(checkPermutation.bookSolution("aac", "cba"));
    }
}
