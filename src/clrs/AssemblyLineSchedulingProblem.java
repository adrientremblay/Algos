package src.clrs;

/**
 *
 */
public class AssemblyLineSchedulingProblem {

    /**
     *
     * @param a the weights of each of the stations for the two lines (2xn)
     * @param t the edges to go from ai to bi+1 or bi to ai+1 (2xn-1)
     * @param e the two entry edges (1x2)
     * @param x the two exit edges (1x2)
     * @param n the length of each
     * @return
     */
    public int fastestWayCost(int[][] a, int[][] t, int[] e, int[] x, int n) throws Exception {
        if (a.length != 2 || a[0].length != n)
            throw new Exception();

        if (t.length != 2 || t[0].length != n-1)
            throw new Exception();

        if (e.length != 2)
            throw new Exception();

        if (x.length != 2)
            throw new Exception();

        if (n <= 0)
            throw new Exception();

        int[][] f = new int[2][n];
        f[0][0] = e[0] + a[0][0];
        f[1][0] = e[1] + a[1][0];

        for (int i = 1 ; i < n ; i++) {
            f[0][i] = Math.min(f[0][i-1] + a[0][i], f[1][i-1] + t[1][i-1] + a[0][i]);
            f[1][i] = Math.min(f[1][i-1] + a[1][i], f[0][i-1] + t[0][i-1] + a[1][i]);
        }

        int fastestWayCost = Math.min(f[0][n-1] + x[0], f[1][n-1] + x[1]);
        return fastestWayCost;
    }

    public static void main(String args[]) throws Exception {
        int n = 5;

        int[][] a =  {
                {3, 9, 6, 7, 9},
                {3, 5, 9, 8, 6}
        };

        int [][] t = {
                {2, 4, 3, 1},
                {3, 3, 3, 2}
        };

        int[] e = {2, 5};

        int[] x = {3, 4};

        AssemblyLineSchedulingProblem assemblyLineSchedulingProblem = new AssemblyLineSchedulingProblem();
        int fastestWayCost = assemblyLineSchedulingProblem.fastestWayCost(a, t, e, x, n);

        System.out.println(fastestWayCost);
    }
}
