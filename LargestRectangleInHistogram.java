public class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<Integer>();
        int i = 0, max = 0, area = 0;
        
        for(i = 0; i < heights.length;){
            
            if(st.isEmpty() || heights[st.peek()] <= heights[i]){
                st.push(i++);
            }else{
                int top = st.pop();
                
                if(st.isEmpty()){
                    area = heights[top] * i;
                    
                }else{
                    area = heights[top] * (i - st.peek() - 1);
                }
                
                if(area > max){
                    max = area;
                }
            }
        }
        while(!st.isEmpty()){
            int top = st.pop();
            if(st.isEmpty()){
                area = heights[top] * i;
            }else{
                area = heights[top] * (i - st.peek() - 1);
            }
            
            if(area > max){
                max = area;
            }
        }
        
        return max;
        
    }
}
