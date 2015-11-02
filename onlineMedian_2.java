import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in=new Scanner(System.in);
        PriorityQueue<Double> minHeap=new PriorityQueue<Double>();
        PriorityQueue<Double> maxHeap=new PriorityQueue<>(16,Collections.reverseOrder());
        int n=in.nextInt();
        double val=in.nextDouble();
        while(n-->0){
            if(minHeap.size()==0){
                minHeap.add(val);
            }else{
                if(minHeap.peek()<=val){
                    minHeap.add(val);
                }else{
                    maxHeap.add(val);
                }
            }
            
            if(minHeap.size()>maxHeap.size()+1){
                maxHeap.add(minHeap.remove());
            }else if(maxHeap.size()>minHeap.size()){
                minHeap.add(maxHeap.remove());
            }
            if(minHeap.size()==maxHeap.size()){
                
                System.out.println(0.5*(maxHeap.peek()+minHeap.peek()));
            }else{
                System.out.println( minHeap.peek());
            }
            val=in.nextDouble();
        }
        
    }
}
