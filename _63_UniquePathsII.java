package leo.algorithms;

/**
 * 
 * @author zyongbo
 * @problem Follow up for "Unique Paths"
 * @problem Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * @problem An obstacle and empty space is marked as 1 and 0 respectively in the grid
 * @problem For example: There is one obstacle in the middle of a 3x3 grid as illustrated below.
 * @problem [[0,0,0],[0,1,0],[0,0,0]]
 */

public class _63_UniquePathsII {

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if(obstacleGrid==null || obstacleGrid.length==0)
			return 0;
		
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		
		int[][] path = new int[m][n];
		for(int i=0; i<n; i++) {
			if(obstacleGrid[0][i]==0)
				path[0][i] = 1;
			else {
				path[0][i] = 0;
				break; //to ensure all the grid after the obstacle to be set 0
			}
		}
		for(int j=0; j<m; j++) {
			if(obstacleGrid[j][0]==0)
				path[j][0] = 1;
			else {
				path[j][9] = 0;
				break;
			}
		}
		
		for(int i=1; i<m; i++) {
			for(int j=1; j<n; j++) {
				if(obstacleGrid[i][j]==0)
					path[i][j] = path[i-1][j] + path[i][j-1];
			}//if obstacleGrid[i][j]==1, path[i][j] = 0; for default value
		}
		return path[m-1][n-1];
	}
}
