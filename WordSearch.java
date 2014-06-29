
public class WordSearch {
	public static boolean exist(char[][] board, String word) {
        if(word == null ||word.length() == 0)
            return true;
        if(board == null ||board.length == 0)
            return false;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++)
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] == word.charAt(0))
                    if(dfs(board,i,j,visited,word))
                        return true;
                    else
                        continue;
            }
        return false;
    }
    
    public static boolean dfs(char[][] board,int i,int j,boolean[][] visited,String word){
        if(word.length() == 1){
            if(board[i][j] == word.charAt(0))
                return true;
            else
                return false;
        }
        visited[i][j] = true;
        if(i>0 && !visited[i-1][j] && board[i-1][j] == word.charAt(1)){
            if(dfs(board,i-1,j,visited,word.substring(1)))
                return true;
        }
        if(j>0 && !visited[i][j-1] && board[i][j-1] == word.charAt(1)){
            if(dfs(board,i,j-1,visited,word.substring(1)))
                return true;
        }
        if(i<board.length-1 && !visited[i+1][j] && board[i+1][j] == word.charAt(1)){
            if(dfs(board,i+1,j,visited,word.substring(1)))
                return true;
        }
        if(j<board[0].length-1 && !visited[i][j+1] && board[i][j+1] == word.charAt(1)){
            if(dfs(board,i,j+1,visited,word.substring(1)))
                return true;
        }
        visited[i][j] = false;
        return false;
            
            
    }
    
    public static void main(String args[]){
    	char[][] a = {{'C','A','A'},{'A','A','A'},{'B','C','D'}};
    	String b = "AAB";
    	
    	System.out.println(exist(a,b));
    }

}
