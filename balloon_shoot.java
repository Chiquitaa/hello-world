/* 
There will be a N Balloons marked with value Bi (where B(i…N)).
User will be given Gun with N Bullets and user must shot N times.
When any balloon explodes then its adjacent balloons becomes next to each other.
User has to score highest points to get the prize and score starts at 0.

Below is the condition to calculate the score.

When Balloon Bi Explodes then score will be a product of Bi-1 & Bi+1 (score = Bi-I * Bi+1).
When Balloon Bi Explodes and there is only left Balloon present then score will be Bi-1.
When Balloon Bi Explodes and there is only right Balloon present then score will be Bi+1.
When Balloon Bi explodes and there is no left and right Balloon present then score will be Bi.


Write a program to score maximum points.

Conditions:
Execution time limits 3 seconds.
No of Balloons N, where 1 <= N <= 10
Bi value of the Balloon 1 <= Bi <= 1000.
No two Balloons explode at same time.
*/

package practice;
import java.util.*;
public class Solution {
	static int large=0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
ArrayList<Integer> q=new ArrayList<Integer>();
System.out.println("start time "+ System.nanoTime());
//245 108 162 400 274 358 366 166
q.add(245);
q.add(108);
q.add(162);
q.add(400);
q.add(274);
q.add(358);
q.add(366);
q.add(166);
if(q.size()==1) System.out.println("Sum is "+ q.get(0));
if(q.size()==2) {
	int maxx=q.get(0)>q.get(1)? 2*q.get(0):2*q.get(1);
	System.out.println("the ans is "+maxx);
}

int ans=prog(q);
System.out.println("start time "+ System.nanoTime());
	System.out.println(ans);
	}
	
	static int prog(ArrayList<Integer> q) {
		large=0;
		rec(q,0);
		return large;
	}
	
	static void rec(ArrayList<Integer> q, int sum){
		if(q.size()==0) {
			if(sum>large) large=sum;
			return;
		}
		for(int i=0;i<q.size(); i++) {
			int temp=q.get(i);
			int summ=0;
			if(q.size()==1) {
				q.remove((Object)temp);
				summ=sum+temp;
				rec(q,summ);
				q.add(temp);
			} else if(i==0) {
				summ=sum+q.get(1);
				q.remove((Object)temp);
				rec(q,summ);
				q.add(0,temp);
			} else if(i==q.size()-1) {
				summ=sum+q.get(i-1);
				q.remove((Object)temp);
				rec(q,summ);
				q.add(temp);
			} else {
				summ=sum+q.get(i-1)*q.get(i+1);
				q.remove((Object)temp);
				rec(q,summ);
				q.add(i,temp);
			}
			
		}
		
	}

}
