/* Dieder is making a new algorithm for robotic vacuum cleaner. Robot will be given a set of commands in the form of directions and distances. The robot will move in tracks according to the given commands. You need to find if there is any intersection between various paths. If any intersection exists, you need to find the track during which intersections occurs for the first time.
[Input] First number will be number of test cases present in input fileFor each test case, a number denoting number of commands N (1-100) is given. In next N lines, space separated direction and distance values for each command are given. 1/2/3/4 represents North/South/East/West direction respectively. The distance for each individual track can be from 1 to 100000.
[Output]  For each test case, print "Case #" followed by test case number. In next line, print the track number during which first intersection happens. If there is no intersection, print -1.
[Sample Input]
2
4
3 4
1 2
4 2
2 4
5
3 2
1 3
4 4
2 5
3 7
[Sample Output] 
Case #1
4
Case #2
-1 
*/

import java.util.*;import java.lang.*;
public class Solution { 
static int a=1000000/2;  
static int b=1000000/2; 
boolean traverse(int visited[][], int dir, int dist) { 
if(dir==1) { 
for(int i=a-1; i>=a-dist; i--) { 
if(visited[i][b]==1) return false; 
else visited[i][b]=1; 
} 
a=a-dist; 
} else if(dir==2) { 
for(int i=a+1; i<=a+dist; i++) { 
if(visited[i][b]==1) return false; 
else visited[i][b]=1; 
} a=a+dist; 
} else if(dir==3) { 
for(int i=b+1; i<=b+dist; i++) { 
if(visited[a][i]==1) return false; 
else visited[a][i]=1; 
} 
b=b-dist; 
} else if(dir==4) { 
for(int i=b-1; i>=b-dist; i--) { 
if(visited[a][i]==1) return false; 
else visited[a][i]=1; } b=b-dist; 
} return true; 
}
public static void main(String[] args) {
int n=4;
int cmd={{3, 4},   {1, 2},   {4, 2},   {2, 4} };   
boolean detect=false;   
int visited[][]=new int [1000000][1000000];      
for(int i=0;i<cmd.size();i++) {   
int dir=cmd[i][0];   
int dist=cmd[i][1];   
if(traverse(visited, dir, dist)==false) {   
System.out.println("The intersection happens on track "+(i+1));   
detect=true;   
break;   
}   
}   
if(detect!=true) System.out.println("No intersection");
}
}
