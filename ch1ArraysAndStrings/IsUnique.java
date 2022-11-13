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

    public static void main(String args[]) {
        IsUnique isUnique = new IsUnique();
        String[] inputs = {"asdf", "asdfa", "", "b"};

        for (String s : inputs) {
            System.out.println(isUnique.arraySolution(s));
        }
    }
}
