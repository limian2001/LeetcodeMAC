import java.util.ArrayList;


public class Triangle {
	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        //build a same structure Arraylist as triangle, record each element's min sum up with upper level
        //then, we find the min element in last level which is result
        ArrayList<ArrayList<Integer>> sum = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        tmp.add(triangle.get(0).get(0));
        sum.add(new ArrayList<Integer>(tmp));
        
        for(int i=1;i<triangle.size();i++){
            tmp.clear();
            tmp.add(sum.get(i-1).get(0) + triangle.get(i).get(0)); //the first element
            for(int j=1;j<triangle.get(i).size()-1;j++){
                //middle element should choose a smaller one of adding uplayer's two neighbor elements
                tmp.add(Math.min(sum.get(i-1).get(j-1) + triangle.get(i).get(j), sum.get(i-1).get(j) + triangle.get(i).get(j)));
            }
            tmp.add(sum.get(i-1).get(triangle.get(i).size()-2) + triangle.get(i).get(triangle.get(i).size()-1)); //the last element
            sum.add(new ArrayList<Integer>(tmp));
            
        }
        //travesal the last level, get the smallest one
        int min = sum.get(sum.size()-1).get(0);
        for(int i=0;i<sum.get(sum.size()-1).size();i++){
            min = Math.min(min,sum.get(sum.size()-1).get(i));
        }
        return min;
    }

}
