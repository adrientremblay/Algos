package src.clrs.ch14_dynamic_programming;

public class LongestCommonSubsequence {
    public int bottomUpSolution(String s1, String s2) throws Exception {
        if (s1.length() != s2.length())
            throw new Exception("Strings must be of the same length");

        int n = s1.length();

        int[][] c = new int[n+1][n+1];

        for (int i = 1 ; i <= n ; i++) {
            for (int j = 1 ; j <= n ; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1))
                    c[i][j] = c[i-1][j-1] + 1;
                else
                    c[i][j] = Math.max(c[i-1][j], c[i][j-1]);
            }
        }

        return c[n][n];
    }

    public static void main(String args[]) throws Exception {
        LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();
        int longest = longestCommonSubsequence.bottomUpSolution("100100111", "010101101");
        System.out.println(longest);
    }
}
