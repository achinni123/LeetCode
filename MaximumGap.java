public class Solution {
    
    public static class Bucket{
        int low;
        int high;
        boolean flag = false;
        
        public void updateValue(int val){
            if(!flag){
                high = val;
                low = val;
                flag = true;
            }else{
                low = Math.min(low, val);
                high = Math.max(high, val);
            }
        }
    }
    public int maximumGap(int[] nums) {
        if(nums == null || nums.length < 2){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i < nums.length; i++){
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        
        int intervalSize = (int )Math.ceil((double )(max - min) / (nums.length - 1));
        Bucket[] arr = new Bucket[nums.length - 1];
        
        for(int i = 0; i < arr.length; i++){
            arr[i] = new Bucket();
        }

        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == min || nums[i] == max){
                continue;
            }
            arr[((nums[i] - min) / intervalSize)].updateValue(nums[i]);
            
        }
        int maxCount = 0, prev = min;
        for(int i = 0; i < arr.length; i++){
            if(!arr[i].flag){
                continue;
            }
            maxCount = Math.max(maxCount, arr[i].low - prev);
            prev = arr[i].high;
        }
        
        return Math.max(maxCount, max - prev);
        
        
    }
}
