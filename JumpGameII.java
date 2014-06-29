
public class JumpGameII {
	public static int jump(int[] A) {  
        if(A.length == 1)
            return 0;
        int maxp = 0;
        int i = 0;
        int count = 0;
        while(i < A.length - 1){
            int step = 0;  
            count++;  //count steps
            if(i+A[i] >= A.length - 1)
                return count;
            for(int k=i+A[i];k>=i;k--){  //travesal the range i can reach
                //if(k == A.length - 1)
                  //  return count;
                if(k + A[k] > step){
                    step = k + A[k];  //step record the farest position combine i and k
                    maxp = k;  //record the position can reach farest
                }
            }
            if(A[maxp] == 0)  //end unreachable
                return 0;
            i = maxp;   //update i
            
        }
        return count;
        
    }
	public static void main(String args[]){
		int[] B = {3, 2, 1, 0, 4, 0};
		int[] A = {3, 2, 1, 0, 4, 0};;
		System.out.println(jump(A));
		System.out.println(jump(B));
		
	}

}
