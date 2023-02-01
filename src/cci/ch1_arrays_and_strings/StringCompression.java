package ch1_arrays_and_strings;

public class StringCompression {
    public String mySolution(String s) {
        if (s.length() == 0)
            return s;

        StringBuilder sb = new StringBuilder();

        char curChar = s.charAt(0);
        int count = 1;

        for (int i = 1 ; i < s.length() ; i++) {
            char c = s.charAt(i);
            if (c == curChar) {
                count++;
            } else {
                sb.append(curChar);
                if (count != 1)
                    sb.append(count);
                curChar = c;
                count = 1;
            }
        }

        sb.append(curChar);
        if (count != 1)
            sb.append(count);

        return sb.toString();
    }

    public static void main(String args[]) {
        StringCompression stringCompression = new StringCompression();

        System.out.println(stringCompression.mySolution("abbcccdff"));
    }
}
