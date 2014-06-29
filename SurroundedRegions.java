import java.util.*;

public class SurroundedRegions {
	public void solve(char[][] board) {
        if(board.length == 0||board == null)
            return;
        //check all four edges, set all open regions to 'P'
        for(int i=0;i<board[0].length;i++){
            if(board[0][i] == 'O')
                bfs(0,i,board);
        }
        for(int i=0;i<board.length;i++){
            if(board[i][0] == 'O')
                bfs(i,0,board);
        }
        for(int i=0;i<board.length;i++){
            if(board[i][board[0].length-1] == 'O')
                bfs(i,board[0].length-1,board);
        }
        for(int i=0;i<board[0].length;i++){
            if(board[board.length-1][i] == 'O')
                bfs(board.length-1,i,board);
        }
        
        //change 'O' to 'X' and change 'P' back to 'O'
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
                if(board[i][j] == 'P')
                    board[i][j] = 'O';
            }
        }
    }
    
    //change all open region to "P"
    public void bfs(int i,int j,char[][] board){
        point p = new point(i,j);
        Queue<point> q = new LinkedList<point>();
        q.offer(p);
        while(!q.isEmpty()){
            point p2 = q.poll();
            if(p2.x < 0||p2.y < 0||p2.x > board.length - 1||p2.y > board[0].length - 1||board[p2.x][p2.y] != 'O')
                continue;
            else{
                board[p2.x][p2.y] = 'P';
                q.offer(new point(p2.x-1,p2.y));
                q.offer(new point(p2.x,p2.y-1));
                q.offer(new point(p2.x+1,p2.y));
                q.offer(new point(p2.x,p2.y+1));
            }
        }
    }
    
}
class point{
    int x;
    int y;
    public point(int x,int y){
        this.x = x;
        this.y = y;
    }

}
