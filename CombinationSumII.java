import java.util.*;
/*Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
A solution set is: 
[1, 7] 
[1, 2, 5] 
[2, 6] 
[1, 1, 6] */
public class CombinationSumII {
	public static ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        Queue<ArrayList<Integer>> q = new LinkedList<ArrayList<Integer>>(); //record temp result
        Queue<Integer> sum = new LinkedList<Integer>(); //record current sum up
        Queue<Integer> qindex = new LinkedList<Integer>();  //record index used, prevent use element repeatedly
        Arrays.sort(candidates);
        
        if(target == candidates[0]){
            tmp.add(target);
            res.add(new ArrayList<Integer>(tmp));
            return res;
        }
        //each element which is smaller than target offer into queue 
        for(int i=0;i<candidates.length;i++){
            if(candidates[i] > target)
                break;
            else{
                if(i==0 || i>0 && candidates[i] != candidates[i-1]){
                ArrayList<Integer> el = new ArrayList<Integer>();
                el.add(candidates[i]);
                q.add(el);
                qindex.add(i);
                sum.add(candidates[i]);
                }
            }
        }
        //BFS, find combination
       
        while(!q.isEmpty()){
            int index = qindex.poll();
            tmp = q.poll();
            int add = sum.poll();
            
            if(add == target)
                res.add(new ArrayList<Integer>(tmp));
            int lastadd = -1;
            if(add < target){
                for(int i=index+1;i<candidates.length;i++){
                    if(candidates[i] > target - add)
                        break;
                    else{
                        if(candidates[i] >= tmp.get(tmp.size()-1) && candidates[i] != lastadd){
                            lastadd = candidates[i];
                            qindex.add(i);
                            ArrayList<Integer> tmp2 = new ArrayList<Integer>(tmp);
                            tmp2.add(candidates[i]);
                            
                            q.add(tmp2);
                            
                            sum.add(add+candidates[i]);
                        }
                        
                    }
                }
                lastadd = -1;
            }
        }
        
        return res;
        
    }
	public static void main(String args[]){
		int[] a = {2,2,2};
		int t = 4;
		System.out.println(combinationSum2(a,t));
		
		
	}
}
