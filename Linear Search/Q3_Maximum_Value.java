public class Q3_Maximum_Value {
    public static void main(String[] args) {
        int []arr = {3,4,5,6,7,8};
        System.out.println(max(arr));
    }
    public static int max(int[] arr){
        if(arr.length == 0){
            return -1;
        }
        int maxValue = arr[0];
        for(int i=1;i<arr.length;i++){
            if (arr[i]>maxValue){
                maxValue = arr[i];
            }
        }
        return maxValue;
    }
}
