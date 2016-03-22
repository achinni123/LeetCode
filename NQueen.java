public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> arr = new ArrayList<List<String>>();
        if(n <= 0){
            return arr;
        }
        List<Integer> col = new ArrayList<Integer>();
        generatePlacements(arr, col, 0 , n);
        return arr;
        
    }
    
    public static void generatePlacements(List<List<String>> arr, List<Integer> col, int row, int n){
        if(row == n){
            List<String> a = new ArrayList<String>();
            for(int i = 0; i < col.size(); i++){
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < n; j++){
                    if(j == col.get(i)){
                        sb.append("Q");
                    }else{
                        sb.append(".");
                    }
                }
                a.add(sb.toString());
            }
            arr.add(a);
            
        }else{
            for(int i = 0; i < n; i++){
                col.add(i);
                
                if(isValid(col)){
                    generatePlacements(arr, col, row + 1, n);
                }
                
                col.remove(col.size() - 1);
            }
        }
    }
    
    public static boolean isValid(List<Integer> col){
        int row = col.size() - 1;
        for(int i = 0; i < row; i++){
            int diff = Math.abs(col.get(i) - col.get(row));
            if(diff == 0 || diff == row - i){
                return false;
            }
        }
        return true;
    }
}
