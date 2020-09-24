package LeetCode.jianzhioffer;

public class Offer63_maxProfit {
    public static void main(String[] args) {

    }

    public static int maxProfit(int[] prices) {
        int minCost = Integer.MAX_VALUE;
        int profit = 0;
        for(int price : prices){
            minCost = Math.min(minCost, price);
            profit = Math.max(profit, price - minCost);
        }

        return profit;
    }
}
