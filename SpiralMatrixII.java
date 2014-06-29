/*Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
	*/	
import java.util.*;

public class SpiralMatrixII {
	public static int[][] generateMatrix(int n) {
		
		int[][] matrix = new int[n][n];
		int start = 0;
		int count = 0;
		while(count < n*n){
    
    
			for(int i=start;i<=n-start-1;i++)
				matrix[start][i] = ++count;
        
			if(count == n*n)
				return matrix;
        
			for(int i=start+1;i<=n-start-1;i++)
				matrix[i][n-start-1] = ++count;
        
			if(count == n*n)
				return matrix;
        
			for(int i=n-start-2;i>=start;i--)
				matrix[n-start-1][i] = ++count;
        
			if(count == n*n)
				return matrix;
        
			for(int i=n-start-2;i>=start+1;i--)
				matrix[i][start] = ++count;
        
			if(count == n*n)
				return matrix;
    
			start++;
    
    	}
		return matrix;
	}
	
	public static void main(String args[]){
		int n = 20;
		int[][] a = new int[n][n];
		a = generateMatrix(n);
		for(int i=0;i<a.length;i++){
			System.out.println("");
			for(int j=0;j<a[0].length;j++)
				System.out.printf("%4d",a[i][j]);
		}
	}

}
