import java.util.ArrayList;

public class Leavel2_Array_Question {
    public static void main(String[] args) {
//        int[]arr = {1,2,3,4,5};
//        System.out.println(arrSorted(arr,0));

//        int []arr = {1,2,4,4,5,6,7};
//        findAllIndex(arr,4,0);
//        System.out.println(list);


//        ArrayList<Integer>list = new ArrayList<>();
//        ArrayList<Integer>ans = findAllIndex(arr,4,0,list);
//        ArrayList<Integer>ans = findAllIndex(arr,4,0,new ArrayList<>());
//        System.out.println(ans);
//        System.out.println(list);


//        int []arr = {1,2,3,4,4,5};
//        System.out.println(findAllIndex2(arr,4,0));


//        int []arr = {5,6,7,8,9,1,2,3};
//        System.out.println(RBS(arr,8,0,arr.length-1));


    }
    static boolean arrSorted(int []arr,int index){
      if (index == arr.length-1){
          return true;

      }
      return arr[index]<arr[index+1] && arrSorted(arr,index+1);
    }


    // Below three are smilliar code just small condition will be change..
    static boolean linearSearch(int []arr,int target,int index){
        if (index == arr.length){
            return false;
        }
        return arr[index] == target || linearSearch(arr,target,index+1);
    }
    static int findIndex(int []arr,int target,int index){
        if (index == arr.length){
            return -1;
        }
        if (arr[index] == target){
            return index;
        }else {
            return findIndex(arr,target,index+1);
        }
    }
    static int findIndexLast(int []arr,int target,int index){
        if (index == -1){
            return -1;
        }
        if (arr[index] == target){
            return index;
        }else {
            return findIndexLast(arr,target,index-1);
        }
    }

    static ArrayList<Integer> list = new ArrayList<>();
    static void findAllIndex(int []arr,int target,int index){
        if (index == arr.length){
            return;
        }
        if (arr[index] == target){
            list.add(index);
        }
        findAllIndex(arr,target,index+1);
    }

    static ArrayList<Integer> findAllIndex(int []arr,int target,int index,ArrayList<Integer>list){
        if (index == arr.length){
            return list;
        }
        if (arr[index] == target){
            list.add(index);
        }
        return findAllIndex(arr,target,index+1,list);
    }

//    Goal :- return the list but don't take it as agrument...
//    Chanllenges :- return type will be arraylist...
//    problem :- every function call will have a new list..

    static ArrayList<Integer> findAllIndex2(int []arr,int target,int index){
        ArrayList<Integer> list = new ArrayList<>();

        if (index == arr.length){
            return list;
        }
        // this will conatin answer for that function call only
        if (arr[index] == target){
            list.add(index);
        }
        ArrayList<Integer> ansFromBelowCalls =  findAllIndex2(arr,target,index+1);
       list.addAll(ansFromBelowCalls);
       return list;
    }

    static int RBS(int []arr,int target,int start,int end){
        if (start > end) {
            return -1;
        }
        int mid  = start + (end - start)/2;
        if(arr[mid] == target){
            return mid;
        }
        if (arr[start]<= arr[mid]){
            if(target >= arr[start] && target<= arr[mid]){
               return  RBS(arr,target,start,mid-1);
            }else {
                return  RBS(arr,target,mid+1,end);
            }
        }
        if (target >= arr[mid] && target <= arr[end]){
            return  RBS(arr,target,mid+1,end);
        }
        return  RBS(arr,target,start,mid-1);
    }
}

