/*
Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero), return the maximum enemies you can kill using one bomb.
The bomb kills all the enemies in the same row and column from the planted point until it hits the wall since the wall is too strong to be destroyed.
Note: You can only put the bomb at an empty cell.

Example:

Input: [["0","E","0","0"],["E","0","W","E"],["0","E","0","0"]]
Output: 3
Explanation: For the given grid,

0 E 0 0
E 0 W E
0 E 0 0

Placing a bomb at (1,1) kills 3 enemies.

 */

public class BombEnemy_361 {
    static int  enemyCount = 0;
    public int maxKilledEnemies(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        for(int i=0; i<m; i++){
            enemyCount =0;
            for(int j=0; j<n; j++) // left to right
                calculateEnemey(grid, i, j, dp);

            enemyCount = 0;
            for(int j=n-1; j>=0; j--) // left to right
                calculateEnemey(grid, i, j, dp);

        }

        for(int j=0; j<n; j++){
            enemyCount =0;
            for(int i=0; i<m;i++) // left to right
                calculateEnemey(grid, i,j, dp);

            enemyCount =0;
            for(int i=m-1; i>=0;i--) // left to right
                calculateEnemey(grid, i,j, dp);

        }
        int res = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n;j++)
                res = Math.max(res, dp[i][j]);
        }

        return res;

    }

    private void calculateEnemey(char[][] grid, int i , int j, int[][] dp){

        if(grid[i][j] == '0')
            dp[i][j] += enemyCount;
        else if (grid[i][j] == 'E')
            enemyCount++;
        else if(grid[i][j] == 'W')
            enemyCount = 0;

    }

    public static void main(String[] args){
        BombEnemy_361 bombEnemy = new BombEnemy_361();
        char[][] grid = {{'0','E','0','0'},{'E','0','W','E'},{'0','E','0','0'}};
        System.out.println(bombEnemy.maxKilledEnemies(grid));
    }

}
