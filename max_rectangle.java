/*
Given a 2D binary matrix filled with 0’s and 1’s, find the largest rectangle containing all ones and return its area.
*/

public class Solution { 
public int maxarea(int[][] in) {  
for(int i=0; i<in.length; i++) {   
for(int j=1; j<in[0].length; j++) {    
if(in[i][j]==1) in[i][j]+=in[i][j-1];   
}  }    
int curmax=0;  
int max=0;  
for(int i=0; i<in[0].length; i++) {   
for(int k=1;k<=large(in,i); k++) {    
int temp=0;    
for(int j=0; j<in.length; j++) {     
if(in[i][j]>=k) temp++;     
else {      
if(temp*k>curmax) curmax=temp*k;      
temp=0;     
}    }   }   
if(max<curmax) max=curmax;  
} 
return max; 
}  

public int large(int in[][], int ind) {  
int max=0;  
for(int i=0; i<in.length; i++) {   
if(in[i][ind]>max) max=in[i][ind];  
}  
return max; 
} }
