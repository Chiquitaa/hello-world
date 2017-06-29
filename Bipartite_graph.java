//Given an adjacency matrix representation of a graph g having 0 based index your task is to complete the function isBipartite which returns true if the graph is a bipartite graph else returns false.
//Input: The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. Each test case contains an integer v denoting the no of vertices of the graph then in the next line are v*v space separated values of the adjacency matrix representation of the graph g.
//Output: For each test case in a new line output will be 1 if the graph is bipartite else 0.
//Constraints: 1<=T<=100 1<=v<=15 0<=g[][]<=1
//Example(To be used only for expected output): Input: 2 4 0 1 0 1 1 0 1 0 0 1 0 1 1 0 1 0 3 0 1 0 0 0 1 1 0 0Output: 1 0
  
  import java.lang.*;import java.util.*;class Queue{int start;int end;int size;int len;Queue(int x) {int queue[]=new int[x];start=-1;end=-1;}
void add(int val) {if(start==-1) {start=0;queue[0]=val;end=0;} else { end++; queue[end]=val;}}int remove() {start++;int temp=start-1;if(start>end) {start=-1;end=-1;}return queue[temp];}int size() {if(front==-1) return 0;else return(end-front+1);}
} class Solution{ boolean bipartite(int adjm[][]) {int visited[]=new int[adjm.length];for(int l=0; l<adjm.length; l++) {visited[l]=-1;}int now=1;int next=now;;queue.add(0);queue.add(Integer.MAX_VALUE);while(queue.size!=0) {int use=queue.remove;if(use==Integer.MAX_VALUE) {next=now-next;queue.add(Integer.MAX_VALUE);continue;}visited[use]=next;if(!bfs(use,next,adjm,visited,queue)) return false;
}return true;} 
boolean bfs(int use, int next, int adjm[][], int visited[], Queue queue) {for(int i=0;i<adjm.length; i++) {if(adjm[use][i]==1){if(visited[i]==next) return false;else if(visited[i]==1-next) continue;else queue.add(i);}}return true;}   public static void main(String args[]) { Scanner sc=new Scanner(System.in); int cases=sc.nextInt();for(int i=0;i<cases;i++) { int v=sc.nextInt(); int adjm[][]=new int[v][v]; for(int j=0; j<v; j++) { for(int k=0; k<v; k++) { int temp=sc.nextInt(); adjm[j][k]=temp; adjm[k][j]=temp; } } if(bipartite(adjm)) System.out.println("Graph is bipartite"); else System.out.println("NOT bipartite"); } }  
