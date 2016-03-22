public class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums.length == 0){
            return 1;
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]){
                swap(nums,nums[i] - 1, i);
                // System.out.println(nums[i]);
                --i;
            }
        }
        

        
        int i = 0;
        for(i = 0; i < nums.length; i++){
           
            if(nums[i] != (i+1)){
                return (i + 1);
            }
        }
        
        return nums.length + 1;
        
        
    }
    
    public static void swap( int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
