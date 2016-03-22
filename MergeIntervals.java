/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    
    public static class sorter implements Comparator<Interval>{
        public int compare(Interval i1, Interval i2){
            if(i1.start == i2.start){
                return i1.end - i2.end;
            }
            return i1.start - i2.start;
        }
    }
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new sorter());
        List<Interval> merged = new ArrayList<Interval>();
        if(intervals == null || intervals.size() == 0){
            return merged;
        }
        Interval temp = intervals.get(0);
        for(int i = 1; i< intervals.size(); i++){
    
            if(temp.end >= intervals.get(i).start){
                temp = (new Interval(Math.min(temp.start, intervals.get(i).start),Math.max(temp.end, intervals.get(i).end)));
             }else{
                merged.add(temp);
                temp = intervals.get(i);
            }
        }
        
        merged.add(temp);
        
        return merged;
        
    }
}
