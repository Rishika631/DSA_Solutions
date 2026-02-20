
// //Brute force
// // time= n(for loop)* 3*2^n-1(for possible strings)
// //space=n(length of string)*3*2^n-1(possible strings)
// class Solution {

//     public void solve(int n, int k, List<String> result, StringBuilder curr){
//         if(curr.length()==n)
//         {
//             result.add(curr.toString());
//             return;
//         }
//         for(char ch='a';ch<='c';ch++)
//         {
//             if(curr.length()!=0 && curr.charAt(curr.length()-1)==ch)
//             {
//                 continue;
//             }
//             curr.append(ch);
//             solve(n,k,result,curr);
//             curr.deleteCharAt(curr.length()-1);

//         }
//     }


//     public String getHappyString(int n, int k) {
        
//         StringBuilder curr=new StringBuilder();
//         List<String> result=new ArrayList<>();
//         solve(n, k, result, curr);
//         if(result.size()<k)
//         {
//             return "";
//         }
//         return result.get(k-1);
//     }
// }


//optimized
// time= n(for loop)* 3*2^n-1(for possible strings)
//space=n(length of string)- for recurssion tree not storing the result now
class Solution {

    public void solve(int n, int k, int[] counter, StringBuilder curr, String[] result){
        if(curr.length()==n)
        {
            counter[0]+=1;
            if(counter[0]==k)
            {
                result[0]=curr.toString();
            }
            return;
        }
        for(char ch='a';ch<='c';ch++)
        {
            if(curr.length()!=0 && curr.charAt(curr.length()-1)==ch)
            {
                continue;
            }
            curr.append(ch);
            solve(n,k,counter,curr, result);
            curr.deleteCharAt(curr.length()-1);

        }
    }


    public String getHappyString(int n, int k) {
        
        StringBuilder curr=new StringBuilder();
        int[] counter={0};
        String[] result={""};
        solve(n, k, counter, curr, result);
        return result[0];
    }
}