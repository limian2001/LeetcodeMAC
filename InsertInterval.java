/*Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:
Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

Example 2:
Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].*/
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
import java.util.*;

public class InsertInterval {
	public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		if(intervals == null ||newInterval == null)
			return intervals;
		if(intervals.size() == 0){
			intervals.add(newInterval);
			return intervals;
		}
		ListIterator<Interval> it = intervals.listIterator();
		while(it.hasNext()){
			Interval tmp = it.next();
			if(newInterval.end < tmp.start){  //the new one totally smaller than current one, insert before current and return --A
				it.previous();  //backward one pointer, if it is 0, iterator can back to head(like -1)
				it.add(newInterval);  //insert new after pointer
				return intervals;
			}
			else{
				if(tmp.end < newInterval.start) //next pointer will process this situation, like A above. If it is the last element, B will add to end
					continue;
				else{ //new one overlap with current, update the new one, remove the current 
					newInterval.start = Math.min(newInterval.start, tmp.start);
					newInterval.end = Math.max(newInterval.end, tmp.end);
					it.remove();
				}
			}
		}
		intervals.add(newInterval); // B
		return intervals;
			
    }
	public static void main(String args[]){
		Interval i = new Interval(3,4);
		Interval j = new Interval(5,6);
		Interval k = new Interval(3,4);
		List<Interval> list = new LinkedList<Interval>();
		list.add(i);
		list.add(j);
		List<Interval> res = insert(list,k);
		for(Interval r : res){
			System.out.println(r.start);
			System.out.println(r.end);
		}
		
	}
	
	
	
	
	
	

}

