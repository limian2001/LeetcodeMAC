
public class MedianofTwoSortedArrays {
	public static double findMedianSortedArrays(int A[], int B[]) {
        int n = A.length + B.length;
        
        System.out.println("n/2 + 1 is " + findk(A,0,B,0,3 ));
        if(n % 2 == 0)
            return (double)((findk(A,0,B,0,n/2) + findk(A,0,B,0,n/2 + 1)) / 2.0);
        else
            return findk(A,0,B,0,n/2 + 1);
    }
    
    //a function to find the kth in A&B,  a/b is the start index in A/B
    public static double findk(int A[], int a,int B[],int b, int k){
        //assume A.length <= B.length
        if(A.length > B.length)
            return findk(B,b,A,a,k);
        if(A.length == 0)
            return B[k-1];
        if(a >= A.length)
            return B[b+k-1];
        if(b >= B.length)
            return A[a+k-1];
        if(k == 1)
            return Math.min(A[a],B[b]);
        int ap = Math.min(A.length-1,a + k/2 - 1);  //the position in A
        int bp = b + k - (ap - a) - 2;
        if(A[ap] < B[bp])
            return findk(A,ap+1,B,b,k-(ap-a)-1);
        else if(B[bp] < A[ap])
            return findk(A,a,B,bp+1,k-(bp-b)-1);
        else  //equal
            return A[ap];
    }
    
    public static void main(String args[]){
    	int[] a = {1,2};
    	System.out.println(findMedianSortedArrays(a,a));
    }

}
