public class Solution {
    public int longestValidParentheses(String s) {
        if(s == null || s.length() == 0 || s.length() == 1){
            return 0;
        }
        
        int maxCount = 0, end  = -1;
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                st.push(i);
            }else if(st.isEmpty()){
                end = i;
            }else{
                st.pop();
                int start = st.isEmpty() ? end : st.peek();
                maxCount = Math.max(maxCount, i - start);
            }
        }
        
        
        
        return maxCount;
        
    }
}
