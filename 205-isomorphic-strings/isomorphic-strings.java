// class Solution {
//     public boolean isIsomorphic(String s, String t) {
//         char[] alphat=new char[256];
//         char[] alphas=new char[256];
//         for(int i=0;i<s.length();i++)
//         {
//             if(alphas[s.charAt(i)-'\u0000']!='\u0000' && t.charAt(i)!=alphas[s.charAt(i)-'\u0000'])
//             {
//                 return false;
//             }
//             else
//             {
//                 alphas[s.charAt(i)-'\u0000']=t.charAt(i);
//             }
//         }
//         for(int i=0;i<t.length();i++)
//         {
//             if(alphat[t.charAt(i)-'\u0000']!='\u0000' && s.charAt(i)!=alphat[t.charAt(i)-'\u0000'])
//             {
//                 return false;
//             }
//             else
//             {
//                 alphat[t.charAt(i)-'\u0000']=s.charAt(i);
//             }
//         }
//         return true;
//     }
// }
//TC->o(n)
//SC->const as char array const

//better approach
class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] alphat=new int[256];
        int[] alphas=new int[256];
        for(int i=0;i<s.length();i++)
        {
            if(alphas[s.charAt(i)]!=alphat[t.charAt(i)])
            {
                return false;
            }
            alphas[s.charAt(i)]=i+1;
            alphat[t.charAt(i)]=i+1;// this basically makes that index value to have some value so next time same char then it has already visited that cahr so equality will fail the if condition at top if it gets matched up again for a new letter

        }
        return true;
    }
}
//TC->O(n)
//SC->O(1) const size arrays if hashmap then n pr dependent

//hashmap approach
// class Solution {
//     public boolean isIsomorphic(String s, String t) {
//         if(s.length() != t.length())
//             return false;

//         HashMap<Character, Character> charMapping = new HashMap<>();
//         HashSet<Character> usedReplacements = new HashSet<>();

//         for(int i = 0; i < s.length(); i++) {
//             char original = s.charAt(i);
//             char replacement = t.charAt(i);

//             // Create a new mapping
//             if(!charMapping.containsKey(original)) {

//                 // Replacement is already mapped to another character
//                 if(usedReplacements.contains(replacement))// same t k liye do s toh nhi like s-> egf and t-> add
//                     return false;

//                 charMapping.put(original, replacement);
//                 usedReplacements.add(replacement);
//             }

//             // Existing mapping must remain consistent
//             else if(charMapping.get(original) != replacement) {//same s k liye do t toh nhi like s->egg and t->adf
//                 return false;
//             }
//         }

//         return true;
//     }
// }

//TC-> O(n)
//SC-> O(n) hashset n hashmap so 2n
