package src.clrs.ch14_dynamic_programming;

/**
 * This problem isn't in any version of CLRS ASFAIK, but it's a DP problem so I put it here
 */
public class LongestIncreasingSubsequence {

    public static int tableSolution(int[] subsequence) {
        int n = subsequence.length;

        // array of longest increasing subsequence possible with subsequence[i]
        int[] longests = new int[n];

        for (int i = 0 ; i < n; i++) {
            for (int j = i - 1 ; j >= 0 ; j--) {
                if (subsequence[j] < subsequence[i]) {
                    longests[i] = longests[j];
                    break;
                }
            }
            longests[i]++;
        }

        return longests[n - 1];
    }

    public static void main(String[] args) {
        int[] testSubsequence = {10, 3, 12, 18, 30, 4, 6, 21, 7, 20};
        int ans = tableSolution(testSubsequence);
        System.out.println(ans);
    }
}
