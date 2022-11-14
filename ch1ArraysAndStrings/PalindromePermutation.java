package ch1ArraysAndStrings;

public class PalindromePermutation {

    public boolean arraySolution(String str) {
        int history[] = new int[256];

        for (char c : str.toCharArray())
            history[c]++;

        boolean foundCenter = false;
        for (int i = 0 ; i < history.length ; i++) {
            if (i == ' ' || history[i] % 2 == 0)
                continue;

            if (!foundCenter)
                foundCenter = true;
            else
                return false;
        }

        return true;
    }

    public static void main(String args[]) {
        PalindromePermutation palindromePermutation = new PalindromePermutation();
        System.out.println(palindromePermutation.arraySolution("taco cat"));
        System.out.println(palindromePermutation.arraySolution("atco cta"));
        System.out.println(palindromePermutation.arraySolution("balls"));
    }
}
