public class Q4_Max_Value_In_Range {
    public static void main(String[] args) {
        int []arr = {3,4,5,6,7,8};
        System.out.println(maxRange(arr,1,3));
    }
    public static int maxRange(int[] arr,int start,int end){
        if(start > end){
            return -1;
        }
        if (arr == null){
            return -1;
        }
        if(arr.length == 0){
            return -1;
        }
        int maxValue = arr[0];
        for(int i=start;i<=end;i++){ // this 2 condition is change only...
            if (arr[i]>maxValue){
                maxValue = arr[i];
            }
        }
        return maxValue;
    }
}
