//time-O(n) as only recursion nothing else all other loops const
//space-O(n)*12(memonization) as that plus recursive stack
// basically ek row ka saare possible combo dhundho and phir usko baki saare row mai trial and error karo 
class Solution {
    int mod=1_000_000_007;
     // since 3 columns fixed we find all possible ways for 3 columns and 1 row and use this combo for further rows decision
    String[] combo={"RYR","YRY", "GRY","RYG","YRG","GRG","RGR","YGR","GYR","RGY","YGY","GYG"};// 12 as 3*2*2
    public int solve(int n,int prev, int[][] arr){         
        int result=0;
        if(n==0)
        {
            return 1;
        }
        if(arr[n][prev]!=-1)
        {
            return arr[n][prev];
        }

        for(int i=0;i<12;i++)
        {
            boolean conflict=false;
            String pre=combo[prev];
            String curr=combo[i];
            if(pre.equals(curr))
            {
                continue;
            }
            for(int j=0;j<3;j++)
            {
                if(pre.charAt(j)==curr.charAt(j))
                {
                    conflict=true;
                }
            }
            if(!conflict){
                //no same row and no conflicts then we found match for that combo
                result=(result+solve(n-1,i,arr))%mod;//checking for next row// this will give for one row all combo counts using solve method 
            }
        }
        return arr[n][prev]=result;
    }

    public int numOfWays(int n) {
         int result=0;
         int[][] arr=new int[n][12];
         for(int i=0;i<n;i++)
         {
            for(int j=0;j<12;j++)
            {
                arr[i][j]=-1;
            }
         }
         for(int i=0;i<12;i++)
         {
            result=(result+solve(n-1,i, arr))%mod;
         }
         return result;

    }
}