public class Q2_Best_Time_to_Buy_and_Sell_Stock {
    public static void main(String[] args) {
        int[] prices = { 7, 1, 5, 3, 6, 4 };
        int result = maxProfit(prices);
        System.out.println("Maximum profit: " + result);

    }

    public static int maxProfit(int[] prices) {
        // ! Brute Force solution (TLE)

        // int maxProfit = 0;
        // for(int i=0;i<prices.length;i++){
        // for(int j=i+1;j<prices.length;j++){
        // int profit = prices[j] - prices[i];

        // if(profit>maxProfit){
        // maxProfit = profit;
        // }
        // }
        // }
        // return maxProfit;

        // ! Better One (o(n))

        // int minPrice = Integer.MAX_VALUE;
        // int maxProfit = 0;

        // // Traverse only once

        // for(int i=0;i<prices.length;i++){
        // if(prices[i]<minPrice){
        // minPrice = prices[i];
        // }else{
        // int profit = prices[i] - minPrice;

        // if(profit>maxProfit){
        // maxProfit = profit;
        // }
        // }
        // }
        // return maxProfit;

        // ! Little bit improvement

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else {
                int profit = price - minPrice;
                maxProfit = Math.max(maxProfit, profit);
            }
        }
        return maxProfit;
    }
}
