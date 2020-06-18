package labs.khobfa.recursion;

public class RodCutOpt {

    public static void main(String[] args) {
        int[] prices = new int[]{1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
        System.out.println(cutRod(prices, 4));
    }

    public  static int cutRod(int[] prices, int n) {
        if(n == 0) return 0;

        int revenue = -Integer.MAX_VALUE;
        for (int i = 1; i<=n; i++) {
            revenue = Math.max(revenue, prices[i-1] + cutRod(prices, n-i));
        }
        return revenue;
    }


}
