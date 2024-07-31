class Solution {
    int dp[][];
    int n;
    int max_width;
    int solve(int books[][],int i,int width,int last_height){
        if(i==n)
            return last_height;
        
        if(dp[i][width]!=0)
            return dp[i][width];
        
        int op1 = Integer.MAX_VALUE;
        int op2 = Integer.MAX_VALUE;
        
        if(width+books[i][0] <= max_width)
        {
            op1 = solve(books,i+1,width+books[i][0],Math.max(last_height,books[i][1]));
        }
        
        op2 = last_height + solve(books,i+1,books[i][0],books[i][1]);
        
        return dp[i][width] = Math.min(op1,op2);
    }

    public int minHeightShelves(int[][] books, int shelf_width) {
        n = books.length;
        max_width = shelf_width;
        dp = new int[n+1][shelf_width+1];
        return solve(books,0,0,0);
    }
}