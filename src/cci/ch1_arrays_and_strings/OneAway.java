package ch1_arrays_and_strings;

public class OneAway {
    public boolean mySolution(String s1, String s2) {
       if (s1.length() == s2.length()) {
           boolean usedOp = false;
           for (int i = 0 ; i < s1.length() ; i++) {
               if (s1.charAt(i) != s2.charAt(i)) {
                   if (usedOp) {
                       return false;
                   } else {
                       usedOp = true;
                   }
               }
           }
       } else if (Math.abs(s1.length() - s2.length()) == 1) {
           String longer;
           String shorter;
           if (s1.length() > s2.length()) {
               longer = s1;
               shorter = s2;
           } else {
               longer = s2;
               shorter = s1;
           }

           boolean usedOp = false;
           int shorterI = 0;
           for (int i = 0 ; i < longer.length() ; i++) {
               if (shorterI < shorter.length() && shorter.charAt(shorterI) == longer.charAt(i)) {
                    shorterI++;
                   continue;
               }
               if (!usedOp){
                   usedOp = true;
               } else {
                   return false;
               }
           }
       } else {
           return false;
       }

       return true;
    }

    public static void main(String[] args) {
        String[][] testCases = {
                {"pale", "ple"},
                {"pales", "pale"},
                {"pale", "bale"},
                {"pale", "bake"},
        };

        OneAway oneAway = new OneAway();

        for (String[] testPair : testCases) {
           System.out.println(oneAway.mySolution(testPair[0], testPair[1]));
        }
    }
}
