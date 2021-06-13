package leetcode;

public class Ques79 {

	public static void main(String[] args) {
		//int[] arr = {1,2,3};
	}


	boolean[][] check;
    public boolean exist(char[][] board, String word) {
        
        int n = board.length;
        int m = board[0].length;
        check = new boolean[n][m];
        boolean res = false;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){              
                if(board[i][j] == word.charAt(0)){
                    res = dfs(board,n,m,i,j,word,0);
                    if(res){
                        return res;
                    }
                }
            }

        }
        return res;
    }

    public boolean dfs(char[][] board, int n,int m,int i, int j,String word,int cur) {
        if(i<0 || i>=n || j<0 || j>=m){
            return false;
        }
        if(board[i][j] == word.charAt(cur) && !check[i][j]){
            boolean flag = false;
            check[i][j] = true;
            if(cur == word.length()-1){
                flag = true;
            } else {
                flag = dfs(board,n,m,i+1,j,word,cur+1) || dfs(board,n,m,i-1,j,word,cur+1)
                    || dfs(board,n,m,i,j+1,word,cur+1) || dfs(board,n,m,i,j-1,word,cur+1);
               
            }
            check[i][j] = false;
            return flag;
        }
        return false;
    }
}
