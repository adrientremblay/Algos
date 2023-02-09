package src.clrs.ch14_dynamic_programming;

public class LongestCommonSubsequence {

    /**
     * returns cost and
     *
     * @param s1
     * @param s2
     * @return
     * @throws Exception
     */
    // todo: make this work for strings of non-equal length
    public int bottomUpSolution(String s1, String s2) throws Exception {
        if (s1.length() != s2.length())
            throw new Exception("Strings must be of the same length");

        int n = s1.length();

        int[][] c = new int[n+1][n+1];
        char[][] arrows = new char[n+1][n+1];

        // filling table c and calculating longest common substring
        for (int i = 1 ; i <= n ; i++) {
            for (int j = 1 ; j <= n ; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    c[i][j] = c[i-1][j-1] + 1;
                    arrows[i][j] = '↖';
                } else if (c[i-1][j] > c[i][j-1]) {
                     c[i][j] = c[i-1][j];
                     arrows[i][j] = '↑';
                } else {
                    c[i][j] = c[i][j-1];
                    arrows[i][j] = '←';
                }
            }
        }

        // printing longest common substring using arrows matrix
        int i = n;
        int j = n;

        StringBuilder sb = new StringBuilder();
        while (i >= 0 && j >= 0)  {
            if (arrows[i][j] == '↖') {
                sb.append(s1.charAt(i-1));
                i--;
                j--;
            } else if (arrows[i][j] == '←') {
                j--;
            } else if (arrows[i][j] == '↑'){
                i--;
            } else {
                break;
            }
        }
        System.out.println(sb.reverse().toString());

        // printing longest common substring without using the arrows matrix
        i = n;
        j = n;
        sb = new StringBuilder();
        while (i > 0 && j > 0)  {
            if (s1.charAt(i-1) == s2.charAt(j-1)) {
                sb.append(s1.charAt(i-1));
                i--;
                j--;
            } else if (c[i-1][j] >= c[i][j-1]) {
                i--;
            } else {
                j--;
            }
        }

        System.out.println(sb.reverse().toString());

        return c[n][n];
    }

    public static void main(String args[]) throws Exception {
        LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();
        int longest = longestCommonSubsequence.bottomUpSolution("100100111", "010101101");
        longestCommonSubsequence.bottomUpSolution("ABCBDA", "BDCABA");
    }
}
