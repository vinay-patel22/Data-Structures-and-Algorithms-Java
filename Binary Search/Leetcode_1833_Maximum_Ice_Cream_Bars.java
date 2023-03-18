import  java.util.*;
public class Leetcode_1833_Maximum_Ice_Cream_Bars {
    public static void main(String[] args) {
        int []costs = {1,3,2,4,1};
        int coins = 7;
        maxIceCream(costs,coins);
    }
    public static int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int ans=0,i=0;

        while(i<costs.length && coins>=costs[i]){
            coins -= costs[i];
            ans++;
            i++;
        }
        return  ans;
    }
}
