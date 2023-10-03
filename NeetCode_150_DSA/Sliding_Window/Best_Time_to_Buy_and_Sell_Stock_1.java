package Sliding_Window;

public class Best_Time_to_Buy_and_Sell_Stock_1 {
    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        // Brute Force Method

        /* 
        int maxAns = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] > prices[i]) {
                    maxAns = Math.max(prices[j] - prices[i], maxAns);
                }
            }
        }
        return maxAns;
        */

        // Optimal Approach
        /* 
        int maxPrice = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            maxPrice = Math.max(maxPrice, prices[i] - minPrice);
        }
        return maxPrice;
        */ 

        // Two-Pointer Approach
        int left = 0; // buy
        int right = 1; // sell

        int maxProfit = 0;
        while (right < prices.length) {
            if (prices[left] < prices[right]) {
                maxProfit = Math.max(maxProfit, prices[right] - prices[left]);
                right++;
            } else {
                left = right;
                right++;
            }
        }
        return maxProfit;
    }
}
