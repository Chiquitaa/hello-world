//Grid Acid BFS
import java.util.*;
import java.lang.*;
public class Solution{ 
  static int count1=-1; 
  static int count2=-1; 
  static int emptyx=-1; 
  static int emptyy=-1;
  public static void main(String[] args) { 
    int startx=3; 
    int starty=1; 
    int grid[][]={{1,0,1,0,1},      {1,0,1,1,1},      {1,1,2,1,1},      {1,0,1,0,1}}; 
    prog(grid, startx, starty); 
    if(count 1!=-1) { 
      filled(grid); 
    } 
    System.out.println("Test case"); 
    System.out.println(count1+" "+count2);
  }
  public static prog(int grid[][], int startx, int starty) {
    int count=0;
    Queue queuex=new Queue(10000);
    Queue queuey=new Queue(10000);
    queuex.add(startx);
    queuey.add(starty);
    queuex.add(Integer.MAX_VALUE);
    queuey.add(Integer.MAX_VALUE);
    while(queuex.size()=0) {
      int x=queuex.remove();
      int y=queuey.remove();
      if(x==Integer.MAX_VALUE) {
        count++;queuex.add(Integer.MAX_VALUE);
        queuey.add(Integer.MAX_VALUE);
        continue;
      }
      boolean empty=false;
      if(grid[x][y]==2) { 
        emptyx=x; 
        emptyy=y; 
        empty=checkempty(grid,x,y); 
        if(empty==true) grid[x][y]=-1;
      }
      bfs(grid,x,y,queuex,queuey);
    }
    count2=count;
  }
  void bfs(int grid[][], int x, int y, Queue queuex, Queue queuey) {
    if(x-1>=0) {
      if(grid[x-1][y]>0) {
        queuex.add(x-1);
        queuey.add(y);
      }}
    if(y-1>=0) {
      if(grid[x][y-1]>0) {
        queuex.add(x);
        queuey.add(y-1);
      }}
    if(x+1<grid.length) {
      if(grid[x+1][y]>0) {
        queuex.add(x+1);
        queuey.add(y);
      }}
    if(y+1<grid[0].length) {
      if(grid[x][y+1]>0) {
        queuex.add(x);
        queuey.add(y+1);
      }}
    grid[x][y]=-1;
  }
  boolean checkempty(int grid[][], int x, int y) {
    if(x-1>=0) {
      if(grid[x-1][y]!=-1) return false;
    }
    if(y-1>=0) {
      if(grid[x][y-1]!=-1) return false;
    }
    if(x+1<grid.length) {
      if(grid[x+1][y]!=-1) return false;
    }
    if(y+1<grid[0].length) {
      if(grid[x][y+1]!=-1) return false;
    }
    return true;
  }
  void filled(int grid[][]) { 
    int check=0;
    for(int i=0;i<grid.length; i++) { 
      for(int j=0; j<grid[0].length;j++) {  
        if(grid[i][j]==2) {  
          if(checkempty(grid,i,j)) grid[i][j]=-1;  
        } 
        if(grid[i][j]!=0 || grid[i][j]!=-1) { 
          count2=-1; 
          check=1; 
          break; 
        } } 
      if(check!=0) break;
    }
  }
}
