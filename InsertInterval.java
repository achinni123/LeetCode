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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        
        List<Interval> alist = new ArrayList<Interval>();
        if(intervals.size() == 0){
            alist.add(newInterval);
            return alist;
        }
        int i = 0;
     
            while(i < intervals.size() && newInterval.start > intervals.get(i).end ){
                alist.add(intervals.get(i++));
            }
            
            while(i < intervals.size() && newInterval.end >= intervals.get(i).start){
                newInterval = new Interval( Math.min(newInterval.start, intervals.get(i).start), Math.max(newInterval.end, intervals.get(i).end) );
                ++i;
            }
            alist.add(newInterval);
            
          
                alist.addAll(intervals.subList(i, intervals.size()));
            
        
        
    
    
    return alist;
 }
}
