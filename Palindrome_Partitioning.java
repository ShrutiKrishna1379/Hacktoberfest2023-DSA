// Palindrome Partitioning ----- Using Memoization 
/*Examples :  
Input: str = “ababbbabbababa” 
Output: 3 
Explanation: We need to make minimum 3 cuts, i.e., “a| babbbab| b| ababa” */

/*Expected Time Complexity: O(n*n) [n is the length of the string str]
  Expected Auxiliary Space: O(n*n)
  Constraints: 1 ≤ length of str ≤ 500*/

import java.util.Arrays;
 
public class DP_plndrm {
            
    static boolean isPlndrm(String str,int i,int j){
        while(i<j){
            if(str.charAt(i++)!=str.charAt(j--)) return false;
        }
        return true;
    }
    
    static int solve(String str,int i,int j,int t[][]){
        int l=0,r=0;
        if(i>=j) return 0;
        
        if(isPlndrm(str,i,j)==true) return 0;
        
        if(t[i][j]!=-1) return t[i][j];
        
        int mn=Integer.MAX_VALUE;
        for(int k=i;k<=j-1;k++){
           
            if(t[i][k]!=-1)  l=t[i][k];
            else{
                l=solve(str,i,k,t);
                t[i][k]=l;
            }
           
            if(t[k+1][j]!=-1)  r=t[k+1][j];
            else{
                r=solve(str,k+1,j,t);
                t[k+1][j]=r;
            }
            int temp=1+l+r;
            mn=Math.min(temp,mn);
        }
        return t[i][j]=mn;
    }

    static int palindromicPartition(String str)
    {
        int t[][]=new int[501][501];
        for(int[] a:t) Arrays.fill(a,-1);
        return solve(str,0,str.length()-1,t);
    }

    public static void main(String[] args)
    {
        String str = "ababbbabbababa";
 
        int cuts = palindromicPartition(str);
        System.out.println("Minimum cuts required: "
                           + cuts);
    }

}
