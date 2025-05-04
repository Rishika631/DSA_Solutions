// class Solution {
//     public int numEquivDominoPairs(int[][] dominoes) {
//         int res=0;
//         for(int i=0;i<dominoes.length;i++)
//         {
//             for(int j=i+1;j<dominoes.length;j++)
//             {
//                 if((dominoes[i][0]==dominoes[j][0] && dominoes[i][1]==dominoes[j][1])||(dominoes[i][0]==dominoes[j][1] && dominoes[i][1]==dominoes[j][0]))
//                 {
//                     res++;
//                 }
//             }
//         }
//         return res;
        
//     }
// }

class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] mpp = new int[100];
        for (int[] d : dominoes) 
            if (d[0] > d[1]) mpp[d[0] * 10 + d[1]]++;
            else mpp[d[1] * 10 + d[0]]++;
        
        int count = 0;
        for (int freq : mpp)
            count += (freq - 1) * freq / 2;
        
        return count;
    }
}