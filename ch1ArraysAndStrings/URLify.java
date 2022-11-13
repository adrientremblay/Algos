package ch1ArraysAndStrings;

public class URLify {
    public void twoPointerSolution(char[] s, int trueLen) {
       int right = s.length - 1;
       int left = trueLen - 1;

       while (right > left) {
           if (s[left] == ' ') {
               s[right--] = '0';
               s[right--] = '2';
               s[right--] = '%';
               left--;
           } else {
               s[right--] = s[left--];
           }
       }
    }

    public static void main(String args[]) {
        URLify urLify = new URLify();

        char[] test1 = "Mr John Smith    ".toCharArray();
        urLify.twoPointerSolution(test1, 13);
        System.out.println(new String(test1));
    }
}
