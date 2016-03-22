public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(16, Collections.reverseOrder());
        int[] arr = new int[nums.length-k+1];
        if(nums.length==0){
            return nums;
        }
         arr = new int[nums.length-k+1];
        for(int i=0;i<k;i++){
            maxHeap.add(nums[i]);
        }
        arr[0] = maxHeap.peek();
        for(int i=k;i<nums.length;i++){
            maxHeap.remove(nums[i-k]);
            maxHeap.add(nums[i]);
            arr[i-k+1]=maxHeap.peek();
        }
        return arr;
        
    }
}
