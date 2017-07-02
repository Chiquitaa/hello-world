/*
We have a game where an airplane is placed in the middle column of the bottom row. The airplane can move right
or left by one step and in every step the row moves down. When the airplane meets ‘1’ (coin) the number of
points increase by 1 and when the airplane meets ‘2’ (bomb) the number of points decrease by 1. Whenever the
airplane meets the bomb with score 0 the airplane dies and game is over. The user has one detonate option
throughout the game where he can detonate all the bombs in the next 5 rows. Find the maximum number of
points (coins) that can be collected by the user. Number of rows 1 <= N <= 12. Return -1 if score < 0

SAMPLE INPUT
The first line denotes the number of test cases and the second line denotes the number of rows. 
3

7

1 2 0 0 1

2 0 0 1 0

0 1 2 0 1

1 0 0 2 1

0 2 1 0 1

0 1 2 2 2

1 0 1 1 0

5

1 1 0 0 0

1 2 2 2 1

1 1 2 2 1

2 2 2 1 2

2 2 0 2 0

6

2 2 2 2 2

0 0 0 0 0

0 0 2 0 0

2 0 0 0 2

0 0 0 0 0

1 2 2 2 1

SAMPLE OUTPUT
6

3

-1

*/

package windowbomb;

public class soumyaQ {
static int max=-1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int grid[][]={{2, 2, 2, 2, 2},
{0, 0, 0, 0, 0},
{0, 0, 2, 0, 0},
{2, 0, 0, 0, 2},
{0, 0, 0, 0, 0},
{1, 2, 2, 2, 1}};
int n=grid.length;

for(int i=n-1; i>=4; i--) {
	int test[][]=new int[grid.length][grid[0].length];
	for(int k=0; k<grid.length; k++) {
		for(int l=0; l<grid[0].length; l++) {
			//System.out.println("k "+k+" l "+l);
		test[k][l]=grid[k][l];	
		}
	}
	detonate(test,i);
	
	dfs(test,n-1,2,0);
	
}
System.out.println("Max value is "+max);
	}
	
	static void dfs(int grid[][], int x, int y, int coins){
			
		if(y<0 || y>4) return;
		
		//System.out.println("i is "+x+" j is "+y+" coins "+coins);
		
		if(x<0) {
			max=coins>max?coins:max;
			return;
		}
				
			//if(coins<0-x) return;
		
		if(grid[x][y]==2) coins=coins-1;
		if(grid[x][y]==1) coins=coins+1;
		
		//int count=coins;
		dfs(grid,x-1,y-1,coins);
		//count=coins;
		dfs(grid,x-1,y,coins);
		//count=coins;
		dfs(grid,x-1,y+1,coins);
	}
	
	static void detonate(int grid[][], int row) {
		int n=grid.length;
		//System.out.println(row);
		for(int i=row; i>row-5; i--) {
			for(int j=0; j<5; j++) {
				//System.out.println("detonate row "+i+" column "+j+" value "+grid[i][j]);
				if(grid[i][j]==2) grid[i][j]=0;
			}
		}
	}

}
