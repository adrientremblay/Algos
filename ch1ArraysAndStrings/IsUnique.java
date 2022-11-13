package ch1ArraysAndStrings;

public class IsUnique {
    public boolean arraySolution(String s) {
        boolean[] history = new boolean[256];

        for (char c : s.toCharArray()) {
            if (!history[c])
                history[c] = true;
            else
                return false;
        }

        return true;
    }

    /**
     * Assumes the char set is only lowercase alpha chars so that we can use
     * a single int as the history
     * @param s
     * @return
     */
    public boolean bitVectorSolution(String s) {
        int history = 0;

        for (char c : s.toCharArray()) {
            int val = c - 'a';
            if ((history & (1 << val)) > 0)
                return false;
            history |= (1 << val);
        }

        return true;
    }

    public static void main(String args[]) {
        IsUnique isUnique = new IsUnique();
        String[] inputs = {"asdf", "asdfa", "", "b"};

        for (String s : inputs) {
            System.out.println(isUnique.arraySolution(s) + " " + isUnique.bitVectorSolution(s));
        }
    }
}
