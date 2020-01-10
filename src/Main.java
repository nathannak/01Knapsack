public class Main {

    // A utility function that returns maximum of two integers
    static int max(int a, int b) { return (a > b)? a : b; }

    // Returns the maximum value that can be put in a knapsack of capacity W
    static int knapSack(int W, int wt[], int val[], int n)
    {
        int i, w;
        int K[][] = new int[n+1][W+1];

        // Build table K[][] in bottom up manner
        for (i = 0; i <= n; i++)
        {
            for (w = 0; w <= W; w++)
            {
                if (i==0 || w==0)
                    K[i][w] = 0;
                else if (wt[i-1] <= w)
                    K[i][w] = max(val[i-1] + K[i-1][w-wt[i-1]],  K[i-1][w]);
                else
                    K[i][w] = K[i-1][w];
            }
        }

        for (int j = 0 ; j < n ; j++) {

            for (int k = 0; k < W; k++) {

                    System.out.print(K[j][k]);
                    System.out.print("-");

                }

            System.out.println("");

        }

        return K[n][W];

    }

    // Driver program to test above function
    public static void main(String args[])
    {
        int val[] = new int[]{60, 100, 120};
        int wt[] = new int[]{10, 20, 30};
        int  W = 50;
        int n = val.length;
        System.out.println(knapSack(W, wt, val, n));
    }

}

//prints:
/*

0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-0-
0-0-0-0-0-0-0-0-0-0-60-60-60-60-60-60-60-60-60-60-60-60-60-60-60-60-60-60-60-60-60-60-60-60-60-60-60-60-60-60-60-60-60-60-60-60-60-60-60-60-
0-0-0-0-0-0-0-0-0-0-60-60-60-60-60-60-60-60-60-60-100-100-100-100-100-100-100-100-100-100-160-160-160-160-160-160-160-160-160-160-160-160-160-160-160-160-160-160-160-160-

220

 */