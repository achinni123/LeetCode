public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return 0;
        }
        int[] arr = new int[matrix[0].length]; 
        int area = 0, maxArea = 0;
        for(int i = 0; i < matrix.length; i++ ){
            for(int j =0; j <matrix[i].length; j++ ){
                if(matrix[i][j] == '1'){
                    arr[j] +=1;
                }else{
                    arr[j] = 0;
                }
                
            }
            
            area = histogramArea(arr);
            if(area > maxArea){
                maxArea = area;
            }
        }
        
        return maxArea;
        
    }
    
    public static int histogramArea(int[] arr){
        Stack<Integer> st = new Stack<Integer>();
        int area = 0, maxArea = 0, i = 0;
        
        for(i = 0; i < arr.length; ){
            if(st.isEmpty() || arr[st.peek()] <= arr[i]){
                st.push(i++);
            }else{
                int top = st.pop();
                if(st.isEmpty()){
                    area = arr[top] * i;
                }else{
                    area = arr[top] * (i - st.peek() - 1);
                }
                
                if(area > maxArea){
                    maxArea = area;
                }
            }
            
        }
        
        while(!st.isEmpty()){
            int top = st.pop();
            if(st.isEmpty()){
                area = arr[top] * i;
            }else{
                area = arr[top] * (i - st.peek() - 1);
            }
            
            if(area > maxArea){
                maxArea = area;
            }
        }
        
        return maxArea;
    }
}
