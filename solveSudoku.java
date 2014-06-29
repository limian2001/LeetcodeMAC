
public class solveSudoku {
	
	
	public static void solveSudoku(char[][] board) {
        //backtracking
        int[][] lastval = new int[9][9];
        int[][] lasti = new int[9][9];
        int[][] lastj = new int[9][9];
        int prei=0,prej=0;
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j] == '.'||lastval[i][j] != 0){
                	if(lastval[i][j] == 0){
                		lasti[i][j] = prei;
                		lastj[i][j] = prej;
                	}
                    int k = pickmin(board,lastval,i,j);
                    if(k == -1){  //backtracking
                    	board[i][j] = '.';
                    	lastval[i][j] = 0;
                    	int p = i;
                        i = lasti[i][j];
                        j = lastj[p][j] - 1;
                            
                        continue;
                        }
                    else{
                            
                        board[i][j] = (char)(k + '0');
                        lastval[i][j] = k;
                       
                        prei = i;
                        prej = j;
                        
                    }
                }
            }
        }
        return;
        
    }
    
    //pick a number is valid to policy but larger than current value i,j
    public static int pickmin(char[][] board,int[][] lastval,int i,int j){
        //check column
        boolean[] a = new boolean[10];

        for(int k=0;k<9;k++){
            if(board[i][k] != '.')
                a[board[i][k] - '0'] = true;
        }
        //check row
        for(int k=0;k<9;k++){
            if(board[k][j] != '.')
                a[board[k][j] - '0'] = true;
        }
        //check 9
        for(int k=i-i%3;k<i-i%3+3;k++)
            for(int h=j-j%3;h<j-j%3+3;h++){
                if(board[k][h] != '.')
                    a[board[k][h] - '0'] = true;
            }
        
        for(int x=lastval[i][j]+1;x<10;x++)
            if(!a[x])
                return x;
        return -1;
    }
    public static void main(String args[]){
		char[][] a = {{'.','.','9','7','4','8','.','.','.'},{'7','.','.','.','.','.','.','.','.'},{'.','2','.','1','.','9','.','.','.'},{'.','.','7','.','.','.','2','4','.'},{'.','6','4','.','1','.','5','9','.'},{'.','9','8','.','.','.','3','.','.'},{'.','.','.','8','.','3','.','2','.'},{'.','.','.','.','.','.','.','.','6'},{'.','.','.','2','7','5','9','.','.'}};
		
		solveSudoku(a);
		for(int i=0;i<9;i++){
			System.out.println("");
            for(int j=0;j<9;j++)
            	System.out.print(a[i][j]);
		}
		System.out.println("abc");
		
		
	}

}
