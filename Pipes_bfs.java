//PIPES SWC-12/* There is a network of pipes in a city. These pipes need to be checked. To check this, we have an endoscope, which have a given length. The location from where we have to start with endoscope is given. We have to put the endoscope from given starting point and find out the maximum number of pipes which can be checked, using the endoscope. There are 7 types of pipe. Below are the type of pipes and an example of pipe network: 
/*
Input:  1st line will contain number of test cases T;    T<=50M and N – number of Rows and columns of the matrix; 3<M,N<=50Starting point R(Row index),C(column index);  0<=R,C<=M,NLength of endoscope L;      1<=L
Starting point will always have some pipe.Matrix will contain 0 if there is no pipe; else pipe type number will be thereTM N R C LMatrix
Example:16 6 2 2 62 0 0 0 0 03 0 0 0 0 01 2 1 2 2 43 0 3 0 0 33 0 1 2 2 6 0 0 0 0 0 0
Output:You have to print the maximum number of pipes that can be checked#Case1: 15#Case2: 13#Case3: 10#Case4: 27#Case5: 23 */

import java.lang.*;
import java.util.*;
class Queue{ 
  int start; 
  int end; 
  int len; 
  int size;
  int queue[];
  Queue(int x) {
    queue=new int[x];
    start=-1;
    end=-1;
  }
void add(int data) {
  if(start==-1 || end==-1) {
    start=0;
    end=0;
    queue[start]=data;
  } else {
    end++;
    queue[end]=data;
  }
}
int remove() {
  if(end==start) {
    int temp=end;
    end=-1;
    start=-1;
    return queue[temp];
  } else { 
    start++; 
    return queue[start-1];
}}
  int size() {
    if(start!=-1 && end!=-1) 
      return end-start+1;
    else return 0;
  }
}
public class Solution {  
  static int maxlength(int grid[][], int length, int startx, int starty) { 
    int m=grid.length; 
    int n=grid[0].length; 
    int visited[][]=new int[m][n]; 
    Queue queuex=new Queue(100); 
    Queue queuey=new Queue(100); 
    queuex.add(startx); 
    queuey.add(starty); 
    queuex.add(Integer.MAX_VALUE); 
    queuey.add(Integer.MAX_VALUE); 
    int level=0; int count=0; 
    while(queuex.size>0 && level<=length) { 
      int a=queuex.remove(); 
      int b=queuey.remove(); 
      if(a==Integer.MAX_VALUE) { 
        queuex.add(Integer.MAX_VALUE); 
        queuey.add(Integer.MAX_VALUE); 
        level++; continue; 
      } 
      visited[a][b]=level; 
      count++; 
      bfs(grid,length,a,b,visited,count); 
    } 
    return count; 
  }  
  static boolean bfs(int grid[][], int length, int i, int j, int visited[][]) { 
    int m=grid.length; 
    int n=grid[0].length; 
    if(grid[i][j]==1) { 
      if(i-1>=0){ 
        if(grid[i-1][j]==1 || grid[i-1][j]==2 || grid[i-1][j]==5 || grid[i-1][j]==7) { 
          queuex.add(i-1); 
          queuey.add(j); 
        } } 
      if(j-1>=0) { 
        if(grid[i][j-1]==1 || grid[i][j-1]==3 || grid[i][j-1]==4 || grid[i][j-1]==5) { 
          queuex.add(i); 
          queuey.add(j-1); 
        } }  
      if(i+1<m) { 
        if(grid[i+1][j]==1 || grid[i+1][j]==2 || grid[i+1][j]==4 || grid[i+1][j]==6) { 
          queuex.add(i+1); 
          queuey.add(j); 
        } } 
      if(j+1<n) { 
        if(grid[i][j+1]==1 || grid[i][j+1]==3 || grid[i][j+1]==4 || grid[i][j+1]==5) { 
          queuex.add(i); 
          queuey.add(j+1); 
        } } } 
    else if(grid[i][j]==2) { 
      if(i-1>=0){ if(grid[i-1][j]==1 || grid[i-1][j]==2 || grid[i-1][j]==5 || grid[i-1][j]==7) { 
        queuex.add(i-1); 
        queuey.add(j); 
      } } if(i+1<m) { 
        if(grid[i+1][j]==1 || grid[i+1][j]==2 || grid[i+1][j]==4 || grid[i+1][j]==6) { 
          queuex.add(i+1); 
          queuey.add(j); 
        } } } 
    else if(grid[i][j]==3) { 
      if(j-1>=0) { 
        if(grid[i][j-1]==1 || grid[i][j-1]==3 || grid[i][j-1]==4 || grid[i][j-1]==5) { 
          queuex.add(i); 
          queuey.add(j-1); 
        } } 
      if(j+1<n) { 
        if(grid[i][j+1]==1 || grid[i][j+1]==3 || grid[i][j+1]==4 || grid[i][j+1]==5) { 
          queuex.add(i); 
          queuey.add(j+1); 
        } } } 
    else if(grid[i][j]==4) { 
      if(i-1>=0){ 
        if(grid[i-1][j]==1 || grid[i-1][j]==2 || grid[i-1][j]==5 || grid[i-1][j]==7) { 
          queuex.add(i-1); 
          queuey.add(j); 
        } } 
      if(j+1<n) { 
        if(grid[i][j+1]==1 || grid[i][j+1]==3 || grid[i][j+1]==4 || grid[i][j+1]==5) { 
          queuex.add(i); 
          queuey.add(j+1); 
        } } } 
    else if(grid[i][j]==5) { 
      if(i+1<m) { 
        if(grid[i+1][j]==1 || grid[i+1][j]==2 || grid[i+1][j]==4 || grid[i+1][j]==6) { 
          queuex.add(i+1); 
          queuey.add(j); 
        } } 
      if(j+1<n) { 
        if(grid[i][j+1]==1 || grid[i][j+1]==3 || grid[i][j+1]==4 || grid[i][j+1]==5) { 
          queuex.add(i); 
          queuey.add(j+1); 
        } } } 
    else if(grid[i][j]==6) { 
      if(i-1>=0){ 
        if(grid[i-1][j]==1 || grid[i-1][j]==2 || grid[i-1][j]==5 || grid[i-1][j]==7) { 
          queuex.add(i-1); 
          queuey.add(j); 
        } } 
      if(j-1>=0) { 
        if(grid[i][j-1]==1 || grid[i][j-1]==3 || grid[i][j-1]==4 || grid[i][j-1]==5) { 
          queuex.add(i); 
          queuey.add(j-1); 
        } } } 
    else if(grid[i][j]==7) { 
      if(i+1<m) { 
        if(grid[i+1][j]==1 || grid[i+1][j]==2 || grid[i+1][j]==4 || grid[i+1][j]==6) { 
          queuex.add(i+1); 
          queuey.add(j); 
        } } 
      if(j-1>=0) { 
        if(grid[i][j-1]==1 || grid[i][j-1]==3 || grid[i][j-1]==4 || grid[i][j-1]==5) { 
          queuex.add(i); 
          queuey.add(j-1); 
        } } }  } 
  public static void main(String[] args) {
    int grid[][]={{2, 0, 0, 0, 0, 0},{3, 0, 0, 0, 0, 0},{1, 2, 1, 2, 2, 4},{3, 0, 3, 0, 0, 3,},{3, 0, 1, 2, 2, 6}, {0, 0, 0, 0, 0, 0}};
    int startx=2;
    int starty=2;
    int length=6;
    if(length==0 || (startx==0 && starty==0)) 
      System.out.println("No length");
    int ans=0;
    if(ans=maxlength(grid,length,startx,endx)>0) 
      System.out.println("max length "+ans);
    else System.out.println("No traversal ->0 pipes covered");
}}





