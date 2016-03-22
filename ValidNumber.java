public class Solution {
    public boolean isNumber(String s) {
        
        try{
            if(s.charAt(s.length()-1)=='f'||s.charAt(s.length()-1)=='F'||s.charAt(s.length()-1)=='D'||s.charAt(s.length()-1)=='d'){
                return false;
            }
           double a = Double.parseDouble(s);
            return true;
            
        }catch(Exception e){
            return false;
        }
        
    }
}
