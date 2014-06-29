import java.util.HashSet;
import java.util.Set;


public class Candy {
public static int candy(int[] ratings) {
        
        if(ratings.length == 0 || ratings == null)
            return 0;
        
        if(ratings.length == 1)
            return 1;
        //array A record the element has higher rating neighbor or not
        //array candy record the candy's number
        boolean[] A = new boolean[ratings.length];
        int[] candy = new int[ratings.length];    
        
        if(ratings[0] > ratings[1])
            A[0] = true;
        for(int i=1;i<ratings.length-1;i++){
            if(ratings[i] > ratings[i-1] ||ratings[i] > ratings[i+1])
                A[i] = true;
        }
        if(ratings[ratings.length-1] > ratings[ratings.length-2])
            A[ratings.length-1] = true;
            
        int j = -1; //the first false
        for(int k=0;k<A.length;k++){
            if(!A[k]){
                candy[k] = 1;
                if(k > j + 1)
                    fillup(candy,ratings,j,k);
                j = k; //j is the previous false, k is current false;
            }
        }
        fillup(candy,ratings,j,candy.length);
           
        //sum up
        int sum = 0;
        for(int t : candy)
            sum += t;
        
        return sum;
    }
//this fuction to fill up i to j, from left and from right, choose the larger number 
    public static void fillup(int[] candy, int[] ratings,int j, int k){
        
        if(j == -1){
            for(int i=k-1;i>=0;i--)
                candy[i] = k-i+1;
        }
        else if(k == candy.length){
            for(int i=j+1;i<k;i++)
                candy[i] = i-j+1;
        }
        else{
            int[] p = new int[k-j-1];
            for(int i=j+1,t=0;i<k;i++,t++){
                if(ratings[i] > ratings[i-1])
                    p[t] = t + 2;
                else
                    p[t] = 0;
            }
            for(int i=k-1,t=p.length-1;i>j;i--,t--){
                if(ratings[i] > ratings[i+1])
                    p[t] = Math.max(p[t],p.length-1-t+2);
            }
            for(int x=0;x<p.length;x++)
                candy[j+1+x] = p[x];
        }
    }
    public static void main(String args[])
    {
     int[] d = {2,2,1};
     System.out.println(candy(d));
     }

}
/*I find an algorithm from internet that it set all candy[i]=1, then from 
left to right, set candy[i+1] = candy[i]+1 if i+1's rating larger than i. 
Then, from right to left, adjust candy[j]=candy[j+1]+1 if j's rating larger 
than j+1. This method requires only 20 lines */